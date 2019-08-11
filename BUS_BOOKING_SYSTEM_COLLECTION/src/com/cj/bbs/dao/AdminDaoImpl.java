package com.cj.bbs.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.cj.bbs.beans.Admin;
import com.cj.bbs.beans.Bus;
import com.cj.bbs.repository.Repository;

public class AdminDaoImpl implements AdminDaoBBS {

	Repository repo = new Repository();
	HashMap<Integer, Bus> busdb = repo.bus;
	HashMap<Integer, Admin> admindb = repo.admin;
	Admin admin = new Admin();

	@Override
	public Boolean createBus(Bus bus) {

		busdb.put(bus.getBusId(), bus);
		if (bus != null) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean updateBus(String source, String destination, Double price, Integer busId) {

		Bus bus = searchBus(busId);
		if (bus != null) {
			bus.setSource(source);
			bus.setDestination(destination);
			bus.setPrice(price);
			busdb.put(bus.getBusId(), bus);
			return true;

		}

		return false;
	}

	@Override
	public Bus searchBus(int busId) {
		Bus bus = null;
		Iterator it = busdb.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().equals(busId)) {
				return (Bus) pair.getValue();
			}

		}
		return bus;
	}

	@Override
	public Boolean deletebus(int busId) {

		Bus bus = searchBus(busId);
		if (bus != null) {
			busdb.remove(busId);
			return true;
		}
		return false;
	}

	@Override
	public HashMap<Integer, Bus> busBetween(String source, String destination) {
		HashMap<Integer, Bus> map = new HashMap<>();
		Bus bus = new Bus();
		if (bus.getSource().equalsIgnoreCase(source) && bus.getDestination().equalsIgnoreCase(destination)) {

			Bus b = searchBus(bus.getBusId());
			map.put(bus.getBusId(), bus);
			return map;

		}
		return null;
	}

	@Override
	public Boolean adminLogin(int adminId, String password) {

		if (admindb.containsKey(adminId)) {
			Admin admin = admindb.get(adminId);
			if (admin.getPassword().equals(password)) {
				return true;

			}

		}
		return false;
	}

	@Override
	public Admin searchAdmin(Integer adminId) {

		Admin admin = null;
		Iterator it = admindb.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().equals(adminId)) {
				return (Admin) pair.getValue();
			}

		}

		return admin;
	}

}
