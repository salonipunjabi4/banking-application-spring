package com.example.BankingApplicationBSM69.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingApplicationBSM69.ExceptionHandler.UserNotFoundException;
import com.example.BankingApplicationBSM69.dto.UserRequest;
import com.example.BankingApplicationBSM69.model.User;
import com.example.BankingApplicationBSM69.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUser(id));
	}
	

	@GetMapping("/getUserByEmail")
	public ResponseEntity<User> getUserByEmail(@RequestBody UserRequest userRequest) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUserByEmail(userRequest.getEmail()));
	}
	
	@GetMapping("/getUserByName")
	public ResponseEntity<User> getUserByName(@RequestBody UserRequest userRequest) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUserByName(userRequest.getName()));
	}
	
	@GetMapping("/getUserByMobile")
	public ResponseEntity<User> getUserByMobile(@RequestBody UserRequest userRequest) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUserByMobile(userRequest.getMobile()));
	}
	
	@GetMapping("/getUserByAge/{age}")
	public ResponseEntity<User> getUserByAge(@PathVariable int age) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUserByAge(age));
	}
	
	@GetMapping("/getUserByNationality")
	public ResponseEntity<List<User>> getUserByNationality(@RequestBody UserRequest userRequest) throws UserNotFoundException{
		return ResponseEntity.ok(service.getUserByNationality(userRequest.getNationality()));
	}
	

}
