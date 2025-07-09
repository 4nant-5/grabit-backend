package com.grabit.service;

import com.grabit.exception.CartItemException;
import com.grabit.exception.UserException;
import com.grabit.model.Cart;
import com.grabit.model.CartItem;
import com.grabit.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem  cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
