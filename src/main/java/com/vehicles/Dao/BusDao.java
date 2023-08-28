package com.vehicles.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicles.Repository.BusRepository;
import com.vehicles.customException.IdNotFoundException;
import com.vehicles.entity.Bus;

@Repository
public class BusDao {
	@Autowired
	BusRepository br;

	public String setAc(Bus bus) {
		br.save(bus);
		return "SUCCESS";
	}

	public String setAllBus(List<Bus> bus) {
		br.saveAll(bus);
		return "SUCCESSFULL";
	}

	public List<Bus> getAllBus() {
		return br.findAll();
	}

	public Bus getById(int i) throws IdNotFoundException{
		return br.findById(i).orElseThrow(()->new IdNotFoundException("Id not found"));
	}

	public List<Bus> getByBrand(String a) {	
		return br.getByBrand(a);
	}
}


		

