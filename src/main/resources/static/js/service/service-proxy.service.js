angular.module('managementApp')
    .service('ServiceProxy', function ($http, $rootScope) {
        var restFactory = {};

        // Find all data.
        restFactory.get = function (url, callback) {
            requestSrv(url, 'GET', {}, callback);
        };

        restFactory.post = function (url, data, callback) {
            requestSrv(url, 'POST', data, callback);
        }

        function requestSrv(url, method, data, callback) {
            $rootScope.$emit('loading-started');

            $http({
                method: method,
                url: url,
                headers: { 'Content-Type': 'application/json' },
                data: data
            }).then(function (response) {
                callback && callback(response.data);
            }, function (error) {


            }).finally(function () {
                $rootScope.$emit('loading-complete');
            });
        }

        return restFactory;
    })
