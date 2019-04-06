angular.module('managementApp')
  .factory('AngularUtils', [
    function () {

      var service = {
        getNumberOrZero: getNumberOrZero,
        formatNumber: formatNumber,
        newBuffer: newBuffer,
        toArray: toArray
      };

      function toArray(arr) {
        if (angular.isUndefined(arr)) {
          return [];
        } else if (angular.isArray(arr)) {
          return arr;
        } else if (angular.isString(arr)) {
          return arr.split(',');
        } else {
          return [arr];
        }
      }

      function newBuffer() {
        var value = [];
        return {
          append: function (data) {
            value.push(data);
            return this;
          },
          toString: function () {
            return value.join('');
          },
          length: function () {
            return value.join('').length;
          },
          clear: function () {
            value = [];
            return this;
          }
        };
      };


      function formatNumber(value, precision) {
        var mask = '0,0';

        if (precision == undefined) {
          precision = 2;
        }

        mask += '.';

        for (var i = 0; i < precision; i++) {
          mask += '0';
        }

        return numeral(value).format(mask);
      };

      function getNumberOrZero(value) {
        value = Number(value);

        if (isNaN(value)) {
          return Number(0);
        }

        return value;
      };

      return service;
    }]);

