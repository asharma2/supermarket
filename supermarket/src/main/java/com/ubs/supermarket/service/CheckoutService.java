package com.ubs.supermarket.service;

import java.util.Collection;

import com.ubs.supermarket.model.Item;

public interface CheckoutService {

	double checkout(Collection<Item> items);
}
