package com.grabit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grabit.config.JwtProvider;
import com.grabit.exception.UserException;
import com.grabit.model.User;
import com.grabit.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
		
	}

	@Override
	public User findUserById(Long userld) throws UserException {
		
		Optional<User> user = userRepository.findById(userld);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User not found with ID: "+userld);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromToken(jwt);
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UserException("User not found with emai: "+email);
		}
		return user;
	}

}
