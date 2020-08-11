package dao;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import domain.ProductTest;



public interface ProductDAO {

	public List<ProductTest> getAllProduct() throws SQLException;
	
	public ProductTest findProduct(String productcode) throws SQLException;

	public void updateProduct(String[] s) throws SQLException;

	public void deleteProduct(String id) throws SQLException;

	public void addProduct(String[] s) throws SQLException;
	
	public int getNumberOfRows() throws SQLException;
	
	public List<ProductTest> readProduct(int currentPage, int recordsPerPage) throws SQLException;
	
}
