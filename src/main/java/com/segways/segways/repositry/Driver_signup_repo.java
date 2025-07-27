/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segways.segways.repositry;

import java.lang.String;
import com.segways.segways.Model.Driver_Reg;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Lenovo
 */
public interface Driver_signup_repo extends MongoRepository<Driver_Reg, String>
{
	 Driver_Reg findByEmail(String email);
}
