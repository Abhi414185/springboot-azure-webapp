package com.nagarro.assignment.services.impl;

import com.nagarro.assignment.entity.Car;
import com.nagarro.assignment.services.InsuranceCalculationService;

public class InsuranceCalculationServiceImpl implements InsuranceCalculationService {

	@Override
	public void calculateInsurance(Car c) {

		switch (c.getCarType()) {

		case "hatchback":

			switch (c.getInsuranceType()) {

			case "basic":
				c.setBasicInsurance(0.05 * c.getCarCost());
				c.settotalInsurance(c.getBasicInsurance());
				break;

			case "premium":
				c.setBasicInsurance(0.05 * c.getCarCost());
				c.setPremiumInsurance(c.getBasicInsurance() + (0.2 * c.getBasicInsurance())) ;
				c.settotalInsurance(c.getPremiumInsurance());
				break;
			}
			break;

		case "sedan":

			switch (c.getInsuranceType()) {

			case "basic":
				c.setBasicInsurance(0.08 * c.getCarCost());
				c.settotalInsurance(c.getBasicInsurance());
				break;

			case "premium":
				c.setBasicInsurance(0.08 * c.getCarCost());
				c.setPremiumInsurance(c.getBasicInsurance() + (0.2 * c.getBasicInsurance())) ;
				c.settotalInsurance(c.getPremiumInsurance());
				break;
			}
			break;

		case "suv":

			switch (c.getInsuranceType()) {

			case "basic":
				c.setBasicInsurance(0.1 * c.getCarCost());
				c.settotalInsurance(c.getBasicInsurance());
				break;

			case "premium":
				c.setBasicInsurance(0.1 * c.getCarCost());
				c.setPremiumInsurance(c.getBasicInsurance() + (0.2 * c.getBasicInsurance())) ;
				c.settotalInsurance(c.getPremiumInsurance());
				break;
			}
			break;

		default:
			System.out.println("Wrong Car Type Entered");

		}
	}

}
