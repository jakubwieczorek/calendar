'use strict';

angular.module('calendar').controller('loginCtrl', ['$scope', 'userService', function($scope, userService) {

    $scope.username = '';
    $scope.mail = '';

    var user = {
        username : {
            username : '',
            mail : ''
        }
    };

	fetchAllUsers();

	$scope.login = function() {
		userService.addUser(user).then(fetchAllUsers());
	};

	$scope.updateUser = function(user) {
	    userService.updateUser(user).then(fetchAllUsers());
    };

    function fetchAllUsers() {
        userService.getUsers().then(function(d){$scope.data = d;});
    }
}]);
