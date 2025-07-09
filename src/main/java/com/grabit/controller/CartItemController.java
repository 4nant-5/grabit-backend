package com.grabit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


import com.grabit.exception.CartItemException;
import com.grabit.exception.UserException;
import com.grabit.model.CartItem;
import com.grabit.model.User;
import com.grabit.response.ApiResponse;
import com.grabit.service.CartItemService;
import com.grabit.service.UserService;

@RestController
@RequestMapping("api/cart_items/")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping("/{cartItemId}")
	@Operation(description= "Remove item from cart")
	@io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Delete item")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
			@RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		 User user = userService.findUserProfileByJwt(jwt);
		 cartItemService.removeCartItem(user.getId(), cartItemId);
		 
		 ApiResponse res = new ApiResponse();
		 res.setMessage("Item deleted from cart");
		 res.setStatus(true);
		 return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	@PutMapping("/{cartItemId}")
	@Operation(description = "Update item to card")
	public ResponseEntity<CartItem> updateCartItem(
			@RequestBody CartItem cartItem,
			@PathVariable Long cartItemId,
			@RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		User user = userService.findUserProfileByJwt(jwt);
		
		CartItem updaCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
		
		
		return new ResponseEntity<>(updaCartItem, HttpStatus.OK);
	}
	

}
