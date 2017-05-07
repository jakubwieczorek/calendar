var app = angular.module('calendar', []);

app.controller('loginCtrl',function($scope)
{
    var i = 0;

	temp = 'clicked 0 times';

    $scope.login = function()
    {
        $scope.temp = 'clicked ' + i + 'times';
	i++;
    };
});
