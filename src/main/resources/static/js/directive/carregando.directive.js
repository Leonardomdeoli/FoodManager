angular.module('managementApp')
    .directive("dirCarregando", ['$rootScope',
        function ($rootScope) {
            return {
                template: '<div ng-show="showMe" class="progress-bar progress-bar-striped" style="width: 100%;height: 8px; position: absolute;"><div class="progress-bar" style="width: 100%"></div></div>',
                link: function (scope, element, attrs) {

                    $rootScope.$on('loading-started', function () {
                        scope.showMe = true;
                    });

                    $rootScope.$on('loading-complete', function () {
                        scope.showMe = false;
                    });
                }
            };
        }]);