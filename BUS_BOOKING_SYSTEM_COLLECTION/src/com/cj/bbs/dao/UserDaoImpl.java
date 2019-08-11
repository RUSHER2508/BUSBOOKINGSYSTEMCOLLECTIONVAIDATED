package com.cj.bbs.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.cj.bbs.beans.Availability;
import com.cj.bbs.beans.Booking;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.beans.Ticket;
import com.cj.bbs.beans.User;
import com.cj.bbs.exception.TicketBookingException;
import com.cj.bbs.repository.Repository;

public class UserDaoImpl implements DAOUser {
	Repository repository = new Repository();
	HashMap<Integer, User> userMapDb = Repository.user;
	HashMap<Integer, Availability> availableMapDb = Repository.avail;
	HashMap<Integer, Booking> bookingMapDb = Repository.book;
	HashMap<Integer, Ticket> ticketMapDb = Repository.ticket;
	HashMap<Integer, Bus> busMapDb = Repository.bus;

	Scanner sc = new Scanner(System.in);

	User user = new User();
	Bus bus = new Bus();
	Booking book = new Booking();

	@Override
	public Boolean createUser(User user) {

		userMapDb.put(user.getUserId(), user);
		if (user != null) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean updateUser(int userId, String password, String username, String email, long contact) {

		User user = searchUser(userId);
		if (user != null) {

			user.setUserId(userId);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setContact(contact);
			return true;

		}

		return false;
	}

	@Override
	public Boolean deleteUser(int userId) {
		User user = searchUser(userId);
		if (user != null) {
			userMapDb.remove(userId);
			return true;
		}

		return false;
	}

	@Override
	public Boolean loginUser(Integer userId, String password) {

		User user = searchUser(userId);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public User searchUser(int userId) {

		User user = null;
		Iterator it = userMapDb.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().equals(userId)) {
				return (User) pair.getValue();
			}

		}
		return user;
	}

	@Override
	public Boolean bookTicket(Ticket ticket) {

		String source = ticket.getSource();
		String destination = ticket.getDestination();
		Integer busId = ticket.getBusId();
		String date1 = ticket.getAvailDate();
		java.util.Date date2;
		Random randomNumGenerator = new Random();
		Integer bookingId = randomNumGenerator.nextInt(100);
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date date = new Date(date2.getTime());

			Bus bus = busMapDb.get(busId);
			System.out.println(bus);
			Booking booking = new Booking();

			
			
			
			Integer available = checkAvailability(busId , date);
			if(available >= ticket.getNumofSeats())
			{
				available = available-ticket.getNumofSeats();
				Availability available1=availableMapDb.get(bus.getBusId());
				available1.setAvailSeats(available);
				System.out.println("Available Seats : "+available);
				booking.setBusId(ticket.getBusId());
				booking.setDate(ticket.getAvailDate());
				booking.setSource(ticket.getSource());
				booking.setDestination(ticket.getDestination());
				booking.setNumOfSeats(ticket.getNumofSeats());
				booking.setBookingId(bookingId);
				booking.setUserId(user.getUserId());
				booking.setJourneyDate(booking.getJourneyDate());
				bookingMapDb.put(booking.getBookingId(), booking);
				booking.setUserId(ticket.getUserId());
				booking.setJourneyDate(ticket.getAvailDate());
				booking.setPrice(bus.getPrice()*ticket.getNumofSeats());

				System.out.println(bookingMapDb.get(booking.getBookingId()));
				return true;
			}
			else
			{
				throw new TicketBookingException("Tickets Not Found");
			}
		}
	
		 catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean cancelTicket(int bookingId) {

		Booking booking = getTicket(bookingId);
		booking = bookingMapDb.remove(booking.getBookingId());
		if (bookingMapDb != null) {
			Availability available = availableMapDb.get(booking.getBusId());
			available.setAvailSeats(available.getAvailSeats() - booking.getNumOfSeats());
			return true;

		}

		return null;
	}

