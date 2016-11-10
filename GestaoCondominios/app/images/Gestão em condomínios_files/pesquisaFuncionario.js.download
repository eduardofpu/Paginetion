
angular.module('mutrack')
  .controller('pesquisaFuncionarioCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.f = {};
    $scope.fs = [];
  

    ngNotify.config({
      theme: 'pastel'
    });



    // Manage CRUD operations.
    var fUrl = SERVICE_PATH.PRIVATE_PATH + '/fmap';

       $scope.msg=('Nome das Imagens: ');


    // Busca a imagem pelo nome

    $scope.buscaFuncionario = function(f) {
      RestSrv.findPesqFuncionario(fUrl, f, function(newF) {
          $scope.fs = newF;
        });
    };







  });
