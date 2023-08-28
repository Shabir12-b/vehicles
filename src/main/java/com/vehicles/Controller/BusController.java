package com.vehicles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.vehicles.Service.BusService;
import com.vehicles.customException.BrandNotFoundException;
import com.vehicles.customException.IdNotFoundException;
import com.vehicles.customException.InvalidBoardException;
import com.vehicles.entity.Bus;


@RestController
@RequestMapping(value="/bu")
public class BusController {
	@Autowired
	BusService bs;
	@PatchMapping(value="/setBus")
	public String setBus(@RequestBody Bus bus) throws InvalidBoardException {
		return bs.setBus(bus);
	}
	@PostMapping(value="/setAllBus") 
	public String setAllBus(@RequestBody List<Bus> bus)throws InvalidBoardException {
		return bs.setAllBus(bus);
	}
	@GetMapping(value="/getAllBus")
	public List<Bus> getAllBus(){
		return bs.getAllBus();
	}
	@GetMapping(value="/getById/{i}")
	public Bus getById(@PathVariable int i)throws IdNotFoundException{
		return bs.getById(i);
	}
	@GetMapping(value="/getByBrand/{a}")
	public List<Bus> getByBrand(@PathVariable String a)throws BrandNotFoundException {
		return bs.getByBrand(a);
	}
	@PutMapping(value="/update/{i}")
	public String update(@PathVariable int i, @RequestBody Bus b) throws IdNotFoundException, InvalidBoardException {
		return bs.update(i,b);
	}
	

}
