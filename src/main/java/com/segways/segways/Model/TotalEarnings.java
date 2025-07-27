/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segways.segways.Model;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Lenovo
 */

@Document(collection = "Earnings")
public class TotalEarnings {
    public TotalEarnings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalEarnings(double total) {
		super();
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private double total;  
    

    
    
}
