
angular.module('mutrack')
  .controller('pesquisaProprietarioCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

// Pesquisa funcionario


    $scope.ap = {};
    $scope.aps = [];
    $scope.showAp = false;

            ngNotify.config({
              theme: 'pastel'
            });




                // Show the form used to edit or add users.
                $scope.show = function() {
                  $scope.showAp = true;
                };

                // Hide the form used to edit or add users.
                $scope.hide = function() {
                  $scope.showAp = false;
                  $scope.ap = {};
                };




    // Manage CRUD operations.
    var bucapUrl = SERVICE_PATH.PRIVATE_PATH + '/buscap';
  //var apartamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/apartamento';
    var ordenarApeUrl = SERVICE_PATH.PRIVATE_PATH + '/apartamento/ordenarapartamentos';



// Busca a imagem pelo nome

$scope.buscaApartamento = function(ap) {

    RestSrv.findPesqFuncionario(bucapUrl, ap, function(newF) {
        $scope.aps = newF;

          ngNotify.set('Apartamento: \'' + ap.descricao + '\' Encontrado.', 'success');


      });

};

//  Mostra a tabela no html

    RestSrv.find(ordenarApeUrl, function(status, data) {
      $scope.aps = data;

       //$scope.fileuploadEdit =  $scope.ffs[0];
      ngNotify.set('Pesquisa Apartamento  aps with success.', 'success');
    });




  });
