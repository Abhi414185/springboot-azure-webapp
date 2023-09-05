package com.nagarro.assignment.util;

import java.util.List;

import com.nagarro.assignment.entity.TShirt;

public class DataLoader {
	
	
	
	public List<TShirt> loader(){
		
		List<TShirt> shirts;
		CSVParser csvObj = new CSVParser();
		shirts = csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Adidas.csv");
		shirts.addAll(csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Nike.csv"));
		shirts.addAll(csvObj.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Puma.csv"));
		System.out.println(shirts);
		return shirts;
		//new TShirtDao().loadOne(shirts.get(0));
	}

}
