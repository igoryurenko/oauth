var app = angular.module("app", []).controller("home", function($http, $location) {
    var self = this;
    $http.get("/user").success(function(data) {
        self.user = data.userAuthentication.details.name;
        self.authenticated = true;
    }).error(function() {
        self.user = "N/A";
        self.authenticated = false;
    });

    self.logout = function() {
        $http.post('/logout', {}).success(function(data) {
            self.authenticated = false;
            $location.path("/");
        }).error(function(data) {
            console.log("Logout failed");
            self.authenticated = true;
        });
    };

});