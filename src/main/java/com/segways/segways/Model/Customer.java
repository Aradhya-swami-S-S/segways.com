/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segways.segways.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "Customer_signup")
public class Customer {  
  
	
	private String name;
    private String phonenumber;
    private String password ; 
    @Id 
    @Indexed(unique = true)
    private String email;
    private String gender; 
    private String role;

    
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
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}

		public Customer(List<String> cities, String name, String phonenumber, String password, String email,
				String gender, String role) {

			this.name = name;
			this.phonenumber = phonenumber;
			this.password = password;
			this.email = email;
			this.gender = gender;
			this.role = role;
			
		}

		@Override
		public String toString() {
			return "Customer [ name=" + name + ", phonenumber=" + phonenumber + ", password="
					+ password + ", email=" + email + ", gender=" + gender + ", role=" + role 
					+ "]";
		}   
	
   

   
    
}
