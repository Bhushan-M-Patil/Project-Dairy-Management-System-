package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.*;
import com.app.entities.Order;
import com.app.repository.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired 
	private OrderRepository orderRepo;

	@Override
	public Order placeOrder(Order order) {

		return orderRepo.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
	}
	@Override
	public Order updateOrder(Order order) {
		if (!orderRepo.existsById(order.getId())) {
			throw new ResourceNotFoundException("Order not found with id ");
		}
		return orderRepo.save(order); // Save the updated order and return it
	}
	@Override
	public void deleteOrderById(Long id) {
		if (!orderRepo.existsById(id)) {
			throw new ResourceNotFoundException("Order not found with id " + id);
		}
		orderRepo.deleteById(id); 
	}
}
