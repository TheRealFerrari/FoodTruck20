

/*
 * Angular module and controller for the create truck page and features.
 * 
 */
var createApp = angular.module('FoodTruck20', []);

createApp.controller('truckCreateCtrl', function($scope, $http) {
	$scope.hideFoodTruckEditDelete = true;
	
	$scope.cities = ['Little Rock','Conway','Fayetteville'];
	$scope.newFoodTruckCities = $scope.cities[0];
	
	$scope.foodTypes = ['Mexican','Burgers','Asian','Seafood','Cajun','Health Food'];
	$scope.newFoodTruckTypes = $scope.foodTypes[0];
		
	$scope.createTruck = function() {	


		if ($scope.newFoodTruckName == undefined ) {
			$scope.truckNameMessage = "Name is required";
		} else if ($scope.newFoodTruckName.length < 5) {
			$scope.truckNameMessage = "Truck must be 5 characters";
		} else {
			$scope.truckNameMessage = "";
		}
		
		if ($scope.newFoodTruckPhoneNumber == undefined) {
			$scope.truckPhoneNumberMessage = "phone is required";
		} else if ($scope.newFoodTruckPhoneNumber.length < 10) {
			$scope.truckPhoneNumberMessage = "phone number must be at least 10 characters";
		} else {
			$scope.truckPhoneNumberMessage = "";
		}

		if ($scope.newFoodTruckStreetAddress == undefined) {
			$scope.truckStreetAddressMessage = "street address is required";
		} else if ($scope.newFoodTruckStreetAddress.length < 10) {
			$scope.truckStreetAddressMessage = "street address must be at least 10 characters";
		} else {
			$scope.truckStreetAddressMessage = "";
		}
		
		if ( $scope.truckNameMessage == "" 
			&& 	$scope.truckPhoneNumberMessage == "" 
				&& $scope.truckStreetAddressMessage == "")
		{
			alert//("time to create food truck id: "+$scope.newFoodTruckId +
					(" name: " + $scope.newFoodTruckName +
					", city: " + $scope.newFoodTruckCity + 
					", food truck name: " + $scope.newFoodTruckName +
					", food trunk phone number: " + $scope.newFoodTruckPhoneNumber +
					", food truck street address" + $scope.newFoodTruckStreetAddress);
			
			var newFoodTruck = //newFoodTruckId : $scope.newFoodTruckId,
								{foodTruckName : $scope.newFoodTruckName,
								foodTruckPhoneNumber : $scope.newFoodTruckPhoneNumber,
								foodTruckStreetAddress : $scope.newFoodTruckStreetAddress,
								foodTruckCity : $scope.newFoodTruckCity,
								stateCode : $scope.newStateCode};
								
								
			
			$http.post("/RestApiApp/rest/foodTruck", newFoodTruck)
			.then(
					function success(response) {
						
						if (response.data == 1) {						
							alert("rows inserted: " + response.data + ", status: " + response.status);
							$scope.createStatus = "success. press 'Clear' to enter new food truck";							
						} else {
							alert("error, return status: " + response.status);
							$scope.createStatus = "error. press 'Clear' to try again";		
						}
					},
					function error(response) {
						alert("error, return status: " + response.status);
						$scope.createStatus = "error. press 'Clear' to try again";						
					}				
			);
			
			$scope.isCreateFoodTruckDisabled = true;
			$scope.lock = true;
			
		} else {
			$scope.createStatus = "please fix indicated errors";
		}				
			
	};
	
	$scope.clearCreate = function() {	
		
		//clear success or error message
		$scope.createStatus = "";
		
		//clear the input elements
		//$scope.newFoodTruckId = "";
		$scope.newFoodTruckName = "";
		$scope.newFoodTruckPhoneNumber = "";
		$scope.newFoodTruckStreetAddress = "";
		$scope.newFoodTruckCity =  $scope.cities[0];
		$scope.newFoodTruckTypes = $scope.foodTypes[0];
		
		//clear the messages
		//$scope.truckIdMessage = "";		
		$scope.truckNameMessage = "";
		$scope.truckPhoneNumberMessage = "";
		$scope.truckCityMessage = "";	
		$scope.truckStreetAddressMessage = "";
		
		//unlock input
		$scope.lock = false;
		$scope.isCreateFoodTruckDisabled = false;
	}
	
	$scope.resetSearch = function() {
		$scope.isGetFoodTrucksDisabled = false;
		$scope.isClearFoodTrucksDisabled = true;			
		$scope.hideFoodTruckSearchPage(false);
		$scope.hideFoodTruckSearchResults = true;
		$scope.hideFoodTruckEditDelete = true;
		$scope.nameFilter = "";
	}
			
	$scope.getFoodTrucks = function() {
		
		$http.get("/RestApiApp/rest/foodTruck")
		.then(
			function success(response) {
				$scope.myFoodTrucks = response.data;
				alert("good");
			},
			function error(response) {
				alert("bad");					
			});	
		
		$scope.hideFoodTruckSearchResults = false;
		$scope.isGetFoodTrucksDisabled = false;
		$scope.isClearFoodTrucksDisabled = false;		
	};	
	
	
		$scope.hideFoodTruckSearchPage = function(hide) {
			$scope.hideFoodTruckSearch = hide;		
		};
	
	$scope.updateFoodTruck = function() {
		
		alert("time to create food truck "+$scope.foodtruck.foodTruckId);
		
		$scope.jsonObject = angular.toJson($scope.foodTruck, false);
		alert("food truck json: "+$scope.jsonObject);
		
		$http.put("/RestApiApp/rest/foodtruck", $scope.jsonObject)
		.then(
				function success(response) {
					alert("rows updated: " + response.data + ", status: " + response.status);
				},
				function error(response) {
					alert("error, return status: " + response.status)
				}
		);			
		
		$scope.updateStatus = "update successful";
		$scope.isUpdateDisabled = true;	
	};	
	
	

	//*function showSlides() {
	//	var slideIndex = 1;
		//var i;
	   // var slides = document.getElementsByClassName("mySlides");
	    
	   // for (i = 0; i < slides.length; i++) {
	    //   slides[i].style.display = "none";  
	    //}
	    //slideIndex++;
	    //if (slideIndex > slides.length) {slideIndex = 1}    
	    
	    //slides[slideIndex-1].style.display = "block";  
	    
	    //setTimeout(showSlides, 5000); // Change image every 2 seconds
	//}
	 
	//showSlides();
		
});

