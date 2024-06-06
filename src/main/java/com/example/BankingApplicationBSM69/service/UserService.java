package com.example.BankingApplicationBSM69.service;

import java.util.List;

import com.example.BankingApplicationBSM69.ExceptionHandler.UserNotFoundException;
import com.example.BankingApplicationBSM69.dto.UserRequest;
import com.example.BankingApplicationBSM69.model.User;

public interface UserService {
	
	public User saveUser(UserRequest userRequest);
	
	public List<User> getAllUsers();
	
	public User getUser(int id) throws UserNotFoundException;
	
	public User getUserByEmail(String email) throws UserNotFoundException;
	
	public User getUserByName(String name) throws UserNotFoundException;
	
	public User getUserByMobile(String mobile) throws UserNotFoundException;
	
	public User getUserByAge(int age) throws UserNotFoundException;

	public List<User> getUserByNationality(String nationality) throws UserNotFoundException;
	
	//public User getAllUsersByNationality(String nationality) throws UserNotFoundException;
	
	

}
