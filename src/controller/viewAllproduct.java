package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class viewAllproduct
 */
@WebServlet("/viewAllproduct")
public class viewAllproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO pro_dao = new PostgreSQLDbDAOFactory().getProductDAO(); 
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		
		try {
			
			List<ProductTest> pro = pro_dao.getAllProduct();
			

			
			request.setAttribute("products", pro);
			
		}catch(SQLException ex) {
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct.jsp"); 
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
