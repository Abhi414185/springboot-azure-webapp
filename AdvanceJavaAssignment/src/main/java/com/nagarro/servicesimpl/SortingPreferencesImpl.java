package com.nagarro.servicesimpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.entity.Tshirts;
import com.nagarro.services.SortingPreference;

public class SortingPreferencesImpl implements SortingPreference {

	@Override
	public List<Tshirts> preferenceOutput(Tshirts user, List<Tshirts> collect) {
		// TODO Auto-generated method stub
		
		if(user.getOutputPreference()==1) {
    		collect = collect.stream().sorted(new Comparator<Tshirts>() {

				@Override
				public int compare(Tshirts o1, Tshirts o2) {
					if(Double.parseDouble(o1.getPrice())> Double.parseDouble(o2.getPrice()))
						return 1;
					else return -1;
					
				}
    			
			}).collect(Collectors.toList());
    	}
    	else if(user.getOutputPreference()==2) {
    		collect = collect.stream().sorted(new Comparator<Tshirts>() {

				@Override
				public int compare(Tshirts o1, Tshirts o2) {
					if(Double.parseDouble(o1.getRating())< Double.parseDouble(o2.getRating()))
						return 1;
					else return -1;
					
				}
    			
			}).collect(Collectors.toList());
    	}
    	else if(user.getOutputPreference()==3) {
    		collect = collect.stream().sorted(new Comparator<Tshirts>() {

				@Override
				public int compare(Tshirts o1, Tshirts o2) {
					if(Double.parseDouble(o1.getPrice())> Double.parseDouble(o2.getPrice()))
						return 1;
					else return -1;
					
				}
    			
			}).collect(Collectors.toList());
    		collect = collect.stream().sorted(new Comparator<Tshirts>() {

    			@Override
				public int compare(Tshirts o1, Tshirts o2) {
					if(Double.parseDouble(o1.getRating()) < Double.parseDouble(o2.getRating()))
						return 1;
					else return -1;
					
				}
    			
			}).collect(Collectors.toList());
    		
    	}
    	else {
    		collect.forEach(System.out::println);
    	}
		
		return collect;

	}

}