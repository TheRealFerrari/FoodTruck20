package com.aca.rest.service;

/**
 * Business logic and validation for customers.
 * 
 * this class isn't need but useful.
 * @author Ferrari
 *
 */
import java.util.List;


import com.aca.rest.dao.FoodTruckDao;
import com.aca.rest.model.FoodTruck;


public class FoodTruckService {

	    public List<FoodTruck> getAllFoodTrucks()
	    {
	        FoodTruckDao foodTruck = new FoodTruckDao();
	        return foodTruck.getAllFoodTrucks();
	    }
	    
	    public int updateFoodTruck (FoodTruck foodTruck)
	    {
	    	FoodTruckDao foodTruckDao = new FoodTruckDao();
	    	return foodTruckDao.updateFoodTruck(foodTruck);
	    }
	    
	    public int insertFoodTruck(FoodTruck foodTruck)
	    {
	    	FoodTruckDao foodTruckDao = new FoodTruckDao();
	    	return foodTruckDao.insertFoodTruck(foodTruck);
	    }
	}


