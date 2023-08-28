package com.vehicles.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicles.Dao.BusDao;
import com.vehicles.customException.BrandNotFoundException;
import com.vehicles.customException.IdNotFoundException;
import com.vehicles.customException.InvalidBoardException;
import com.vehicles.entity.Bus;

@Service
public class BusService {
	@Autowired
	BusDao bd;

	public String setBus(Bus bus) throws InvalidBoardException {
//		try {
			if (bus.getBoard().equalsIgnoreCase("white")) {
			return bd.setAc(bus);
		} 
		else {
			throw new InvalidBoardException("InvalidBoard");
		}
	//}
//	catch (InvalidBoardException a){
//		return "InvalidData";
//	}
}

	public String setAllBus(List<Bus> bus) throws InvalidBoardException {
		List<Bus> z = bus.stream().filter(x->x.getBoard().equalsIgnoreCase("white")||x.getBoard().equalsIgnoreCase("black")).toList();
		//List<Bus> v = bus.stream().filter(x->x.getBoard().equalsIgnoreCase("Black")).toList();
		//List<Bus> h = bus.stream().filter(y->y.getBoard().equalsIgnoreCase("white")).toList();
         if(z.isEmpty()) {
        	 throw new InvalidBoardException("Invalid");
		}
		else {
			return bd.setAllBus(z);	
		}
	}

	public List<Bus> getAllBus() {
		return bd.getAllBus();
	}

	public Bus getById(int i)throws IdNotFoundException{
		return bd.getById(i);
	}

	public List<Bus> getByBrand(String a) throws BrandNotFoundException{
		//List<Bus>n = getAllBus();
		//List<Bus>o=	n.stream().filter(x->x.getBrand().equalsIgnoreCase(a)).toList();
		List<Bus> o = bd.getByBrand(a);
		if(o.isEmpty()) {
			throw new BrandNotFoundException("NO Brand found");
	}
		else {
			return o;
		}	
  }

	public String update(int i, Bus b) throws IdNotFoundException, InvalidBoardException {
		Bus x = getById(i);
		Bus y = b;
		
		x.setId(i);
		x.setName(y.getName());
		x.setNoOfSeat(y.getNoOfSeat());
		x.setNoPlate(y.getNoPlate());
		x.setBoard(y.getBoard());
	    setBus(x);
	    return"Updated";
	}
	

	
}
