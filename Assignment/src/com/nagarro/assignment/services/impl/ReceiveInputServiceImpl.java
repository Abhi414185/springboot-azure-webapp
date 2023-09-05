package com.nagarro.assignment.services.impl;
import java.util.Scanner;

import com.nagarro.assignment.constants.Constants;
import com.nagarro.assignment.entity.Car;
import com.nagarro.assignment.exceptions.CarDataException;
import com.nagarro.assignment.exceptions.InsuranceDataExceptions;
import com.nagarro.assignment.services.ReceiveInputService;

public class ReceiveInputServiceImpl implements ReceiveInputService {
	

	void checkCarType(String s) throws CarDataException{
		
		if(s.equalsIgnoreCase(Constants.HATCHBACK)|| s.equalsIgnoreCase(Constants.SEDAN)|| s.equalsIgnoreCase(Constants.SUV))
			return;
		else
			throw new CarDataException("Wrong car type");
	}
	
	void checkInsuranceType(String s) throws InsuranceDataExceptions{
		
		if(s.equalsIgnoreCase(Constants.BASIC)|| s.equalsIgnoreCase(Constants.PREMIUM))
			return;
		else
			throw new InsuranceDataExceptions("Wrong insurance type");
	}

	@Override
	public Car receiveInput() {
		Car c = new Car();
		Scanner a=new Scanner(System.in);
		System.out.println(Constants.ASKING_CAR_MODEL);
		c.setCarModel(Integer.parseInt(a.nextLine()));
		System.out.println(Constants.ASKING_CAR_TYPE);
		try {
			String carType=a.next();
			this.checkCarType(carType);
			c.setCarType(carType);
		}catch(CarDataException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		System.out.println(Constants.ASKING_INSURANCE_TYPE);
		try {
			String insuranceType=a.next();
			this.checkInsuranceType(insuranceType);
			c.setInsuranceType(insuranceType);
		}catch (InsuranceDataExceptions e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		System.out.println(Constants.ASKING_COST_PRICE);
		c.setCarCost(a.nextInt());
		return c;	
	}

}
