
angular.module('mutrack')
  .controller('pesquisaPrestadorServicoCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.p = {};
    $scope.ps = [];
    $scope.showAddEditformulario = false;

    ngNotify.config({
      theme: 'pastel'
    });

    // Manage CRUD operations.
    var pUrl = SERVICE_PATH.PRIVATE_PATH + '/pmap';

       $scope.msg=('Nome das Imagens: ');


    // Busca a imagem pelo nome

    $scope.buscaPrestador = function(p) {
      RestSrv.findPesqPrestador(pUrl, p, function(newP) {
          $scope.ps = newP;
        });
    };







  });
