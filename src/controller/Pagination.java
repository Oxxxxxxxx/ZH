package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostgreSQLDbDAOFactory;
import dao.ProductDAO;
import domain.ProductTest;

/**
 * Servlet implementation class Pagination
 */
@WebServlet("/Pagination")
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		//Write some codes here…

		int nOfPages= 0;
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage")); 
		ProductDAO pro_dao = new PostgreSQLDbDAOFactory().getProductDAO(); 
		try {
		List<ProductTest> lists = pro_dao.readProduct(currentPage, recordsPerPage); 
		request.setAttribute("products", lists);
		int rows = pro_dao.getNumberOfRows();
		nOfPages = rows / recordsPerPage; 
		System.out.println("At servlet" + nOfPages); 
		nOfPages++;

		} catch (SQLException ex) {

		}

		request.setAttribute("noOfPages", nOfPages); 
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("recordsPerPage", recordsPerPage);

		RequestDispatcher dispatcher = request.getRequestDispatcher("pagination.jsp"); 
		dispatcher.forward(request, response);
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
