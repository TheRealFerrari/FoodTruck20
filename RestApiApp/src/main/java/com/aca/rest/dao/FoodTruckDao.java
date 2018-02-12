package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aca.rest.model.City;
import com.aca.rest.model.Customer;
import com.aca.rest.model.FoodTruck;
import com.aca.rest.model.TruckLocation;
import com.aca.rest.service.FoodTruckService;

public class FoodTruckDao {

	/*
	 * DAO encapsulates our logic to retrieve customers from Maria DB.
	 *
	 */

	// " SELECT FoodTruckID,
	// FoodTruckName,FoodTruckCity,FoodTruckPhoneNumber,FoodType
	private final static String SQL_SELECT_FoodTruck = "  SELECT FoodTruckID, FoodTruckName, FoodTruckPhoneNumber, FoodTruckCity, FoodTruckStreetAddress, StateCode "
			+ "  FROM foodTruck ";

	private final static String SQL_UPDATE_FoodTruck = " UPDATE foodtruck"
			+ " SET FoodTruckName = ?, FoodTruckPhoneNumber = ?, FoodTruckStreetAddress = ?, FoodTruckCity = ?"
			+ " WHERE FoodTruckID = ? " + "StateCode = ?" + "Mexican = ?" + "Burgers = ?" + "Asian = ?" + "Seafood ?"
			+ "Cajun = ?" + "Health Food = ?";

	private final static String SQL_INSERT_FoodTruck = "  INSERT INTO foodTruck "
			+ "( FoodTruckName,FoodTruckPhoneNumber, FoodTruckStreetAddress, FoodTruckCity, StateCode, Mexican, Burgers, Asian, Seafood, Cajun, HealthFood ) "
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

	public List<FoodTruck> getAllFoodTrucks() {

		List<FoodTruck> foodTrucks = new ArrayList<FoodTruck>();

		ResultSet result = null;
		Statement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try {

			statement = conn.createStatement();
			// statement.setString(1,, TruckID);
			/*
			 * Returns a ResultSet object. Use this method when you expect to
			 * get a result set, as you would with a SELECT statement.
			 */
			result = statement.executeQuery(SQL_SELECT_FoodTruck);

			while (result.next()) {
				FoodTruck foodTruck = new FoodTruck();
				foodTruck.setFoodTruckId(result.getString("FoodTruckID"));
				foodTruck.setFoodTruckName(result.getString("FoodTruckName"));
				foodTruck.setFoodTruckPhoneNumber(result.getString("FoodTruckPhoneNumber"));
				foodTruck.setFoodTruckStreetAddress(result.getString("FoodTruckStreetAddress"));
				foodTruck.setFoodTruckCity(result.getString("FoodTruckCity"));
				foodTruck.setState(result.getString("StateCode"));

				// foodTruck.setFoodTruckType(result.getString("Mexican,
				// Burgers,Asian,Seafood,Cajun,Health Food"));
				foodTrucks.add(foodTruck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				/*
				 * Close a Connection object to save database resources, for the
				 * same reason you should also close the Statement object. A
				 * simple call to the close() method will do the job. If you
				 * close the Connection object first, it will close the
				 * Statement object as well. However, you should always
				 * explicitly close the Statement object to ensure proper
				 * cleanup.
				 */
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return foodTrucks;
	}

	public int updateFoodTruck(FoodTruck foodTruck) {
		int rowsUpdated = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();
		try {
			statement = conn.prepareStatement(SQL_UPDATE_FoodTruck);
			statement.setString(1, foodTruck.getFoodTruckId());
			statement.setString(2, foodTruck.getFoodTruckName());
			statement.setString(3, foodTruck.getFoodTruckPhoneNumber());
			statement.setString(4, foodTruck.getFoodTruckCity());
			statement.setString(5, foodTruck.getFoodTruckStreetAddress());
			statement.setString(6, foodTruck.getStateCode());
			// statement.setString(7, foodTruck.getFoodTruckType());
			rowsUpdated = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;

	}

	public int insertFoodTruck(FoodTruck foodTruck) {
		int rowsInserted = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();
		try {
			statement = conn.prepareStatement(SQL_INSERT_FoodTruck);
			// statement.setString(1, foodTruck.getFoodTruckId());
			statement.setString(1, foodTruck.getFoodTruckName());
			statement.setString(2, foodTruck.getFoodTruckPhoneNumber());
			statement.setString(3, foodTruck.getFoodTruckStreetAddress());
			statement.setString(4, foodTruck.getFoodTruckCity());
			statement.setString(5, foodTruck.getStateCode());
			statement.setBoolean(6, foodTruck.isMexican());
			statement.setBoolean(7, foodTruck.isBurgers());
			statement.setBoolean(8, foodTruck.isAsian());
			statement.setBoolean(9, foodTruck.isSeafood());
			statement.setBoolean(10, foodTruck.isCajun());
			statement.setBoolean(11, foodTruck.isHealthFood());

			rowsInserted = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rowsInserted;
	}

	private final static String SQL_SELECT_LOCATIONS_BY_CITY = " SELECT t.Name, tl.City, tl.LocationDescription, tl.Lat, tl.Lon, c.Lat AS cityLat, c.Lon AS cityLon "
			+ " FROM trucklocation tl " + " JOIN truck t on t.truckId = tl.truckId "
			+ " JOIN city c on c.city = tl.city " + " WHERE tl.city = ? ";

	private final static String SQL_SELECT_CITY = " SELECT city, lat, lon " + " FROM city ";

	public List<TruckLocation> getLocationsByCity(String city) {

		ResultSet result = null;
		PreparedStatement statement = null;
		List<TruckLocation> truckLocations = new ArrayList<TruckLocation>();

		Connection conn = MariaDbUtil.getConnection();

		try {
			statement = conn.prepareStatement(SQL_SELECT_LOCATIONS_BY_CITY);
			statement.setString(1, city);

			result = statement.executeQuery();
			while (result.next()) {
				TruckLocation truckLocation = new TruckLocation();
				truckLocation.setName(result.getString("name"));
				truckLocation.setCity(result.getString("city"));
				truckLocation.setLocationDescription(result.getString("locationDescription"));
				truckLocation.setLat(result.getString("lat"));
				truckLocation.setLon(result.getString("lon"));
				truckLocation.setCityLat(result.getString("cityLat"));
				truckLocation.setCityLon(result.getString("cityLon"));

				truckLocations.add(truckLocation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return truckLocations;
	}

	public List<City> getCities() {
		ResultSet result = null;
		Statement statement = null;
		List<City> cities = new ArrayList<City>();

		Connection conn = MariaDbUtil.getConnection();

		try {
			statement = conn.createStatement();

			result = statement.executeQuery(SQL_SELECT_CITY);
			while (result.next()) {
				City city = new City();
				city.setCity(result.getString("city"));
				city.setLat(result.getString("lat"));
				city.setLon(result.getString("lon"));

				cities.add(city);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cities;
	}
}
