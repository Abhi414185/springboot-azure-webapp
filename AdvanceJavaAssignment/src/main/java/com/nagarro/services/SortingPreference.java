package com.nagarro.services;

import java.util.List;

import com.nagarro.entity.Tshirts;

public interface SortingPreference {
	
	List<Tshirts> preferenceOutput(Tshirts customer, List<Tshirts> list);

}
