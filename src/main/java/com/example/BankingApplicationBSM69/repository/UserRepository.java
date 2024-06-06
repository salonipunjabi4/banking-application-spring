package com.example.BankingApplicationBSM69.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.BankingApplicationBSM69.model.User;


//JPQL -- java persistance query language
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserId(int id);
	
	public User findByEmail(String email);
	
	public User findByName(String name);
	
	public User findByMobile(String mobile);
	
	public User findByAge(int age);
	
	public List<User> findByNationality(String nationality);

}