	@Override
	public Booking getTicket(int bookingId) {
		Iterator it = bookingMapDb.entrySet().iterator();
		Booking booking = new Booking();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().equals(bookingId)) {
				return (Booking) pair.getValue();
			}
		}
		return null;
	}

	@Override
	public Integer checkAvailability(int busId, java.util.Date availdate) {

		Availability avail = availableMapDb.get(busId);
		Booking book = new Booking();
		if(availdate.toString().equals(avail.getAvailDate())) {

			return avail.getAvailSeats();
		}
		return null;

	}

	@Override
	public User searchUser(String username) {
		User user = null;
		for (Map.Entry pair : userMapDb.entrySet()) {

			user = (User) pair.getValue();
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}

		}

		return null;
	}

	@Override
	public User searchUserEmail(String email) {

		User user = null;
		for (Map.Entry pair : userMapDb.entrySet()) {

			user = (User) pair.getValue();
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}

		}

		return null;
	}

	@Override
	public User searchContact(Long contact) {

		User user = null;
		for (Map.Entry pair : userMapDb.entrySet()) {
			user = (User) pair.getValue();
			if (user.getContact() == contact) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<Bus> searchAvailableBuses(String source, String destination, java.util.Date date) {

		List<Bus> buses = new ArrayList<Bus>();
		Availability available= new Availability();
		int count = 0;
		for (Map.Entry pair : busMapDb.entrySet()) {
			Bus bus = (Bus) pair.getValue();
			if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {
				 available = availableMapDb.get(bus.getBusId());
				if (date.toString().equals(available.getJourneyDate())) {

					buses.add(count,bus);	
					count++;
				}

					}

			}
		return buses;
		
	}

	@Override
	public List<Bus> showBusesFromSource(String source) {

		
		List<Bus> buses = new ArrayList<>();
		Bus bus = new Bus();
		for(Map.Entry pair : busMapDb.entrySet()) {
			bus = (Bus) pair.getValue();
			if(bus.getSource().equalsIgnoreCase(source)) {
				buses.add(bus);
			}
		}
		return buses;
	}

	@Override
	public List<Bus> showBusesByDestination(String destination) {
		List<Bus> buses = new ArrayList<>();
		Bus bus = new Bus();
		for(Map.Entry pair : busMapDb.entrySet()) {
			bus = (Bus) pair.getValue();
			if(bus.getDestination().equalsIgnoreCase(destination)) {
				buses.add(bus);
			}
		}
		return buses;
}

	@Override
	public List<String> showSources() {
		
		List<String> buses = new ArrayList<>();
		Bus bus = new Bus();
		for(Map.Entry pair:busMapDb.entrySet()) {
			bus = (Bus) pair.getValue();
			buses.add(bus.getSource());
			}
		return buses;
		
	}

	@Override
	public List<String> showDestination(String source) {
		
		List<String> buses = new ArrayList<>();
		Bus bus = new Bus();
		for(Map.Entry pair:busMapDb.entrySet())
		{
			bus = (Bus) pair.getValue();
			if(bus.getSource().equalsIgnoreCase(source)) {
				buses.add(bus.getDestination());
			}
		}
		return buses;
	}

	@Override
	public List<Integer> showBuses(String source,String destination,Date date) {
		
		List<Integer> buses = new ArrayList<Integer>();
		Availability available= new Availability();
		int count = 0;
		for (Map.Entry pair : busMapDb.entrySet()) {
			Bus bus = (Bus) pair.getValue();
			if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {
				 available = availableMapDb.get(bus.getBusId());
					if (date.toString().equals(available.getJourneyDate())) {
					buses.add(bus.getBusId());	
					count++;
					}
					}
	}
		return buses;
		}
	

	@Override
	public Availability searchAvailableBus(int busId) {
		Availability available = new Availability();
		if(availableMapDb.containsKey(busId)) {
			return availableMapDb.get(busId);
		}
		else {
			return null;
		}
	}

	@Override
	public List<String> date(String source, String destination) {

		
		ArrayList<String> buses = new ArrayList<String>();
		Availability available= new Availability();
		int count = 0;
		for (Map.Entry pair : busMapDb.entrySet()) {
			Bus bus = (Bus) pair.getValue();
			if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {
				 available = availableMapDb.get(bus.getBusId());
					 
						buses.add(available.getAvailDate());	
						count++;

				 }
				}
			return buses;

		
	}

	@Override
	public Booking getAllTicket() {
		Iterator it = bookingMapDb.entrySet().iterator();
		Booking booking = new Booking();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
				return (Booking) pair.getValue();
			}
		return booking;
		}

	@Override
	public Bus searchBus(int busId) {
		if(busMapDb.containsKey(busId)) {
			return bus;
		}
		return null;
	}

	@Override
	public Booking searchBookingId(int bookingId) {
		for (Map.Entry pair : bookingMapDb.entrySet()) {
			book = (Booking) pair.getValue();
			if (book.getBookingId()==bookingId) {
				return book ;
			}
		}
		return null;
	}
	}



