package com.nagarro.api;

import java.util.List;


import com.nagarro.db.ShirtsDB;
import com.nagarro.entity.Tshirts;
import com.nagarro.servicesimpl.CSVFileParsingImpl;
import com.nagarro.servicesimpl.DisplayImpl;
import com.nagarro.servicesimpl.RequirementsOfInputImpl;
import com.nagarro.servicesimpl.SortingPreferencesImpl;
import com.nagarro.servicesimpl.ProcessRequestImpl;

public class App {
	public static void main(String[] args) {
		
		
		List<Tshirts> shirts;
		CSVFileParsingImpl csvObj = new CSVFileParsingImpl();
		shirts = csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Adidas.csv");
		shirts.addAll(csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Nike.csv"));
		shirts.addAll(csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Puma.csv"));
		ShirtsDB db = new ShirtsDB();
		db.addList(shirts);
		
		Tshirts customerTShirt = new RequirementsOfInputImpl().input();
		List<Tshirts> reqList = new ProcessRequestImpl().processReq(customerTShirt, shirts);
		List<Tshirts> preference = new SortingPreferencesImpl().preference(customerTShirt, reqList);
		if (preference.isEmpty()) {
			System.out.println("Your choice is not available right now!");
		} else {
			new DisplayImpl().show(preference);
		}
	}

}
