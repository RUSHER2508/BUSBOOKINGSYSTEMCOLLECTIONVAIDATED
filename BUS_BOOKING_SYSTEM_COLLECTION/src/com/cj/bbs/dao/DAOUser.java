package com.cj.bbs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cj.bbs.beans.Availability;
import com.cj.bbs.beans.Booking;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.beans.Ticket;
import com.cj.bbs.beans.User;

public interface DAOUser {

	// user manipulation
	public Boolean createUser(User user); // For create user operation

	// For update user operation
	public Boolean updateUser(int user_id, String password, String username, String email, long contact);

	public Boolean deleteUser(int user_id); // For delete operation of user

	public Boolean loginUser(Integer user_id, String password); // For login of user

	public User searchUser(int user_id); // For searching of user using user id
	
	public User searchUser(String username); //For searching user by username
	
	public User searchUserEmail(String email); //For searching user by email
	
	public User searchContact(Long contact);
	

	// ticket booking
	public Boolean bookTicket(Ticket ticket); // For booking tickets

	public Boolean cancelTicket(int booking_id); // For cancelling ticket

	public Booking getTicket(int booking_id); // For getting ticket
	
	public Booking getAllTicket();

	// For checking availability from bus id and date
	public Integer checkAvailability(int bus_id, Date availdate);
	
	//For searching bus by source destination and dates
	public List<Bus> searchAvailableBuses(String source,String destination,Date date);
	
	public List<Bus> showBusesFromSource(String source);

	public List<Bus> showBusesByDestination(String destination);
	
	public List<String> showSources();
	
	public List<String> showDestination(String source);
	
	
	public Availability searchAvailableBus(int busId);

	
	public List<String> date(String source,String destination);
	
	public Bus searchBus(int busId);
	
	public Booking searchBookingId(int bookingId);

	public List<Integer> showBuses(String source, String destination, java.sql.Date date);
}

