
angular.module('mutrack')
  .controller('pesquisaMoradorCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

// Pesquisa funcionario


    $scope.m = {};
    $scope.ms = [];
    $scope.showM = false;

            ngNotify.config({
              theme: 'pastel'
            });




                // Show the form used to edit or add users.
                $scope.show = function() {
                  $scope.showM = true;
                };

                // Hide the form used to edit or add users.
                $scope.hide = function() {
                  $scope.showM = false;
                  $scope.m= {};
                };




    // Manage CRUD operations.
    var bucamUrl = SERVICE_PATH.PRIVATE_PATH + '/buscam';
  //var apartamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/apartamento';
    var ordenarApeMoradoresUrl = SERVICE_PATH.PRIVATE_PATH + '/morador/ordenarapemoradores';



// Busca a imagem pelo nome

$scope.buscaMorador = function(m) {

    RestSrv.findPesqFuncionario(bucamUrl, m, function(newF) {
        $scope.ms = newF;

          ngNotify.set('Morador: \'' + m.nome + '\' Encontrado.', 'success');


      });

};

//  Mostra a tabela no html

    RestSrv.find(ordenarApeMoradoresUrl, function(status, data) {
      $scope.ms = data;

       //$scope.fileuploadEdit =  $scope.ffs[0];
      ngNotify.set('Moradores  ms with success.', 'success');
    });




  });
