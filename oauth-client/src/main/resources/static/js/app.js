var app = angular.module("app", []).controller("home", function($scope, $http, $location) {
    var self = this;

    self.authenticate = function() {
        $http.get("/user").success(function(data) {
            if (data.userAuthentication) {
                self.user = data.userAuthentication.details.name;
            } else if (data.name) {
                self.user = data.name;
            } else {
                return;
            }
            self.authenticated = true;
        }).error(function() {
            self.user = "N/A";
            self.authenticated = false;
        });
    };

    self.logout = function() {
        $http.post('/logout', {}).success(function(data) {
            self.authenticated = false;
            $location.path("/");
        }).error(function(data) {
            console.log("Logout failed");
            self.authenticated = true;
        });
    };

    self.login = function() {
        $http.post('/login/process-login', $.param($scope.credentials), {
            headers : {
                "content-type" : "application/x-www-form-urlencoded"
            }
        }).success(function(data) {
        self.authenticate();
        }).error(function(data) {
            console.log("Login failed");
            $location.path("/");
        });

    };

    self.authenticate();

});