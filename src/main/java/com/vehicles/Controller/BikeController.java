package com.vehicles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicles.Service.BikeService;
import com.vehicles.entity.Bike;

@RestController

public class BikeController {
	@Autowired
	BikeService bs;
	@PostMapping(value ="/setBike")
	public String setBike(@RequestBody Bike bike) {
		return bs.setBike(bike);
	}
	@PostMapping(value ="/setAllBike")
	public String setAllBike(@RequestBody List<Bike> bike) {
		return bs.setAllBike(bike);
	}
	
	@GetMapping(value ="/getAllBike")
	public List<Bike> getAllBike() {
		return bs.getAllBike();
	}
	@GetMapping(path="/getById/{x}")
	public Bike getById(@PathVariable int x) {
		return bs.getById(x);
	}
	@DeleteMapping(path="/deleteId/{id}")
	public String deleteId(@PathVariable int id) {
		return bs.deleteId(id);
	}
	@GetMapping(value="/getByBrand/{b}")
	public List<Bike> getByBrand(@PathVariable String b){
		return bs.getByBrand(b);
		
	}
	@GetMapping(value="/getByPrice/{c}")
	public List<Bike>getByPrice(@PathVariable int c){
		return bs.getByPrice(c);
	}
	
	@GetMapping(value="/getByRange/{f}/{e}")
	public List<Bike>getByRange(@PathVariable int f,@PathVariable int e){
		return bs.getByRange(f,e);
	}
	@GetMapping(path ="/getBrandByColour/{color}")
	public List<String>getBrandByColour(@PathVariable String color){
		return bs.getBrandByColour(color);
	}
	@GetMapping(path="/getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value="/getReducedBike/{a}")
	public List<Bike>getReducedBike(@PathVariable int a){
		return bs.getReducedBike(a);
	}
	@GetMapping(value="/getMinimumBike")
	public Bike getMinimumBike(){
		return bs.getMinimumBike();
	}
	@GetMapping(path="/getFuel/{f}")
	public Long getFuel(@PathVariable String  f) {
		return bs.getFuel(f);
	}
}
