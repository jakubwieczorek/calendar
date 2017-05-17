<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 	<link href="/calendar/resources/css/home.css" rel="stylesheet" type="text/css">
    
	<head>
        	<meta charset="UTF-8"/>
        	<title>calendar</title>
    	</head>
    	
	<body ng-app="calendar">

        	<div id="container" ng-controller="loginCtrl">

            		<div id="form">
				<form>	
					<label for="username">username: </label>
					<input type="text" id="username" name="username" ng-model="user.username">
					<label for="mail">mail: </label>
					<input type="text" id="mail" name="mail" ng-model="user.mail">
					<input type="submit" value="sign-up" ng-click="login()">
				</form>
            		</div>
			
			<div id="table">
				<table>
					<thead>
						<tr>
							<td>username</td>
							<td>mail</td>
						</tr>
					</thead>
					<tbody>	
						<tr ng-repeat="x in data">
							<td><span ng-bind="x.username"></span></td>
							<td><span ng-bind="x.mail"></span></td>
						</tr>
					</tbody>
				</table>
			</div>

        	</div>
	
        	<script src="/calendar/resources/js/login.js"></script>
        	<script src="/calendar/resources/js/service.js"></script>
	</body>	
</html>
