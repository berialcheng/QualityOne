angular.module('argus', ['ngResource','ngRoute','ngTable'])
  
.factory('Applications', ['$resource', function($resource) {
	return $resource('api/config_item/:id', null,
		{
			'get'    : { method:'GET' },
			'query'  : { method:'GET' , isArray:true},
			'update' : { method:'PUT' }
		});
}])
 
.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      controller:'ListCtrl',
      templateUrl:'list.html'
    })
    .when('/edit/:applicationId', {
      controller:'EditCtrl',
      templateUrl:'detail.html'
    })
    .when('/new', {
      controller:'CreateCtrl',
      templateUrl:'detail.html'
    })
    .otherwise({
      redirectTo:'/'
    });
})

.controller('ListCtrl', function($scope, Applications, ngTableParams) {
  $scope.applications = Applications.query();
})

.controller('CreateCtrl', function($scope, $location, $timeout, Applications) {
  $scope.save = function() {
    Applications.$add($scope.application, function() {
      $timeout(function() { $location.path('/'); });
    });
  };
})
 
.controller('EditCtrl',
  function($scope, $location, $routeParams, Applications) {
    $scope.application = Applications.get({id:$routeParams.applicationId});
 
    $scope.destroy = function() {
      $scope.application.$remove();
      $location.path('/');
    };
 
    $scope.save = function() {
      $scope.application.$save();
      $location.path('/');
    };
});