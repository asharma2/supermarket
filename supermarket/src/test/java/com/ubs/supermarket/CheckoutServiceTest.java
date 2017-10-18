package com.ubs.supermarket;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ubs.supermarket.config.ItemConfiguration;
import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.SpecialPrice;
import com.ubs.supermarket.service.CheckoutService;
import com.ubs.supermarket.service.SpecialPriceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ItemConfiguration.class })
public class CheckoutServiceTest {

	@Autowired
	private SpecialPriceService specialPriceService;

	@Autowired
	private CheckoutService checkoutService;

	@Test
	public void lifecycle() throws Exception {
		assertNotNull(specialPriceService);
		assertNotNull(checkoutService);
	}

	@Test
	public void itemWithNoSpecialPrice() throws Exception {
		Item a = new Item("A", 40.0, 5);
		Item b = new Item("B", 10.0, 5);
		Item c = new Item("C", 30.0, 5);
		Item d = new Item("D", 25.0, 10);
		double sum = checkoutService.checkout(Arrays.asList(a, b, c, d));
		assertEquals(650, sum, 0);
	}

	@Test
	public void itemWithSpecialPrice() throws Exception {
		Item a = new Item("A", 40.0, 5);
		specialPriceService.put(a.getName(), new SpecialPrice(3, 70)); //150
		Item b = new Item("B", 10.0, 5);
		specialPriceService.put(b.getName(), new SpecialPrice(2, 15)); // 40
		Item c = new Item("C", 30.0, 5); // 150
		Item d = new Item("D", 25.0, 10); // 250
		double sum = checkoutService.checkout(Arrays.asList(a, b, c, d));
		assertEquals(590, sum, 0);
	}
}
