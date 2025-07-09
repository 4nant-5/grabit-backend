package com.grabit.service;

import java.util.List;

import com.grabit.exception.ProductException;
import com.grabit.model.Review;
import com.grabit.model.User;
import com.grabit.request.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req, User user) throws ProductException;
	public List<Review> getAllReview(Long productId);

}
