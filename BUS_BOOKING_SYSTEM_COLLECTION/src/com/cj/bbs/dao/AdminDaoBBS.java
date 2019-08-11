package com.cj.bbs.dao;

import java.util.HashMap;

import com.cj.bbs.beans.Admin;
import com.cj.bbs.beans.Bus;

public interface AdminDaoBBS {

	// bus manipulations

	public Boolean createBus(Bus bus); // For create operation of bus

	// For update operation of bus
	public Boolean updateBus(String source, String destination, Double price, Integer bus_id);

	// For search operation using bus id
	public Bus searchBus(int bus_id);

	// For delete operation
	public Boolean deletebus(int bus_id);

	// For searching bus between source and destination

	public HashMap<Integer, Bus> busBetween(String source, String destination);

	// admin
	public Boolean adminLogin(int admin_id, String password); // For admin login

	public Admin searchAdmin(Integer admin_id); // For search operation of admin

}
