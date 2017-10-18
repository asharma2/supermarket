package com.ubs.supermarket.service;

import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.SpecialPrice;

public interface SpecialPriceService extends ICacheService<String, SpecialPrice> {

	boolean isSpecialPrice(Item item);

}
