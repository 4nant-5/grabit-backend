package com.grabit.service;

import com.grabit.exception.UserException;
import com.grabit.model.User;

public interface UserService {

	public User findUserById(Long userld) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;

}
