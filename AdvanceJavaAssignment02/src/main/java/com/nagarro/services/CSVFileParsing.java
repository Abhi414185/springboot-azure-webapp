package com.nagarro.services;


import java.util.List;

import com.nagarro.entity.Tshirts;

public interface CSVFileParsing {
	
	List<Tshirts> parser(String f);

}
