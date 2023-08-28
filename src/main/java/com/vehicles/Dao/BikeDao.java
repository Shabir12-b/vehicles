package com.vehicles.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicles.Repository.BikeRepository;
import com.vehicles.entity.Bike;

@Repository
public class BikeDao {
	@Autowired
	BikeRepository br;
	public String setBike(Bike bike) {
		br.save(bike);
		return "SUCCESS";
	}
	public String setAllBike(List<Bike> bike) {
		br.saveAll(bike);
		return "SUCCESSFULL";
	}
	public List<Bike> getAllBike() {
		return br.findAll();
	}
	public Bike getById(int x) {
		
		return br.findById(x).get();
	}
	public String deleteId(int id) {
		
		br.deleteById(id);
		return "DELETED";
	}
	
	

}
