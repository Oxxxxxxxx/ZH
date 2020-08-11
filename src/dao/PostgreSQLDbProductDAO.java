package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.ProductTest;

public class PostgreSQLDbProductDAO implements ProductDAO {

	public List<ProductTest> getAllProduct() throws SQLException {
		// Write some codes here…
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;

		List<ProductTest> listofProduct = new ArrayList();
		try {
			conn = PostgreSQLDbDAOFactory.createConnection();
			stmt = conn.prepareStatement("select * from classicmodels.products order by productcode");
			rst = stmt.executeQuery();
			while (rst.next()) {
				ProductTest p = new ProductTest();
				p.setProductcode(rst.getString("productcode"));
				p.setProductname(rst.getString("productname"));
				p.setProductline(rst.getString("productline"));
				p.setProductscale(rst.getString("productscale"));
				p.setProductvendor(rst.getString("productvendor"));
				p.setProductdescription(rst.getString("productdescription"));
				p.setQuantityinstock(rst.getInt("quantityinstock"));
				p.setBuyprice(rst.getDouble("buyprice"));
				p.setMsrp(rst.getDouble("msrp"));
				listofProduct.add(p);
			}
		} finally {
			conn.close();
		}
		return listofProduct;
	}

	public ProductTest findProduct(String productcode) throws SQLException {
		//Write some codes here…
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet rst = null;
		ProductTest p = null; 
		try {
			conn = PostgreSQLDbDAOFactory.createConnection();
			stmt = conn.prepareStatement("select * from classicmodels.products where id =?"); 
			stmt.setString(1, productcode);

			rst = stmt.executeQuery(); 
			if (!rst.next()) {
			return null;


			} else {


			p = new ProductTest(); 
			p.setProductcode(rst.getString("product_code"));
			p.setProductname(rst.getString("product_name"));
			p.setProductline(rst.getString("product_line"));
			p.setProductscale(rst.getString("product_scale"));
			p.setProductvendor(rst.getString("product_vendor"));
			p.setProductdescription(rst.getString("product_description"));
			p.setQuantityinstock(rst.getInt("quantityinstock"));
			p.setBuyprice(rst.getDouble("buy_price"));
			p.setMsrp(rst.getDouble("msrp"));
			
			return p;

			}
			} finally {
				conn.close();
			}
	}
	
	
	public void updateProduct(String[] s) throws SQLException{
		//Write some codes here…
		Connection conn = null; 
		Date dob = null;
		Date hd = null;
		conn = PostgreSQLDbDAOFactory.createConnection(); 
		try {
		dob = new SimpleDateFormat("yyyy-MM-dd").parse(s[4]); hd = new SimpleDateFormat("yyyy-MM-dd").parse(s[5]);
		} catch (Exception ex) {

		}
		java.sql.Date DOB = new java.sql.Date(dob.getTime()); 
		java.sql.Date HD = new java.sql.Date(hd.getTime()); 
		try {
		String sql= "UPDATE classicmodels.products SET productname =?, productline = ?, productscale =?, "
				+ "productvendor =? productdescription = ?, quantityinstock = ?, buyprice = ?, "
				+ "msrp = ? WHERE productcode =?";
		PreparedStatement stmt = conn.prepareStatement(sql); stmt.setString(1, s[1]);
		stmt.setString(2, s[2]);
		stmt.setString(3, s[3]); 
		stmt.setDate(4, DOB); 
		stmt.setDate(5, HD);
		stmt.setInt(6, Integer.valueOf(s[0])); 
		stmt.executeUpdate();
		}finally {
		conn.close();
		}

		}
	
	public void deleteProduct(String productcode) throws SQLException
	{
	//Write some codes here…

	Connection conn = null; try {
	conn = PostgreSQLDbDAOFactory.createConnection();
	String sql= "DELETE FROM classicmodels.products WHERE productcode =?"; 
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1, productcode);
	stmt.executeUpdate();
	}finally {
	conn.close();
	}

	}
	
	public void addProduct(String[] s) throws SQLException
	{
	//Write some codes here…

	Connection conn = null; 
	Date dob = null;
	Date hd = null;
	conn = PostgreSQLDbDAOFactory.createConnection(); 
	try {
	dob = new SimpleDateFormat("yyyy-MM-dd").parse(s[4]); 
	hd = new SimpleDateFormat("yyyy-MM-dd").parse(s[5]);
	} catch (Exception ex) {

	}
	java.sql.Date DOB = new java.sql.Date(dob.getTime()); 
	java.sql.Date HD = new java.sql.Date(hd.getTime()); 
	try {
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO classicmodels.products VALUES(?,?,?,?,?,?,?,?,?)"); 
	stmt.setInt(1, Integer.valueOf(s[0]));
	stmt.setDate(2, DOB); stmt.setString(3, s[1]);
	stmt.setString(4, s[2]);
	stmt.setString(5, s[3]); stmt.setDate(6, HD);

	stmt.executeUpdate();
	}finally {
	conn.close();
	}

	}
	
	
	public int getNumberOfRows() throws SQLException {
		//Write some codes here…

		int i = 0; String s = null;
		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rst = null;
		try {
		conn = PostgreSQLDbDAOFactory.createConnection();
		stmt = conn.prepareStatement("SELECT COUNT(*) AS totalrow FROM classicmodels.products");
		rst = stmt.executeQuery(); 
		while (rst.next()) {
		s = rst.getString("totalrow");
		
		}
		i = Integer.valueOf(s); 
		}finally {
			conn.close();
		}
			return i;

	}
	
	
	public List<ProductTest> readProduct(int currentPage, int recordsPerPage) throws SQLException {

		//Write some codes here…

		List<ProductTest> listofproduct = new ArrayList();
		Connection conn = null; 
		PreparedStatement stmt = null; 
		ResultSet rst = null;
		ProductTest p = null;
		
		try {
		conn = PostgreSQLDbDAOFactory.createConnection();
		stmt = conn.prepareStatement("select * from classicmodels.products order by productcode OFFSET ? LIMIT ?");

		int start = currentPage * recordsPerPage - recordsPerPage; stmt.setInt(1, Integer.valueOf(start));
		stmt.setInt(2, Integer.valueOf(recordsPerPage)); rst = stmt.executeQuery();

		while (rst.next()) {
			
			p = new ProductTest(); 
			p.setProductcode(rst.getString("product_code"));
			p.setProductname(rst.getString("product_name"));
			p.setProductline(rst.getString("product_line"));
			p.setProductscale(rst.getString("product_scale"));
			p.setProductvendor(rst.getString("product_vendor"));
			p.setProductdescription(rst.getString("product_description"));
			p.setQuantityinstock(rst.getInt("quantityinstock"));
			p.setBuyprice(rst.getDouble("buy_price"));
			p.setMsrp(rst.getDouble("msrp"));
			listofproduct.add(p);
		}

		} finally { conn.close();
		}
		return listofproduct;
		}
	
	
}
	

