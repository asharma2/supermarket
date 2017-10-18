package com.ubs.supermarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ubs.supermarket.service.CheckoutService;
import com.ubs.supermarket.service.CheckoutServiceImpl;
import com.ubs.supermarket.service.SpecialPriceService;
import com.ubs.supermarket.service.SpecialPriceServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.ubs.supermarket.service")
public class ItemConfiguration {

	@Bean
	public SpecialPriceService specialPriceService() {
		return new SpecialPriceServiceImpl();
	}

	@Bean
	public CheckoutService checkoutService() {
		return new CheckoutServiceImpl();
	}
}
