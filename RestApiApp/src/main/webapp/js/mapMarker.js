
//Angular App Module and Controller
var sampleApp = angular.module('mapMarker', []);

sampleApp.controller('mapCtrl2', function ($scope, $http) {
    
    $scope.hideMap = true;
    $scope.cities = [];
    $scope.foodTrucks = [];    
    
    $scope.getCities = function() {                
        $http.get("/RestApiApp/rest/foodtruck/cities")
        .then(    function success(response) {
                    $scope.cities = response.data;    
                    $scope.cityToMap = $scope.cities[0];
        },
                function error(response) {
                    alert("error, return status: " + response.status);
                }        
        );        
    }
      
    $scope.mapIt = function(selectedCity) {        
        
        $http.get("/RestApiApp/rest/foodtruck/locations/"+selectedCity.city)
        .then(    function success(response) {
                    $scope.foodTrucks = response.data;
                    $scope.displayMap(selectedCity);
                    
        },
                function error(response) {
                    alert("error, return status: " + response.status);
                }        
        );            
        
    }
    
    $scope.displayMap = function(selectedCity) {
            
        var mapOptions = {
                zoom: 13,
                center: new google.maps.LatLng(selectedCity.lat, selectedCity.lon), 
                mapTypeId: google.maps.MapTypeId.TERRAIN
        }
        
        $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
        $scope.markers = [];
          
        var infoWindow = new google.maps.InfoWindow();
          
        var createMarker = function (truck) {
              
              var marker = new google.maps.Marker({
                  map: $scope.map,
                  position: new google.maps.LatLng(truck.lat, truck.lon),
                  title: truck.name
              });
              marker.content = '<div class="infoWindowContent">' + truck.locationDescription + '</div>';
              
              google.maps.event.addListener(marker, 'click', function(){
                  infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
                  infoWindow.open($scope.map, marker);
              });
              
              $scope.markers.push(marker);              
        }  
          
        for (i = 0; i < $scope.foodTrucks.length; i++){
              createMarker($scope.foodTrucks[i]);
        }
        
        $scope.hideMap = false;        
    }
    
    $scope.openInfoWindow = function(e, selectedMarker){
          e.preventDefault();
          google.maps.event.trigger(selectedMarker, 'click');
    }
    
    $scope.getCities();    
      
    
});