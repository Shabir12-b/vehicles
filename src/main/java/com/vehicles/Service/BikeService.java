package com.vehicles.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicles.Dao.BikeDao;
import com.vehicles.entity.Bike;

@Service
public class BikeService {
	@Autowired
	BikeDao bd;
	
	
	public String setBike(Bike bike) {
		return bd.setBike(bike);		
	}

	public String setAllBike(List<Bike> bike) {	
		return bd.setAllBike(bike);
	}

	public List<Bike> getAllBike() {
		return bd.getAllBike();
	}

	public Bike getById(int x) {
		return bd.getById(x);
	}

	public String deleteId(int id) {
		return bd.deleteId(id);
	}

	public List<Bike> getByBrand(String b) {
		List<Bike> y= getAllBike();
		List<Bike> z = y.stream().filter(m->m.getBrand().equalsIgnoreCase(b)).collect(Collectors.toList());
		return z;
	}

	public List<Bike> getByPrice(int c) {
		List<Bike>j= getAllBike();
		List<Bike>n= j.stream().filter(k->k.getPrice()>c).collect(Collectors.toList());
		return n;
	}

	public List<Bike> getByRange(int f, int e) {
		List<Bike>p = getAllBike();
		List<Bike>o = p.stream().filter(l->l.getPrice()>f && l.getPrice()<e).collect(Collectors.toList());
		return o;
	}

	public List<String> getBrandByColour(String color) {
		List<Bike>w= getAllBike();
		List<String>r = w.stream().filter(x->x.getColor().equalsIgnoreCase(color)).map(y->y.getBrand()).collect(Collectors.toList());
		return r;
	} 
	public Bike getMax() {
	List<Bike>e = getAllBike();
		Bike b = e.stream().max(Comparator.comparingInt(Bike::getPrice)).get();
		return b;
	}

	public List<Bike> getReducedBike(int a) {
		List<Bike>t= getAllBike();
		List<Bike> e=t.stream().peek(x->x.setPrice(x.getPrice()*a/100)).collect(Collectors.toList());
		return e;
	}

	public Bike getMinimumBike() {
	List<Bike>y = getAllBike();
	Bike min = y.stream().min(Comparator.comparing(Bike::getPrice)).get();
	return min;
	}

	public Long getFuel(String f) {
		List<Bike>r = getAllBike();
		Long count = r.stream().filter(x->x.getFyelType().equalsIgnoreCase(f)).count();
		return count;
	//	return getAllBike().stream().filter(x->x.getFyelType().equalsIgnoreCase(f)).count();
	}

	
	
	

}
