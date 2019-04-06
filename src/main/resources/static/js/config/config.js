angular.module('managementApp')
    .config(function ($routeProvider, $locationProvider) {

        $locationProvider.hashPrefix('');

        $routeProvider
            .when('/', {
                templateUrl: './view/produtos.tpl.html',
                controller: 'produtosCtrl as  ctrl'
            });
    });