package com.grabit.service;

import java.util.List;

import com.grabit.exception.OrderException;
import com.grabit.model.Address;
import com.grabit.model.Order;
import com.grabit.model.User;



public interface OrderService {
	
	
	public Order createOrder(User user, Address shippingAdress);

	public Order findOrderById(Long orderld) throws OrderException;

	public List<Order> usersOrderHistory(Long userld);

	public Order placedOrder(Long orderid) throws OrderException;

	public Order confirmedOrder(Long orderld) throws OrderException;

	public Order shippedOrder(Long orderld) throws OrderException;

	public Order deliveredOrder(Long orderld) throws OrderException;

	public Order cancledOrder(Long orderld) throws OrderException;
	
	public List<Order> getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;

}
