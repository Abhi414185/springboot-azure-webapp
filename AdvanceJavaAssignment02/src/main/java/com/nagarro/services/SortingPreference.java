package com.nagarro.services;

import java.util.List;

import com.nagarro.entity.Tshirts;

public interface SortingPreference {
	
	List<Tshirts> preference(Tshirts customer, List<Tshirts> list);

}
