package com.example.training.enity;

import lombok.Data;

@Data
public class Address {

	private String mail;
	private String password;
	private String address;
	private String homeAddress;
	private String lastName;
	private String firstName;
	private String gender = "male";
	private String phone;
}
