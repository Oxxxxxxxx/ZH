package domain;

import java.util.Date;

public class ProductTest {
	private String productcode;
	private String productname;
	private String productline;
	private String productscale;
	private String productvendor;
	private String productdescription;
	private int quantityinstock;
	private double buyprice;
	private double msrp;
	
	public ProductTest(String productcode, String productname, String productline,
			String productscale, String productvendor, String productdescription, 
			int quantityinstock, double buyprice, double msrp) {
		super(); 
		this.productcode = productcode;
		this.productname = productname; 
		this.productline = productline; 
		this.productscale = productscale; 
		this.productvendor = productvendor; 
		this.productdescription = productdescription;
		this.quantityinstock = quantityinstock;
		this.buyprice = buyprice;
		this.msrp = msrp;
		}
	
	public ProductTest() {

	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductline() {
		return productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getProductscale() {
		return productscale;
	}

	public void setProductscale(String productscale) {
		this.productscale = productscale;
	}

	public String getProductvendor() {
		return productvendor;
	}

	public void setProductvendor(String productvendor) {
		this.productvendor = productvendor;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public int getQuantityinstock() {
		return quantityinstock;
	}

	public void setQuantityinstock(int quantityinstock) {
		this.quantityinstock = quantityinstock;
	}

	public double getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(double buyprice) {
		this.buyprice = buyprice;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	
	
	
	
}
