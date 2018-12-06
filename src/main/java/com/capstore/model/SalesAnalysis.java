package com.capstore.model;

public class SalesAnalysis {

	private String productCategory;
	private String merchant;
	private long productQuantity;
	private long productSales;
	private double salesPercent;
	public SalesAnalysis(String productCategory, String merchant, long productQuantity, long productSales,
			double salesPercent) {
		super();
		this.productCategory = productCategory;
		this.merchant = merchant;
		this.productQuantity = productQuantity;
		this.productSales = productSales;
		this.salesPercent = salesPercent;
	}
	
	public SalesAnalysis()	{}
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public long getProductSales() {
		return productSales;
	}
	public void setProductSales(long productSales) {
		this.productSales = productSales;
	}
	public double getSalesPercent() {
		return salesPercent;
	}
	public void setSalesPercent(double salesPercent) {
		this.salesPercent = salesPercent;
	}
	@Override
	public String toString() {
		return "SalesAnalysis [productCategory=" + productCategory + ", merchant=" + merchant + ", productQuantity="
				+ productQuantity + ", productSales=" + productSales + ", salesPercent=" + salesPercent + "]";
	}
	
	
	
}
