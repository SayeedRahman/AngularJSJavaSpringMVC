(function () {
    'use strict';
    angular.module ('appModule').controller('BusinessController', BusinessController);

    BusinessController.$inject = ['$routeParams', '$http'];

    function BusinessController ($routeParams, $http) {
        var self = this;
        self.Url = '';
        self.business = {};	
        self.business.businessId = $routeParams.businessId;
        self.businesses = [];       
        self.message = '';        
        //---------------------------------------------------------------
        //This method is for testing the RESTful POST call
        self.getDetails = function () {
            self.Url = "/getDetails";
            self._business = {};
            self._business.businessId = 5;
            self._business.address = "678 Any Street";
            self._business.date = new Date().toString();
            self._business.email = "email6@gmail.com";
            self._business.name = "Business Name Six";
            self._business.telephone = "6136136164";
            self._business.url = "www.example6.com";
            $http.post(self.Url, self._business).then(function success(d) {
	                self.business = d.data;
	        	},
	          	function failure(response){
	               	self.message = "Status: " + response.status + ", \nData: " + response.data;
	               	alert ('response failed.\n' + self.message );
	        });
        };
        //---------------------------------------------------------------
        self.getBusiness = function (businessId) {
        	if (businessId > -1) {
	            self.Url = "/getBusiness/" + businessId;   
	            $http.get(self.Url).then(function success(d) {
	                	self.business = d.data;
		            },
		            function failure(response){
		            	self.message = "Status: " + response.status + ", \nData: " + response.data;
		                alert ('response failed.\n' + self.message );
		           	});
        	}
        };
        //---------------------------------------------------------------
        self.getBusinesses = function () {
            self.Url = "/getBusinesses";   
            $http.get(self.Url).then(function success(d) {
                	self.businesses = d.data;
	            },
	            function failure(response){
	            	self.message = "Status: " + response.status + ", \nData: " + response.data;
	                alert ('response failed.\n' + self.message );
	           	});
        };
        //---------------------------------------------------------------
        self.setupBusinessController = function () {
            if ( self.business.businessId > -1 ) {
                self.getBusiness( self.business.businessId );
                //self.getDetails();
            }
            else {
                self.getBusinesses(); 
            };
        };
        self.setupBusinessController();
        //---------------------------------------------------------------
    };
})();