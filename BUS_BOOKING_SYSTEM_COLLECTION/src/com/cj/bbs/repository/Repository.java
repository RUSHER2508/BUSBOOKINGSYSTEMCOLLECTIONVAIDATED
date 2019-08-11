package com.cj.bbs.repository;

import java.util.HashMap;

import com.cj.bbs.beans.Admin;
import com.cj.bbs.beans.Availability;
import com.cj.bbs.beans.Booking;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.beans.Ticket;
import com.cj.bbs.beans.User;

public class Repository {

	public static HashMap<Integer, User> user = new HashMap<>();
	public static HashMap<Integer,Bus> bus = new HashMap<>();
	public static HashMap<Integer,Admin> admin = new HashMap<>();
	public static HashMap<Integer, Booking> book = new HashMap<>();
	public static HashMap<Integer, Ticket> ticket = new HashMap<>();
	public static HashMap<Integer,Availability> avail = new HashMap<>();



	public Repository() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setUsername("ADAM");
		user1.setEmail("adam@gmail.com");
		user1.setPassword("123456");
		user1.setContact(8965876987l);
		user.put(user1.getUserId(), user1);
		
		User user2 = new User();
		user2.setUserId(2);
		user2.setUsername("MIKE");
		user2.setEmail("mike@gmal.com");
		user2.setPassword("mike123");
		user2.setContact(9645698744l);
		user.put(user2.getUserId(), user2);

		User user3 = new User();
		user3.setUserId(3);
		user3.setUsername("ALEX");
		user3.setEmail("alex@gmal.com");
		user3.setPassword("alex123");
		user3.setContact(8874598744l);
		user.put(user3.getUserId(), user3);

		
		User user4 = new User();
		user4.setUserId(4);
		user4.setUsername("BEN");
		user4.setEmail("ben@gmal.com");
		user4.setPassword("8745");
		user4.setContact(745675745l);
		user.put(user4.getUserId(), user4);

		User user5 = new User();
		user5.setUserId(5);
		user5.setUsername("SHROUD");
		user5.setEmail("shroud@gmal.com");
		user5.setPassword("123456");
		user5.setContact(7489635894l);
		user.put(user5.getUserId(), user5);

		
		Bus bus1 = new Bus();
		bus1.setBusId(101);
		bus1.setBusName("VOLVO");
		bus1.setSource("MUMBAI");
		bus1.setDestination("GOA");
		bus1.setBusType("NON AC");
		bus1.setPrice(450);
		bus1.setTotalSeats(40);
		bus.put(bus1.getBusId(), bus1);

		Bus bus2 = new Bus();
		bus2.setBusId(102);
		bus2.setBusName("NEETA");
		bus2.setSource("BANGALORE");
		bus2.setDestination("MUMBAI");
		bus2.setBusType(" Ac");
		bus2.setPrice(550);
		bus2.setTotalSeats(45);
		bus.put(bus2.getBusId(), bus2);


		Bus bus3 = new Bus();
		bus3.setBusId(103);
		bus3.setBusName("JAGDAMBA");
		bus3.setSource("PUNE");
		bus3.setDestination("MUMBAI");
		bus3.setBusType("NON AC");
		bus3.setPrice(550);
		bus3.setTotalSeats(50);
		bus.put(bus3.getBusId(), bus3);


		Bus bus4 = new Bus();
		bus4.setBusId(104);
		bus4.setBusName("KOHINOOR");
		bus4.setSource("GOA");
		bus4.setDestination("MUMBAI");
		bus4.setBusType("NON AC");
		bus4.setPrice(550);
		bus4.setTotalSeats(40);
		bus.put(bus4.getBusId(), bus4);


		Bus bus5 = new Bus();
		bus5.setBusId(105);
		bus5.setBusName("KOHINOOR");
		bus5.setSource("KOLHAPUR");
		bus5.setDestination("GOA");
		bus5.setBusType("NON AC");
		bus5.setPrice(550);
		bus5.setTotalSeats(40);
		bus.put(bus5.getBusId(), bus5);

		
		Admin admin1 = new Admin();
		admin1.setAdminId(1);
		admin1.setPassword("admin@123");
		admin.put(admin1.getAdminId(), admin1);


		Availability avail1 = new Availability();
		avail1.setAvailId(201);
		avail1.setAvailDate("2019-07-09");
		avail1.setAvailSeats(30);
		avail1.setBusId(101);
		avail1.setJourneyDate("2019-07-09");
		avail.put(avail1.getBusId(),avail1);
		
		Availability avail2 = new Availability();
		avail2.setAvailId(202);
		avail2.setAvailDate("2019-09-10");
		avail2.setAvailSeats(25);
		avail2.setBusId(104);
		avail2.setJourneyDate("2019-09-10");
		avail.put(avail2.getBusId(), avail2);

		
		Availability avail3 = new Availability();
		avail3.setAvailId(203);
		avail3.setAvailDate("2019-09-29");
		avail3.setAvailSeats(45);
		avail3.setBusId(105);
		avail3.setJourneyDate("2019-09-29");
		avail.put(avail3.getBusId(),avail3);
		
		Availability avail4 = new Availability();
		avail4.setAvailId(204);
		avail4.setAvailDate("2019-07-");
		avail4.setAvailSeats(45);
		avail4.setBusId(102);
		avail4.setJourneyDate("2019-07-19");
		avail.put(avail4.getBusId(),avail4);
		
		Availability avail5 = new Availability();
		avail5.setAvailId(205);
		avail5.setAvailDate("2019-07-31");
		avail5.setAvailSeats(45);
		avail5.setBusId(103);
		avail5.setJourneyDate("2019-07-31");
		avail.put(avail5.getBusId(),avail5);


		
		Booking book1 = new Booking();
		book1.setBookingId(301);
		book1.setDate("2019-07-26");
		book1.setJourneyDate("2019-07-26");
		book1.setUserId(1);
		book1.setBusId(101);
		book1.setNumOfSeats(4);
		book1.setSource("Mumbai");
		book1.setDestination("goa");
		book.put(book1.getBookingId(), book1);
		
		
		Booking book2 = new Booking();
		book2.setBookingId(302);
		book2.setBusId(102);
		book2.setDate("2019-08-26");
		book2.setJourneyDate("2019-08-26");
		book2.setUserId(2);
		book2.setNumOfSeats(4);
		book2.setSource("Bangalore");
		book2.setDestination("Mumbai");
		book.put(book2.getBookingId(), book2);


		Ticket ticket1 = new Ticket();
		ticket1.setBookingId(301);
		ticket1.setBusId(101);
		ticket1.setBookingDatetime("2019-07-25");
		ticket1.setAvailId(301);
		ticket1.setAvailSeats(30);
		ticket1.setSource("Mumbai");
		ticket1.setDestination("Goa");
		ticket.put(ticket1.getBookingId(),ticket1);
		
		
		Ticket ticket2 = new Ticket();
		ticket2.setBookingId(302);
		ticket2.setBusId(102);
		ticket2.setBookingDatetime("2019-08-20");
		ticket2.setAvailId(302);
		ticket2.setAvailSeats(40);
		ticket2.setSource("Banglore");
		ticket2.setDestination("Mumbai");
		ticket.put(ticket2.getBookingId(),ticket2);

	}
	
}
