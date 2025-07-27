/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segways.segways.repositry;

import com.segways.segways.Model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Lenovo
 */
public interface Customer_signup_repo  extends MongoRepository<Customer, String>{
      Customer findByEmail(String email);
}
