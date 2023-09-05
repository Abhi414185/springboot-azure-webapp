package com.nagarro.assignment.api;

import java.util.*;

import com.nagarro.assignment.constants.Constants;
import com.nagarro.assignment.entity.Car;
import com.nagarro.assignment.services.impl.CarDisplayServiceImpl;
import com.nagarro.assignment.services.impl.InsuranceCalculationServiceImpl;
import com.nagarro.assignment.services.impl.ReceiveInputServiceImpl;

public class InsuranceCalculatorAPI {
	
	public static void main(String[]args) {
		
		while(true) {
		Car c=new ReceiveInputServiceImpl().receiveInput();
		new InsuranceCalculationServiceImpl().calculateInsurance(c);
		new CarDisplayServiceImpl().CarDetailsDisplay(c);
		
		Scanner a=new Scanner(System.in);
		
		System.out.println(Constants.NEW_CAR_DETAILS);
		String ans=a.nextLine();
		String answer=ans.toLowerCase();
		if(!answer.equals("y"))
			break;
		
		
		}
		
	}

}
