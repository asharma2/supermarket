package com.ubs.supermarket.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.SpecialPrice;

public class SpecialPriceServiceImpl implements SpecialPriceService {

	private ConcurrentMap<String, SpecialPrice> specialPrices = new ConcurrentHashMap<>();

	@Override
	public SpecialPrice get(String key) {
		return specialPrices.get(key);
	}

	@Override
	public SpecialPrice put(String key, SpecialPrice specialPrice) {
		return specialPrices.put(key, specialPrice);
	}

	@Override
	public boolean isSpecialPrice(Item item) {
		return specialPrices.containsKey(item.getName());
	}

}
