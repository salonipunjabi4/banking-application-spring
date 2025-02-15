package com.example.BankingApplicationBSM69.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "USERS_TBL")
@Data
@AllArgsConstructor(staticName = "build") //builder design pattern
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
	

}
