package com.grabit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grabit.exception.ProductException;
import com.grabit.model.Rating;
import com.grabit.model.User;
import com.grabit.request.RatingRequest;

public interface RatingService {
	
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	public List<Rating> getProductsRating(Long productId);
	

}
