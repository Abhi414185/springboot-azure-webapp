package com.nagarro.assignment.util;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.assignment.entity.TShirt;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVParser {
	public List<TShirt> parser(String fileName){
		List<TShirt> obList=null;
		try {
			com.opencsv.CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(parser).withSkipLines(1).build();
			
				obList=reader.readAll().stream().map(data-> {
                TShirt ob= new TShirt();
                ob.setId(data[0]);
                ob.setName(data[1]);
                ob.setColor(data[2]);
                ob.setGender(data[3]);
                ob.setSize(data[4]);
                ob.setPrice(data[5]);
                ob.setRating(data[6]);
                ob.setAvailability(data[7]);
                return ob;
            }).collect(Collectors.toList());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obList;
	}
}
