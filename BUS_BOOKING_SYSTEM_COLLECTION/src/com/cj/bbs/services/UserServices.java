package com.cj.bbs.services;

import java.util.Date;
import java.util.List;

import com.cj.bbs.beans.Availability;
import com.cj.bbs.beans.Booking;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.beans.Ticket;
import com.cj.bbs.beans.User;

public interface UserServices {
	public Boolean createUser(User user);

	public Boolean updateUser(Integer userId, String password, String username, String email, Long contact);

	public Boolean deleteUser(Integer userId);

	public Boolean loginUser(Integer userId, String password);

	public User searchUser(Integer userId);
	
	public User searchUser(String username);

	public User searchUserEmail(String email);

	public User searchContact(Long contact);

	public List<Bus> searchAvailableBuses(String source,String destination,Date date);


	public List<Bus> showBusesFromSource(String source);

	public List<Bus> showBusesByDestination(String destination);
	
	public List<String> showSources();
	
	public List<String> showDestination(String source);
	

	public Availability searchAvailableBus(int busId);
	
	public List<String> date(String source,String destination);
	
	public Booking getAllTicket();

	public Bus searchBus(int busId);
	
	public Booking searchBookingId(int bookingId);


	
	// ticket booking
	public Boolean bookTicket(Ticket ticket);

	public Boolean cancelTicket(Integer bookingId);

	public Booking getTicket(Integer bookingId);

	public Integer checkAvailability(int busId, Date availdate);

	Boolean deleteUser(Integer userId, String password);

	boolean nameCheck(String name);

	Integer idCheck(String userId);

	String checkemail(String email);

	Long checkContact(String contact);
	
	String checkDate(String date);


	List<Integer> showBuses(String source, String destination, java.sql.Date date);

}
