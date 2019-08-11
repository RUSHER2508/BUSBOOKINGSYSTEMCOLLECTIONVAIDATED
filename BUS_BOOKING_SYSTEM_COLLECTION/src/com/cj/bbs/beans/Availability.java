package com.cj.bbs.beans;

public class Availability {

	private String availDate;
	private Integer availId;
	private Integer availSeats;
	private String journeyDate;
	private Integer busId;

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getAvailDate() {
		return availDate;
	}

	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}

	public Integer getAvailId() {
		return availId;
	}

	public void setAvailId(Integer availId) {
		this.availId = availId;
	}

	public Integer getAvailSeats() {
		return availSeats;
	}

	public void setAvailSeats(Integer availSeats) {
		this.availSeats = availSeats;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "Availability [availDate=" + availDate + ", availId=" + availId + ", availSeats=" + availSeats
				+ ", journeyDate=" + journeyDate + ", busId=" + busId + "]";
	}

}
