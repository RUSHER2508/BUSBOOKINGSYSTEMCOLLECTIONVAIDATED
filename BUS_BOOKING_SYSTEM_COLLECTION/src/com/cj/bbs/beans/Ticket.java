package com.cj.bbs.beans;

import java.sql.Date;

public class Ticket {

	private Integer bookingId;
	private String journeyDate;
	private Integer numofSeats;
	private String bookingDatetime;
	private Integer availId;
	private String availDate;
	private Integer availSeats;
	private Integer userId;
	private Integer busId;
	private String source;
	private String destination;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Integer getNumofSeats() {
		return numofSeats;
	}

	public void setNumofSeats(Integer numofSeats) {
		this.numofSeats = numofSeats;
	}

	public String getBookingDatetime() {
		return bookingDatetime;
	}

	public void setBookingDatetime(String bookingDatetime) {
		this.bookingDatetime = bookingDatetime;
	}

	public Integer getAvailId() {
		return availId;
	}

	public void setAvailId(Integer availId) {
		this.availId = availId;
	}

	public String getAvailDate() {
		return availDate;
	}

	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}

	public Integer getAvailSeats() {
		return availSeats;
	}

	public void setAvailSeats(Integer availSeats) {
		this.availSeats = availSeats;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Ticket [bookingId=" + bookingId + ", journeyDate=" + journeyDate + ", numofSeats=" + numofSeats
				+ ", bookingDatetime=" + bookingDatetime + ", availId=" + availId + ", availDate=" + availDate
				+ ", availSeats=" + availSeats + ", userId=" + userId + ", busId=" + busId + ", source=" + source
				+ ", destination=" + destination + "]";
	}

}
