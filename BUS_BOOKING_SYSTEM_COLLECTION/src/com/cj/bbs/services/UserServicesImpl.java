package com.cj.bbs.services;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cj.bbs.beans.Availability;
import com.cj.bbs.beans.Booking;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.beans.Ticket;
import com.cj.bbs.beans.User;
import com.cj.bbs.dao.DAOUser;
import com.cj.bbs.dao.UserDaoImpl;

public class UserServicesImpl implements UserServices {
	Pattern pat = null;
	Matcher mat = null;
	DAOUser db = new UserDaoImpl();

	@Override
	public Boolean createUser(User user) {
		return db.createUser(user);
	}

	@Override
	public Boolean loginUser(Integer user_id, String password) {
		return db.loginUser(user_id, password);
	}

	@Override
	public Boolean bookTicket(Ticket ticket) {
		return db.bookTicket(ticket);
	}

	@Override
	public Boolean updateUser(Integer userId, String password, String username, String email, Long contact) {
		return db.updateUser(userId, password, username, email, contact);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

	@Override
	public User searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean cancelTicket(Integer bookingId) {
		return db.cancelTicket(bookingId);
	}

	@Override
	public Booking getTicket(Integer bookingId) {
		return db.getTicket(bookingId);
	}

	@Override
	public Integer checkAvailability(int busId, java.util.Date availdate) {
		return db.checkAvailability(busId, availdate);
	}

	@Override
	public String checkemail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		} else {
			return null;
		}

	}

	@Override
	public Long checkContact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if (mat.matches()) {
			return Long.parseLong(contact);
		} else {
			return null;
		}

	}

	@Override
	public Integer idCheck(String userId) {

		pat = Pattern.compile("\\d+");
		mat = pat.matcher(userId);
		if (mat.matches()) {
			return Integer.parseInt(userId);
		}
		return null;
	}

	@Override
	public boolean nameCheck(String name) {

		pat = Pattern.compile("\\w+\\s\\w+");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		return db.deleteUser(userId);
	}

	@Override
	public User searchUser(String username) {
		return db.searchUser(username);
	}

	@Override
	public User searchUserEmail(String email) {
		return db.searchUserEmail(email);
	}

	@Override
	public User searchContact(Long contact) {
		return db.searchContact(contact);
	}

	@Override
	public List<Bus> searchAvailableBuses(String source, String destination, java.util.Date date) {
		return db.searchAvailableBuses(source, destination, date);
	}

	@Override
	public List<Bus> showBusesFromSource(String source) {
		return db.showBusesFromSource(source);
	}
	public List<Bus> showBusesByDestination(String destination) {
		return db.showBusesByDestination(destination);
	}

	@Override
	public List<String> showSources() {
		return db.showSources();
	}

	@Override
	public List<String> showDestination(String source) {
		return db.showDestination(source);
	}


	@Override
	public Availability searchAvailableBus(int busId) {
		return db.searchAvailableBus(busId);
	}



	@Override
	public List<String> date(String source, String destination) {
		return db.date(source, destination);
		
	}

	@Override
	public Booking getAllTicket() {
		return db.getAllTicket();
	}

	@Override
	public Bus searchBus(int busId) {
		return db.searchBus(busId);
	}

	@Override
	public Booking searchBookingId(int bookingId) {
		return db.searchBookingId(bookingId);
	}

	@Override
	public List<Integer> showBuses(String source, String destination, Date date) {
		return db.showBuses(source, destination, date);
	}

	@Override
	public String checkDate(String date) {
		pat = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		mat = pat.matcher(date);
		if (mat.matches()) {
			return date;
		}
		return null;

	}





}
