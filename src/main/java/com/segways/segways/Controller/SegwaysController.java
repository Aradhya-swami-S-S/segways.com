/*
 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segways.segways.Controller;

import com.segways.segways.Model.Contact;

import com.segways.segways.Model.Customer;
import com.segways.segways.Model.Driver_Reg;
import com.segways.segways.Model.Ride;
import com.segways.segways.repositry.Contact_repo;
import com.segways.segways.repositry.Customer_signup_repo;
import com.segways.segways.repositry.Driver_signup_repo;
import com.segways.segways.repositry.RideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Controller
public class SegwaysController {

	@Autowired
	private Customer_signup_repo customer_repo;

	@Autowired
	private Driver_signup_repo driver_repo;

	@Autowired
	private Contact_repo contact_repo;
	@Autowired
	private RideRepository ride_repo;

	@RequestMapping(value = "/registerdriver", method = RequestMethod.POST)
	public String driverLogin(@ModelAttribute("driver") Driver_Reg driver, Model model) {

		driver.setRole("ROLE_DRIVER");

		System.out.println("driver" + driver);
		this.driver_repo.save(driver);
		model.addAttribute("driver", new Driver_Reg());
		return "driverlogin";

	}

	@RequestMapping(value = "/logindriver", method = RequestMethod.POST)
	public String loginDriver(String email, String password, Model model) {
		Driver_Reg user = driver_repo.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			model.addAttribute("user", user);
			return "captainprofile";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "driverlogin";
		}

	}

	@RequestMapping("/captain1profile")
	public String captainProfile(Model model) {
		String email = "ameer@gmail.com";
		Driver_Reg user = driver_repo.findByEmail(email);
		model.addAttribute("user", user);
		return "captainprofile";
	}

	@RequestMapping("/captainprofile")
	public String defaultCaptainProfile(Model model, @ModelAttribute("user") Driver_Reg user) {

		model.addAttribute("user", user);
		return "captainprofile";
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("user") Driver_Reg user, Model model) {
		Driver_Reg updatedUser = driver_repo.save(user);
		model.addAttribute("user", updatedUser);
		return "captainprofile";
	}

	@RequestMapping("/captain-home")
	public String captainHome() {
		return "captain-home";
	}

	@RequestMapping("/captainorders")
	public String captainOrder(Model model) {
		String status = "Completed";
		List<Ride> completed_rides = this.ride_repo.findByStatus(status);
		model.addAttribute("completedrides", completed_rides);
		String status_of_cancel = "cancelled";
		List<Ride> canceled_rides = this.ride_repo.findByStatus(status_of_cancel);
		model.addAttribute("cancelledrides", canceled_rides);
		String status_of_booked = "Booked";
		List<Ride> bookedrides = this.ride_repo.findByStatus(status_of_booked);
		model.addAttribute("bookedrides", bookedrides);
		return "captainorders";
	}

	@RequestMapping(value = "/cancelridecaptain", method = RequestMethod.POST)
	public String cancelOrdercaptain(@RequestParam("id") String id, Model model) {

		Ride rideCancel = ride_repo.findById(id).orElse(null);
		if (rideCancel != null) {
			rideCancel.setStatus("cancelled");
			ride_repo.save(rideCancel);
		}
		model.addAttribute("ride", rideCancel);
		String status = "Completed";
		List<Ride> completed_rides = this.ride_repo.findByStatus(status);
		model.addAttribute("completedrides", completed_rides);
		String status_of_cancel = "cancelled";
		List<Ride> canceled_rides = this.ride_repo.findByStatus(status_of_cancel);
		model.addAttribute("cancelledrides", canceled_rides);
		String status_of_booked = "Booked";
		List<Ride> bookedrides = this.ride_repo.findByStatus(status_of_booked);
		model.addAttribute("bookedrides", bookedrides);

		return "captainorders";
	}

	@RequestMapping(value = "/completeridecaptain", method = RequestMethod.POST)
	public String CompleteOrdercaptain(@RequestParam("id") String id, Model model) {

		Ride ride = ride_repo.findById(id).orElse(null);
		if (ride != null) {
			ride.setStatus("completed");
			ride_repo.save(ride);
		}
		model.addAttribute("ride", ride);
		String status = "Completed";
		List<Ride> completed_rides = this.ride_repo.findByStatus(status);
		model.addAttribute("completedrides", completed_rides);
		String status_of_cancel = "cancelled";
		List<Ride> canceled_rides = this.ride_repo.findByStatus(status_of_cancel);
		model.addAttribute("cancelledrides", canceled_rides);
		String status_of_booked = "Booked";
		List<Ride> bookedrides = this.ride_repo.findByStatus(status_of_booked);
		model.addAttribute("bookedrides", bookedrides);
		return "captainorders";
	}

	@RequestMapping("/captainearnings")
	public String captainEarning() {
		return "captainearnings";
	}

	@RequestMapping("/captainnotification")
	public String captainNotification() {
		return "captainnotification";
	}

	@RequestMapping("/captainsupport")
	public String captainSupport() {
		return "captainsupport";
	}

	@RequestMapping("/captainsetting")
	public String captainSetting() {
		return "captainsetting";
	}

	// customer signup and login

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String customerLogin(@ModelAttribute("customer") Customer customer, Model model) {
		customer.setRole("Role_CUSTOMER");

		System.out.println("customer" + customer);
		this.customer_repo.save(customer);
		model.addAttribute("customer", new Customer());
		return "customerlogin";
	}

	@RequestMapping(value = "/logincustomer", method = RequestMethod.POST)
	public String loginCustomer(String email, String password, Model model) {
		Customer user = customer_repo.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			model.addAttribute("user", user);
			return "customer-profile";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "customerlogin";
		}
	}

	@RequestMapping("/customer1-profile")
	public String customerProfile(Model model) {
		String email = "ameer@gmail.com";
		Customer user = customer_repo.findByEmail(email);
		model.addAttribute("user", user);
		return "customer-profile";
	}

	@RequestMapping("/customer-profile")
	public String defaultCustomerProfile(Model model, @ModelAttribute("user") Customer user) {

		model.addAttribute("user", user);
		return "customer-profile";
	}

	@RequestMapping(value = "/updatecustomerprofile", method = RequestMethod.POST)
	public String updateCustomerProfile(@ModelAttribute("user") Customer user, Model model) {
		Customer updatedUser = customer_repo.save(user);
		model.addAttribute("user", updatedUser);
		return "customer-profile";
	}

	@RequestMapping(value = "/bookingride", method = RequestMethod.POST)
	public String bookRide(@ModelAttribute("ride") Ride ride, Model model) {
		double price = (ride.getDistance() * 8);
		ride.setPrice(price);
		ride.setStatus("Booked");
		Ride rideofCustomer = this.ride_repo.save(ride);
		model.addAttribute("ride", rideofCustomer);
		return "orderstatusforcustomer";
	}

	@RequestMapping("/orderstatusforcustomer")
	public String orderStatus(Model model, @ModelAttribute("ride") Ride ride) {
		model.addAttribute("ride", ride);
		return "orderstatusforcustomer";
	}

	@RequestMapping(value = "/cancelride", method = RequestMethod.POST)
	public String cancelOrder(@RequestParam("id") String id, Model model) {

		Ride rideCancel = ride_repo.findById(id).orElse(null);
		if (rideCancel != null) {
			rideCancel.setStatus("cancelled");
			ride_repo.save(rideCancel);
		}
		model.addAttribute("ride", rideCancel);

		return "orderstatusforcustomer";
	}

	@RequestMapping(value = "/completeride", method = RequestMethod.POST)
	public String CompleteOrder(@RequestParam("id") String id, Model model) {

		Ride ride = ride_repo.findById(id).orElse(null);
		if (ride != null) {
			ride.setStatus("completed");
			ride_repo.save(ride);
		}
		model.addAttribute("ride", ride);
		return "orderstatusforcustomer";
	}

	// simple mapping
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	@RequestMapping(value = "/messagesuccess", method = RequestMethod.POST)
	public String message(@ModelAttribute("contact") Contact contact, Model model) {
		this.contact_repo.save(contact);
		model.addAttribute("contact", new Contact());
		return "messagesuccess";
	}

	@RequestMapping("/customerlogin")
	public String customerLogin1() {
		return "customerlogin";
	}

	@RequestMapping("/driverlogin")
	public String driverLogin() {
		return "driverlogin";
	}

	@RequestMapping("/driversingup")
	public String driverSingup(Model model) {
		model.addAttribute("driver", new Driver_Reg());
		return "driversingup";
	}

	@RequestMapping("/customersignup")
	public String customerSignup(Model model) {
		model.addAttribute("customer", new Customer());
		return "customersignup";
	}

	@RequestMapping("/customer-home")
	public String customerHome(Model model) {
		model.addAttribute("ride", new Ride());
		return "customer-home";
	}

	@RequestMapping("/my-rides")
	public String myRides(Model model) {
		List<Ride> rides = ride_repo.findAll();
		model.addAttribute("rides", rides);
		return "my-rides";
	}

	@RequestMapping("/customer-notification")
	public String customerNotification() {
		return "customer-notification";
	}

	@RequestMapping("/customer-payments")
	public String customerPayments() {
		return "customer-payments";
	}

	@RequestMapping("/customer-setting")
	public String customerSetting() {
		return "customer-setting";
	}

	@RequestMapping("/customer-support")
	public String customerSupport() {
		return "customer-support";
	}
}
