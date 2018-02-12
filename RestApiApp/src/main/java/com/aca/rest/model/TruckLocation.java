package com.aca.rest.model;

public class TruckLocation {

	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public String getLat() {
		return lat;
	}
	public String getLon() {
		return lon;
	}
	public String getCityLat() {
		return cityLat;
	}
	public String getCityLon() {
		return cityLon;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public void setCityLat(String cityLat) {
		this.cityLat = cityLat;
	}
	public void setCityLon(String cityLon) {
		this.cityLon = cityLon;
	}
	private String name;
	private String city;
	private String locationDescription;
	private String lat;
	private String lon;
	private String cityLat;
	private String cityLon;
	
	
}
