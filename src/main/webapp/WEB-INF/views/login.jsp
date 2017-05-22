<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 	<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet" type="text/css">
    
	<head>
        	<meta charset="UTF-8"/>
        	<title>calendar</title>
	</head>
    	
	<body ng-app="calendar">

        	<div id="container" ng-controller="loginCtrl">

				<div id="form">
					<form>
						<label for="username">username: </label>
						<input type="text" id="username" name="username" ng-model="username">
						<label for="mail">mail: </label>
						<input type="text" id="mail" name="mail" ng-model="mail">
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
							<tr ng-repeat="(key, value) in data">
								<td><span ng-bind="value.username"></span></td>
								<td><span ng-bind="value.mail"></span></td>
								<%--<td><input type="submit" value="delete" id="delete" ng-click="update(value.username)"></td>--%>
								<%--<td><input type="submit" value="update" id="update" ng-click="delete(value.username)"></td>--%>
							</tr>
						</tbody>
					</table>
				</div>

        	</div>

			<script src="<c:url value='/resources/js/login.js'/>"></script>
			<script src="<c:url value='/resources/js/service.js'/>"></script>
	</body>	
</html>
