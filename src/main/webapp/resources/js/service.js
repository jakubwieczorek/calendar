'use strict';

angular.module('calendar').factory('userService', ['$q', '$http',  function($q, $http) {
	var URL = 'http://localhost:8080/calendar/users';

	var factory = {
		getUsers : getUsers, // hoisting
		addUser : addUser
	};

	return factory;	

	function getUsers() {
		var deferred = $q.defer();
		
		$http.get(URL).then(function(result) {
			deferred.resolve(result.data);
		});
		
		return deferred.promise;
	}

	function addUser(user) {
		var deferred = $q.defer();
		
		$http.post(URL, user).then(function(result) {
			deferred.resolve(result.data);
		});

		return deferred.promise;
	}
}]);
