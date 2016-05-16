var app = angular.module("app", []).controller("home", function($scope, $http, $location) {
    var self = this;
    self.showSignUp = false;

    self.showAndHideSignUp = function() {
        self.showSignUp = !self.showSignUp
    };

    self.authenticate = function() {
        $http.get("/user").success(function(data) {
            if (data.id != null) {
                var firstName = data.firstName ?  data.firstName + " " : "";
                var lastName = data.lastName ? data.lastName : "";
                self.user = firstName + lastName
                self.authenticated = true;
            } else {
                self.user = "N/A";
                self.authenticated = false;
            }

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

    self.signup = function() {

        var json = JSON.stringify(self.signupObj);

        $http.post('/login/signup', json, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function(data) {
            self.authenticate();
        }).error(function(data) {
            console.log("Sign up failed");
            $location.path("/");
        });

    };

    self.authenticate();

});