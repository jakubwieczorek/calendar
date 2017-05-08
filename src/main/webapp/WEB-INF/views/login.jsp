<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 	<link href="/calendar/resources/css/home.css" rel="stylesheet" type="text/css">
    
	<head>
        	<meta charset="UTF-8"/>
        	<title>calendar</title>
    	</head>
    	
	<body>
        	<h1>Calendar app</h1>

        	<div ng-app="calendar">

            		<div ng-controller="loginCtrl">
                		
				Name: <input ng-model="name">

                		<p class="submit" ng-click="login()">login</p>

                		{{temp}}

				<p>{{data}}</p>
		 
            		</div>

        	</div>
	
        	<script src="/calendar/resources/js/login.js"></script>
	</body>	
</html>
