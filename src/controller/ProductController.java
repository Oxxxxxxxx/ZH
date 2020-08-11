package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostgreSQLDbDAOFactory;
import dao.ProductDAO;
import domain.ProductTest;
import utilities.ValidateManageLogic;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String productcode = request.getParameter("productcode");
		ProductDAO pro_dao = new PostgreSQLDbDAOFactory().getProductDAO();
		try {
		ProductTest pro = pro_dao.findProduct(productcode); 
		request.setAttribute("PRO", pro);
		RequestDispatcher req = request.getRequestDispatcher("ProductUpdate.jsp"); 
		req.forward(request, response);
		} catch (SQLException ex) {
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String product_code = request.getParameter("productcode");
		String product_name = request.getParameter("productname");
		String product_line = request.getParameter("productline");
		String product_scale = request.getParameter("productscale");
		String product_vendor = request.getParameter("productvendor");
		String product_description = request.getParameter("productdescription");
		String quantityinstock = request.getParameter("quantityinstock");
		String buy_price = request.getParameter("buyprice");
		String msrp = request.getParameter("msrp");
		
		
		
		PrintWriter out = response.getWriter();
		// this line is to package the whole values into one array string variable -
		// easier just pass one parameter object
		String[] s = { product_code, product_name, product_line, product_scale, product_vendor, product_description, quantityinstock, buy_price, msrp };
		ProductDAO pro_dao = new PostgreSQLDbDAOFactory().getProductDAO(); 
		try {
		if (ValidateManageLogic.validateManageTrainer(request).equals("UPDATE")) {
		// call session bean updateEmployee method empdao.updateEmployee(s);
			pro_dao.updateProduct(s);
		}
		else if (ValidateManageLogic.validateManageTrainer(request).equals("DELETE")) {
		// call session bean deleteEmployee method empdao.deleteEmployee(eid);
		// if ADD button is clicked
			pro_dao.deleteProduct(product_code);
		} else {
		// call session bean addEmployee method empdao.addEmployee(s);
			pro_dao.addProduct(s);
		}
		// this line is to redirect to notify record has been updated and redirect to
		// another page ValidateManageLogic.navigateJS(out);
		ValidateManageLogic.navigateJS(out);
		} catch (SQLException ex) {
		}
		
		//doGet(request, response);
	}

}
