package com.nagarro.servicesimpl;

import java.util.List;

import com.nagarro.entity.Tshirts;
import com.nagarro.services.Display;

public class DisplayImpl implements Display {

	
	public void show(List<Tshirts> ob) {
		// TODO Auto-generated method stub
		for(Tshirts t: ob) {
			System.out.println(t);
		}
	}

	

}