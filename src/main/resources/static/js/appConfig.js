(function () {	
    'use strict';    
    var appModule = angular.module('appModule');  
    appModule.constant ('base', 'http://localhost:8080/index.html/');

    appModule.config ( [ '$routeProvider',  '$locationProvider', 
	function($routeProvider, $locationProvider){
    	$routeProvider
            .when('/businesses',  {
                templateUrl: 'businessesTemplate.html',
                controller: 'BusinessController as ctrl'
            })
            .when('/details/:businessId',  {
                templateUrl: '/detailsTemplate.html',
                controller: 'BusinessController as ctrl'
            })
            .otherwise({
                redirectTo: '/businesses',
            });

    	$locationProvider.html5Mode({
    		enabled: true,
    		requireBase: false
        });
    }]);

})();
