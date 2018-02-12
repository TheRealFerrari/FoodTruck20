package com.aca.rest.controller;

import java.util.List;
/**
 * Controller is the traffic cop of the app.
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aca.rest.model.FoodTruck;
import com.aca.rest.service.FoodTruckService;

/**
 * 
 * @author Ferrari
 *
 */
@Path("/foodTruck")
public class FoodTruckController {

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FoodTruck> getAllFoodTrucks() {

		FoodTruckService service = new FoodTruckService();
		List<FoodTruck> foodTrucks = service.getAllFoodTrucks();
		return foodTrucks;
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public int updateFoodTruck(FoodTruck foodTruck) {
		FoodTruckService service = new FoodTruckService();
		int rowsDeleted = service.updateFoodTruck(foodTruck);

		return rowsDeleted;

	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public int insertFoodTruck(FoodTruck foodTruck) {
		FoodTruckService service = new FoodTruckService();
		int rowsInserted = service.insertFoodTruck(foodTruck);

		return rowsInserted;
	}

}
