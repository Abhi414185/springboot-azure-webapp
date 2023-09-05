package com.nagarro.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "tshirt")
public class TShirt {
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private String price;
	private String rating;
	private String availability;
	
	@Transient
	private int outputPreference;
	
	
	public TShirt(String color, String gender, String size, int outputPreference) {
		super();
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.outputPreference = outputPreference;
	}
	public TShirt() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(int outputPreference) {
		this.outputPreference = outputPreference;
	}
	
	@Override
	public String toString() {
		return "TShirt [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availability=" + availability + ", outputPreference="
				+ outputPreference + "]";
	}
	
	
}