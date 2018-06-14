var app = angular.module('myApp', []);
app.controller('personCtrl', function($scope, $http) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.myVar = false;
    $scope.toggle1 = function() {
        $scope.myVar = !$scope.myVar;
    }
    $scope.request1 = function() {
        alert("here")
    }

    $scope.loadData = function(){
        var promise = $http({
            method:"get",
            url:"/user/list",
            cache: true
        }).success(function(data){
            alert("succeed")
        }).error(function(data){
            alert("error")
        })

        promise.then(function(data){
            $scope.myData = data.data;
        })
        /*promise.success(function(data){
            $scope.myData = data;
        })*/
    }
});