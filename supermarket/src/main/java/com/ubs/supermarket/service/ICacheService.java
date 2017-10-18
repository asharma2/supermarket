package com.ubs.supermarket.service;

public interface ICacheService<K, V> {

	V get(K key);

	V put(K key, V value);
}
