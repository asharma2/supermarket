package com.ubs.supermarket.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.SpecialPrice;

public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private SpecialPriceService specialPriceService;

	@Override
	public double checkout(Collection<Item> items) {
		return items.stream().mapToDouble(i -> checkout(i)).sum();
	}

	protected double checkout(Item item) {
		SpecialPrice special = specialPriceService.get(item.getName());
		if (special != null) {
			double sum = (item.getQuantity() / special.getQuantity()) * special.getPrice();
			sum += (item.getQuantity() % special.getQuantity()) * item.getPrice();
			return sum;
		}
		return item.getPrice() * item.getQuantity();
	}

}
