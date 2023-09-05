package com.nagarro.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productID;
	private String title;
	private int quantity;
	private int size;
	
	@Lob
	private byte[] image;
	
	@Transient
	private String base64Image;
	
	public Item() {
	
	}
	
	
	public Item(int productID, String title, int quantity, int size, byte[] image, String base64Image) {
		super();
		this.productID = productID;
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.image = image;
		this.base64Image = base64Image;
	}


	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
	@Override
	public String toString() {
		return "Item [productID=" + productID + ", title=" + title + ", quantity=" + quantity + ", size=" + size
				+ ", image=" + Arrays.toString(image) + ", base64Image=" + base64Image + "]";
	}
	
	
	
	
}
