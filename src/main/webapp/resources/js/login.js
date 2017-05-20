'use strict';

angular.module('calendar').controller('loginCtrl', ['$scope', 'userService', function($scope, userService) {
    	var i = 0;

		$scope.user = {
		username : '',
		mail : ''
	};
	
	fetchAllUsers();

	$scope.login = function() {
		userService.addUser($scope.user).then(fetchAllUsers);
		
		fetchAllUsers();
		
		$scope.temp = 'clicked ' + i + 'times';
		i++;
	};
	
	function fetchAllUsers() {
		userService.getUsers().then(function(d){$scope.data = d;});
	}
}]);
