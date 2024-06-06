package com.example.BankingApplicationBSM69.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplicationBSM69.ExceptionHandler.UserNotFoundException;
import com.example.BankingApplicationBSM69.dto.UserRequest;
import com.example.BankingApplicationBSM69.model.User;
import com.example.BankingApplicationBSM69.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(UserRequest userRequest) {

		User user = User.build(0, 
				userRequest.getName(), 
				userRequest.getEmail(), 
				userRequest.getMobile(), 
				userRequest.getGender(),
				userRequest.getAge(), 
				userRequest.getNationality());
		return repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByUserId(id);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with id: " + id);
		}
		
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByEmail(email);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with email: " + email);
		}
		
	}

	@Override
	public User getUserByName(String name) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByName(name);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with name: " + name);
		}
	}

	@Override
	public User getUserByMobile(String mobile) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByMobile(mobile);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with mobile: " + mobile);
		}
	}

	@Override
	public User getUserByAge(int age) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByAge(age);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with age: " + age);
		}
	}

	@Override
	public List<User> getUserByNationality(String nationality) throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> users = repository.findByNationality(nationality);
		if(users.isEmpty()) {
			throw new UserNotFoundException("user not found with nationality: " + nationality);
		}else {
			return users;
		}
	}



}