/*
 * Angular module and controller for the food truck  search / edit page and features.
 * 

var app = angular.module('FoodTruck20', []);

app.controller('foodTruckSearchCtrl', function($scope, $http) {
	
	$scope.resetSearch = function() {
		$scope.isDiscoverFoodTrucksDisabled = false;
		$scope.isClearFoodTruckDisabled = true;			
		$scope.hideFoodTruckSearchPage(false);
		$scope.hideFoodTruckSearchResults = true;
		$scope.hideFoodTruckEditDelete = true;
		$scope.nameFilter = "";
	}
			
	$scope.getFoodTrucks = function() {
		$http.get("/RestApiApp/rest/foodTruck").then(function(response) {
			$scope.myCustomers = response.data;
		});		
		$scope.hideFoodTruckSearchResults = false;
		$scope.isDiscoverFoodTrucksDisabled = true;
		$scope.isClearFoodTruckDisabled = false;		
	};	
	
	$scope.updateFoodTruck = function() {
		
		alert("time to update food truck information "+$scope.foodTruck.foodTruckId);
		
		$scope.jsonObject = angular.toJson($scope.foodTruck, false);
		alert("food truck json: "+$scope.jsonObject);
		
		$http.put("/RestApiApp/rest/foodTruck", $scope.jsonObject)
		.then(
				function success(response) {
					alert("rows updated: " + response.data + ", status: " + response.status);
				},
				function error(response) {
					alert("error, return status: " + response.status)
				}
		);			
		
		$scope.updateStatus = "update successful";
		$scope.isUpdateDisabled = true;	
	};	
	
	$scope.editCustomer = function(foodTruck) {
		alert("edit food truck: " + foodTruck.foodTruckId + " " + foodTruck.foodTruckName);
		$scope.foodTruck = truck;
		$scope.updateStatus = "";		
		$scope.hideFoodTruckSearchPage(true);
		$scope.hideFoodTruckEditDelete = false;
		$scope.isUpdateDisabled = true;			
	};	
	
	$scope.turnUpdateOn = function(id) {
		$scope.isUpdateDisabled = false;
		$scope.updateStatus = "";
	};
	
	$scope.hideFoodTruckSearchPage = function(hide) {
		$scope.hideFoodTruckSearch = hide;		
	};
	
	//do last to initialize search when app first loads
	$scope.resetSearch();
	
});


 */


