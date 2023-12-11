package Banxemay.models;

import java.io.Serializable;

public class ProductModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productID;
	private String productName;
	private String desc;
	private int price;
	private String imageLink;
	private int categoryID;
	private int sellerID;
	private int amount;
	private int stoke;
	private int total;
	private CategoryModels category;

	public ProductModel() {
		super();
	}

	public ProductModel(int productID, String productName, String desc, int price, String imageLink, int categoryID,
			int sellerID, int amount, int stoke, CategoryModels category) {
		super();
		this.productName = productName;
		this.desc = desc;
		this.price = price;
		this.imageLink = imageLink;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
		this.stoke = stoke;
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public CategoryModels getCategory() {
		return category;
	}

	public void setCategory(CategoryModels category) {
		this.category = category;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ProductModel(int categoryID, int total) {
		super();
		this.categoryID = categoryID;
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProductModel [productID=" + productID + ", productName=" + productName + ", desc=" + desc + ", price="
				+ price + ", imageLink=" + imageLink + ", categoryID=" + categoryID + ", sellerID=" + sellerID
				+ ", amount=" + amount + ", stoke=" + stoke + ", total=" + total + ", category=" + category + "]";
	}

}
