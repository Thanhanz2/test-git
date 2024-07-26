app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles = [];
	$scope.admins = [];
	$scope.authories = [];

	$scope.initialize = function() {

		$http.get("/rest/roles").then(resp => {
			$scope.roles = resp.data;
			console.log(resp.data);
		})

		$http.get("/rest/accounts?admin=true").then(resp => {
			$scope.admins = resp.data;
			console.log(resp.data);
		}).catch(error => {
			console.log(error);
		})


		$http.get("/rest/authorities?admin=true").then(resp => {
			$scope.authories = resp.data;
		})
			.catch(error => {
				$location.path("/unauthorized");
			});
	}
	$scope.authority_of = function(acc, role) {
		if ($scope.authories) {
			return $scope.authories.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
		}
	}
	$scope.authority_changed = function(acc, role) {
		var authority = $scope.authority_of(acc, role);
		if (authority) {
			$scope.revoke_authority(authority);
		} else {
			authority = {
				account: acc, role: role
			}
			$scope.grant_authority(authority);
		}
	}
	$scope.revoke_authority = function(authority) {
		$http.delete(`/rest/authorities/${authority.id}`).then(resp => {
			var index = $scope.authories.findIndex(a => a.id == authority.id);
			$scope.authories.splice(index, 1);
			alert("Success")
		}).catch(error => {
			alert("Erro");
			console.log(error);
		})
	}

	$scope.grant_authority = function(authority) {
		$http.post('/rest/authorities', authority).then(resp => {
			$scope.authories.push(resp.data);
			alert("cap nhap thanh cong!");
		}).catch(error => {
			alert("Erro");
			console.log(error);
		})
	}
	$scope.initialize();

});