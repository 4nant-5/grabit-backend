package com.grabit.service;

import com.grabit.exception.ProductException;
import com.grabit.model.Cart;
import com.grabit.model.User;
import com.grabit.request.AddItemRequest;

public interface CartService {
	
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
