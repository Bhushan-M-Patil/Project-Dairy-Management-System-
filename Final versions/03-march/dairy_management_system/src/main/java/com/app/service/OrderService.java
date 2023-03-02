package com.app.service;

import com.app.entities.Order;

public interface OrderService {
	Order placeOrder(Order order);
	Order getOrderById(Long id);
	void deleteOrderById(Long id);
	Order updateOrder(Order order);
}
