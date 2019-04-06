angular.module('managementApp')
    .filter('formatLabel', function (AngularUtils) {
        return function (ingrediente) {

            ingrediente = AngularUtils.toArray(ingrediente);

            var dados = {};
            for (var i = 0; i < ingrediente.length; i++) {
                var pk = ingrediente[i].codigo;

                var ing = dados[pk];
                if (dados[pk] == null) {
                    dados[pk] = {
                        qtd: 1,
                        label: ingrediente[i].nome
                    }
                } else {
                    ing.qtd++;
                }
            }

            var label = AngularUtils.newBuffer();
            AngularUtils.toArray(Object.values(dados)).forEach(e => {
                label.append(e.qtd);
                label.append(' - ');
                label.append(e.label);
                label.append('<br/>')
            });

            return label.toString();
        };
    })
    .filter('formatValor', function (AngularUtils) {
        return function (input) {
            return AngularUtils.formatNumber(input);
        };
    })
    .controller('produtosCtrl', ['ServiceProxy', 'ServicePathConstants', 'AngularUtils',
        function (ServiceProxy, ServicePathConstants, AngularUtils) {
            var self = this;

            var _lanche = [];

            self.lanches = [];
            self.complementos = [];
            self.showView = 0;

            self.addLanche = addLanche;
            self.voltarLanche = voltarLanche;
            self.gerarPedido = gerarPedido;

            init();
            function init() {
                ServiceProxy.get(ServicePathConstants.ROOT_PATH + '/lanches', function (data) {
                    _lanche = angular.copy(data);
                    self.lanches = data;
                })

                ServiceProxy.get(ServicePathConstants.ROOT_PATH + '/ingredientes', function (data) {
                    self.complementos = data;
                });
            }

            function addLanche(hamburguer) {
                self.showView = 1;
                lanche = hamburguer;
            }


            function voltarLanche() {
                self.showView = 0;
                self.lanches = angular.copy(_lanche);
            }

            function gerarPedido() {

                AngularUtils.toArray(self.complementos).forEach(e => {
                    while (e.qtd) {
                        AngularUtils.toArray(lanche.ingredientes).push(e);
                        e.qtd--;
                    }
                });

                ServiceProxy.post(ServicePathConstants.ROOT_PATH + '/lanches', lanche, function (data) {
                    self.lanche = data;
                    self.showView = 2;
                });

            }
        }]);