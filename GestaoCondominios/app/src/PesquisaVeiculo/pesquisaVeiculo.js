
angular.module('mutrack')
  .controller('pesquisaVeiculoCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

// Pesquisa funcionario


    $scope.v = {};
    $scope.vs = [];
    $scope.showAp = false;

            ngNotify.config({
              theme: 'pastel'
            });




                // Show the form used to edit or add users.
                $scope.show = function() {
                  $scope.showV = true;
                };

                // Hide the form used to edit or add users.
                $scope.hide = function() {
                  $scope.showV = false;
                  $scope.v = {};
                };




    // Manage CRUD operations.
    var bucavUrl = SERVICE_PATH.PRIVATE_PATH + '/buscav';
    //var veiculoUrl = SERVICE_PATH.PRIVATE_PATH + '/veiculo';
    var ordenarVeiculosUrl = SERVICE_PATH.PRIVATE_PATH + '/veiculo/ordenarveiculos';




// Busca a imagem pelo nome

$scope.buscaVeiculo = function(v) {

    RestSrv.findPesqFuncionario(bucavUrl, v, function(newF) {
        $scope.vs = newF;

          ngNotify.set('Veiculo: \'' + v.placa + '\' Encontrado.', 'success');


      });

};

//  Mostra a tabela no html

    RestSrv.find(ordenarVeiculosUrl, function(status, data) {
      $scope.vs = data;

       //$scope.fileuploadEdit =  $scope.ffs[0];
      ngNotify.set('Pesquisa Veiculo  vs with success.', 'success');
    });




  });
