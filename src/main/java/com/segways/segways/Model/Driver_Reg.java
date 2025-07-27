/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segways.segways.Model;

import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Lenovo
 */

@AllArgsConstructor

@Document(collection = "Driver")

public class Driver_Reg {

	private String name;
	private String city;
	private String dl;
	@Id
	@Indexed(unique = true)
	private String email;
	private String password;
	private String gender;
	private String phoneNum;
	private String role;

	public Driver_Reg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Driver_Reg(List<String> cities, String name, String city, String dl, String email, String password,
			String gender, String phoneNum, String role) {

		this.name = name;
		this.city = city;
		this.dl = dl;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.role = role;

	}

	@Override
	public String toString() {
		return "Driver_Reg [ name=" + name + ", city=" + city + ", dl=" + dl + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", phoneNum=" + phoneNum + ", role=" + role + "]";
	}

}
