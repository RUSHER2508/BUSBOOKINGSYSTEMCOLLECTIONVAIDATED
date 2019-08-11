package com.cj.bbs.services;

import java.util.HashMap;

import com.cj.bbs.beans.Admin;
import com.cj.bbs.beans.Bus;

public interface AdminServices {
	// bus manipulations
	public Boolean createBus(Bus bus);

	public Boolean updateBus(String source, String destination, Double price, Integer busId);

	public Bus searchBus(int busId);

	public Boolean deletebus(int busId);

	public HashMap<Integer, Bus> busBetween(String source, String destination);
	
	

	// admin
	public Boolean adminLogin(int adminId, String password);

	public Admin searchAdmin(Integer adminId);

}
