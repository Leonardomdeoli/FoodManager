angular.module('managementApp')
    .directive('numericStepper', [
        function () {
            return {
                scope: {
                    size: '=size',
                    value: '=value',
                },
                templateUrl: './js/directive/numeric-stepper/numeric-input.tpl.html',
                controller: 'numericStepperController',
            };
        }])
    .controller('numericStepperController', ['$scope', '$attrs','AngularUtils',
        function ($scope, $attrs, AngularUtils) {

            $scope.incValue = incValue;
            $scope.decValue = decValue;
            $scope.blurHandler = blurHandler;

            init();
            function init() {
                validMinMaxValues();
            }

            function incValue() {
                if ($scope.value) {
                    $scope.value = Number($scope.value) + 1;
                } else {
                    $scope.value = 1;
                }

                validMaxValue();
            }

            function decValue() {
                if ($scope.value) {
                    $scope.value = Number($scope.value) - 1;
                } else {
                    $scope.value = 0;
                }

                validMinValue();
            }

            function validMinMaxValues() {
                validMinValue();
                validMaxValue();
            }

            function validMinValue() {
                if (!$attrs.minValue) {
                    return;
                }

                var minValue = Number($attrs.minValue);
                var value = AngularUtils.getNumberOrZero($scope.value);

                if (minValue && value < minValue) {
                    value = minValue;
                }

                if ($scope.value !== value) {
                    $scope.value = value;
                }
            }

            function validMaxValue() {
                if (!$attrs.maxValue) {
                    return;
                }

                var maxValue = Number($attrs.maxValue);
                var value = $scope.value;

                if (maxValue && value > maxValue) {
                    value = maxValue;
                }

                if ($scope.value !== value) {
                    $scope.value = value;
                }
            }

            function blurHandler() {
                validMinMaxValues();
            }
        }]);