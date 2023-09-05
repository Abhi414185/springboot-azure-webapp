package com.nagarro.servicesimpl;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.entity.Tshirts;
import com.nagarro.services.CSVFileParsing;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVFileParsingImpl implements CSVFileParsing {
	public List<Tshirts> parser(String fileName){
		List<Tshirts> obList=null;
		try {
			com.opencsv.CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(parser).withSkipLines(1).build();
			
				obList=reader.readAll().stream().map(data-> {
                Tshirts obj= new Tshirts();
                obj.setId(data[0]);
                obj.setName(data[1]);
                obj.setColor(data[2]);
                obj.setGender(data[3]);
                obj.setSize(data[4]);
                obj.setPrice(data[5]);
                obj.setRating(data[6]);
                obj.setAvailability(data[7]);
                return obj;
            }).collect(Collectors.toList());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obList;
	}
}