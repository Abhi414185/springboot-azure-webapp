package com.nagarro.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.entity.Tshirts;
import com.nagarro.services.ProcessRequest;

public class ProcessRequestImpl implements ProcessRequest {

	@Override
	public List<Tshirts> processReq(Tshirts customer, List<Tshirts> parser) {
		// TODO Auto-generated method stub
		List<Tshirts> list = parser.stream().filter(x-> (x.getColor().equalsIgnoreCase(customer.getColor()))
    			&& (x.getGender().equalsIgnoreCase(customer.getGender())) 
    			&& (x.getSize().equalsIgnoreCase(customer.getSize())&& x.getAvailability().equalsIgnoreCase("y")))
				.collect(Collectors.toList());
		return list;
	}

}
