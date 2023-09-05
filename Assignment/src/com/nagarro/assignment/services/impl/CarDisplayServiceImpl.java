package com.nagarro.assignment.services.impl;

import com.nagarro.assignment.entity.Car;

public class CarDisplayServiceImpl {
	
	public void CarDetailsDisplay(Car c) {
		
		System.out.println("Car Model:"+c.getCarModel());
		System.out.println("Car Type:"+c.getCarType());
		System.out.println("Car price:"+c.getCarCost());
		System.out.println("Total Insurance:"+c.gettotalInsurance());
	}
}
