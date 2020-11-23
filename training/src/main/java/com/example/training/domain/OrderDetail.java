package com.example.training.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDetail {
	private int id;
	private String lastName;
	private String firstName;
	private String address1;
	private String address2;
	private String phone;
	private String email;
	private Date dateNow = new Date();

	public String getDateNow() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
		return dateFormat.format(this.dateNow);
	}

	public String getFullName() {
		return this.lastName + this.firstName;
	}

	public String getFullAddress() {
		return this.address1 + this.address2;
	}
}
