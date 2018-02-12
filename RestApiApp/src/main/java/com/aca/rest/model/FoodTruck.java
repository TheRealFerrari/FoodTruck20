package com.aca.rest.model;



public class FoodTruck {	
	
	    
	    private String foodTruckId;
	    
	    private String foodTruckName;
	    
	    private String foodTruckPhoneNumber;
	    
	    private String foodTruckCity;
	    
	    private String foodTruckStreetAddress;
	    
	    private String stateCode;
	    
	    private boolean mexican;
	    
	    private boolean burgers;
	    
	    private boolean asian;
	    
	    private boolean seafood;
	    
	    private boolean cajun;
	    
	    private boolean healthFood;
	    
	    //private String foodTruckType;
	   
		 public boolean isMexican() {
			return mexican;
		}


		public boolean isBurgers() {
			return burgers;
		}


		public boolean isAsian() {
			return asian;
		}


		public boolean isSeafood() {
			return seafood;
		}


		public boolean isCajun() {
			return cajun;
		}


		public boolean isHealthFood() {
			return healthFood;
		}


		public void setMexican(boolean mexican) {
			this.mexican = mexican;
		}


		public void setBurgers(boolean burgers) {
			this.burgers = burgers;
		}


		public void setAsian(boolean asian) {
			this.asian = asian;
		}


		public void setSeafood(boolean seafood) {
			this.seafood = seafood;
		}


		public void setCajun(boolean cajun) {
			this.cajun = cajun;
		}


		public void setHealthFood(boolean healthFood) {
			this.healthFood = healthFood;
		}


		public String getFoodTruckId() {
			return foodTruckId;
		}


		public String getFoodTruckName() {
			return foodTruckName;
		}


		public String getFoodTruckPhoneNumber() {
			return foodTruckPhoneNumber;
		}


	

		public String getFoodTruckStreetAddress() {
			return foodTruckStreetAddress;
		}


		public String getStateCode() {
			return stateCode;
		}


		public void setFoodTruckId(String foodTruckId) {
			this.foodTruckId = foodTruckId;
		}


		public void setFoodTruckName(String foodTruckName) {
			this.foodTruckName = foodTruckName;
		}


		public void setFoodTruckPhoneNumber(String foodTruckPhoneNumber) {
			this.foodTruckPhoneNumber = foodTruckPhoneNumber;
		}


		

		public void setFoodTruckStreetAddress(String foodTruckStreetAddress) {
			this.foodTruckStreetAddress = foodTruckStreetAddress;
		}


		public void setState(String state) {
			this.stateCode = state;
		}


		public String getFoodTruckCity() {
			return foodTruckCity;
		}


		public void setFoodTruckCity(String foodTruckCity) {
			this.foodTruckCity = foodTruckCity;
		}


		@Override
		    public String toString()
		    {
		        StringBuffer value = new StringBuffer();
		        value.append("Truck ID: ");
		        value.append(foodTruckId);
		        value.append("\n");
		        value.append(" Truck Name: ");
		        value.append(foodTruckName);
		        value.append("\n");
		        value.append("Truck Phone Number: ");
		        value.append(foodTruckPhoneNumber);
		        value.append("Street Address:");
		        value.append(foodTruckStreetAddress);
		        value.append("\n");
		        value.append("city: ");
		        value.append(foodTruckCity);
		        value.append("\n");
		        value.append("State: ");
		        value.append(stateCode);
		        value.append("\n");
		        //value.append("Food Truck Type:");
		        //value.append(foodTruckType);
		       // value.append("\n");
		        return value.toString();
		    



		//public String getFoodTruckType() {
		//	return foodTruckType;
		


		//public void setFoodTruckType(String foodTruckType) {
		//	this.foodTruckType = foodTruckType;
		}


		}
	    

