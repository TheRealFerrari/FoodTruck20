package com.aca.rest.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import com.aca.rest.model.City;
import com.aca.rest.model.TruckLocation;
import com.aca.rest.service.TruckLocationsService;


@Path("/foodtruck")
public class MapMarkerController {

	@GET
	@Path("/locations/{city}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<TruckLocation> getAllTruckLocaions(@PathParam("city") String city) {

		TruckLocationsService service = new TruckLocationsService();
		List<TruckLocation> locations = service.getAllTruckLocations(city);
		return locations;
	}
	
	@GET
	@Path("/cities")
	@Produces({MediaType.APPLICATION_JSON})
	public List<City> getCities(){
		
		TruckLocationsService service = new TruckLocationsService();
		List<City> cities = service.getCities();
		return cities;
	}
}
