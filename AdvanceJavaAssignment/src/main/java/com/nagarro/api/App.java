package com.nagarro.api;

import java.io.IOException;
import java.util.List;
import com.nagarro.constants.ConstantsUsed;
import com.nagarro.entity.*;
import com.nagarro.servicesimpl.*;

public class App {
	
	public static void main(String[] args) throws IOException {

		CSVFileParsingImpl a = new CSVFileParsingImpl();
		List<Tshirts> parser = a.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Adidas.csv");
		parser.addAll(a.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Nike.csv"));
		parser.addAll(a.parser("C:\\Users\\abhirajgope\\Desktop\\Advance Java 1 CSV Files\\Puma.csv"));
		Tshirts User = new RequirementsOfInputImpl().input();

		List<Tshirts> requestList = new ProcessRequestImpl().processReq(User, parser);
		List<Tshirts> preferenceOutput = new SortingPreferencesImpl().preferenceOutput(User, requestList);
		if (preferenceOutput.isEmpty()) {
			System.out.println(ConstantsUsed.SHOWING_WRONG_PREFERENCE_OPTION);
		} else {
			new DisplayImpl().show(preferenceOutput);
		}

	}

}

