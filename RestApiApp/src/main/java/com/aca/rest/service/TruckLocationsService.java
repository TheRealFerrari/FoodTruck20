package com.aca.rest.service;
import java.util.List;

import com.aca.rest.dao.FoodTruckDao;
import com.aca.rest.model.City;
import com.aca.rest.model.TruckLocation;


public class TruckLocationsService {

	public List<TruckLocation> getAllTruckLocations(String city) {
		FoodTruckDao foodTruckDao = new FoodTruckDao();
		return foodTruckDao.getLocationsByCity(city);
		
	}
	
	public List <City> getCities(){
		FoodTruckDao foodTruckDao = new FoodTruckDao();
		return foodTruckDao.getCities();
	}
	
	

}
