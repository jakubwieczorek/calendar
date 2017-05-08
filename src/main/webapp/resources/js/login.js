var app = angular.module('calendar', []);

app.controller('loginCtrl', function($scope, $http)
{
    	var i = 0;

	temp = 'clicked 0 times';

    	$scope.login = function()  
	{
		$scope.temp = 'clicked ' + i + 'times';
		i++;
	};

	$http.get('localhost:8080/calendar/login').then(function(response)
	{
		$scope.data = response.data;
	});
});
