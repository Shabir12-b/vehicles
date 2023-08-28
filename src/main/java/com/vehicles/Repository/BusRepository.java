package com.vehicles.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicles.entity.Bus;

public interface BusRepository  extends JpaRepository<Bus, Integer>{
    @Query(value="select * from bus_details where brand = ? ", nativeQuery=true)
	List<Bus> getByBrand(String a);

}
