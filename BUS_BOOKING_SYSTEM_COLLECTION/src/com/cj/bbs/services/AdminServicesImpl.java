package com.cj.bbs.services;

import java.util.HashMap;

import com.cj.bbs.beans.Admin;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.dao.AdminDaoBBS;
import com.cj.bbs.dao.AdminDaoImpl;

public class AdminServicesImpl implements AdminServices {

	AdminDaoBBS admin = new AdminDaoImpl();

	@Override
	public Boolean createBus(Bus bus) {
		return admin.createBus(bus);
	}

	@Override
	public Boolean updateBus(String source, String destination, Double price, Integer busId) {
		return admin.updateBus(source, destination, price, busId);
	}

	@Override
	public Bus searchBus(int busId) {
		return admin.searchBus(busId);
	}

	@Override
	public Boolean deletebus(int busId) {
		return admin.deletebus(busId);
	}

	@Override
	public HashMap<Integer, Bus> busBetween(String source, String destination) {
		return admin.busBetween(source, destination);
	}

	@Override
	public Boolean adminLogin(int adminId, String password) {
		return admin.adminLogin(adminId, password);
	}

	@Override
	public Admin searchAdmin(Integer adminId) {
		return admin.searchAdmin(adminId);
	}

}
