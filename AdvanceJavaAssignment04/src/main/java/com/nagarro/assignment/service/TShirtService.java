package com.nagarro.assignment.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.dao.TShirtDao;
import com.nagarro.assignment.entity.TShirt;
import com.nagarro.assignment.util.DataLoader;

@Service
public class TShirtService {

	@Autowired
	private TShirtDao tShirtDao;

	public List<TShirt> loadAll() {
		List<TShirt> shirts = this.tShirtDao.getAllShirts();
		System.out.println(shirts);
		if (shirts.isEmpty()) {
			shirts = new DataLoader().loader();
			tShirtDao.loadItemsIntoDB(shirts);
		}
		shirts = this.tShirtDao.getAllShirts();
		return shirts;
	}

	public List<TShirt> searchByCriteria(TShirt shirt) {
		List<TShirt> shirts = this.tShirtDao.getAllShirts();
		List<TShirt> filterShirts = new ArrayList<TShirt>();
		for (TShirt s : shirts) {
			if (s.getColor().equalsIgnoreCase(shirt.getColor()) && s.getGender().equalsIgnoreCase(shirt.getGender())
					&& s.getSize().equalsIgnoreCase(shirt.getSize()) && s.getAvailability().equalsIgnoreCase("Y")) {
				filterShirts.add(s);
			}
		}
		filterShirts = preference(shirt, filterShirts);
		return filterShirts;
	}

	public List<TShirt> preference(TShirt customer, List<TShirt> collect) {
		// TODO Auto-generated method stub

		if (customer.getOutputPreference() == 1) {
			collect = collect.stream().sorted(new Comparator<TShirt>() {

				@Override
				public int compare(TShirt o1, TShirt o2) {
					if (Double.parseDouble(o1.getPrice()) > Double.parseDouble(o2.getPrice()))
						return 1;
					else
						return -1;

				}

			}).collect(Collectors.toList());
		} else if (customer.getOutputPreference() == 2) {
			collect = collect.stream().sorted(new Comparator<TShirt>() {

				@Override
				public int compare(TShirt o1, TShirt o2) {
					if (Double.parseDouble(o1.getRating()) < Double.parseDouble(o2.getRating()))
						return 1;
					else
						return -1;

				}

			}).collect(Collectors.toList());
		} else if (customer.getOutputPreference() == 3) {
			collect = collect.stream().sorted(new Comparator<TShirt>() {

				@Override
				public int compare(TShirt o1, TShirt o2) {
					if (Double.parseDouble(o1.getPrice()) > Double.parseDouble(o2.getPrice()))
						return 1;
					else
						return -1;

				}

			}).collect(Collectors.toList());
			collect = collect.stream().sorted(new Comparator<TShirt>() {

				@Override
				public int compare(TShirt o1, TShirt o2) {
					if (Double.parseDouble(o1.getRating()) < Double.parseDouble(o2.getRating()))
						return 1;
					else
						return -1;

				}

			}).collect(Collectors.toList());

		} else {
			collect.forEach(System.out::println);
		}

		return collect;

	}
}
