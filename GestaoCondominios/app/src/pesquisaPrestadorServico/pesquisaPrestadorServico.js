
angular.module('mutrack')
  .controller('pesquisaPrestadorServicoCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.p = {};
    $scope.ps = [];
    $scope.showAddEditformulario = false;

    ngNotify.config({
      theme: 'pastel'
    });



        // Show the form used to edit or add users.
        $scope.show = function() {
          $scope.showAddEditformulario = true;
        };

        // Hide the form used to edit or add users.
        $scope.hide = function() {
          $scope.showAddEditformulario = false;
          $scope.p = {};
        };



    // Metodo para buscar os prestadores
    var pUrl = SERVICE_PATH.PRIVATE_PATH + '/pmap';

    var prestadorUrl = SERVICE_PATH.PRIVATE_PATH + '/prestadorservico';

       $scope.msg=('Nome das Imagens: ');


    // Busca a imagem pelo nome

    $scope.buscaPrestador = function(p) {
      RestSrv.findPesqPrestador(pUrl, p, function(newP) {
          $scope.ps = newP;

           ngNotify.set('Prestador: \'' + p.prestador + '\' Encontrado.', 'success');

        });
    };



    $scope.editFile = function(p) {
      $scope.p = angular.copy(p);
      $scope.show();
    };

    $scope.deleteFile = function(p) {
      RestSrv.delete(prestadorUrl, p, function(status, data) {
        $scope.ps.splice($scope.ps.indexOf(p), 1);
        ngNotify.set('Prestador\'' + p.prestador+ '\' deleted.', 'success');
      });
    };


    $scope.updateLinkImageEdit = function(p){
        var arq = p.split(',');
        $scope.fileuploadEdit.mimeType = arq[0];
        $scope.fileuploadEdit.file = arq[1];
    };




    $scope.updateLinkImage = function(file){
        var arq = p.split(',');
        $scope.fileupload.mimeType = arq[0];
        $scope.fileupload.file = arq[1];
    };






    $scope.editarPrestador = function(p) {
      if (p.id) {
        RestSrv.edit(prestadorUrl, p, function(status, data) {


          for (var i = 0; i < $scope.ps.length; i++) {
            if ($scope.ps[i].id === p.id) { //=== verifica id e o objeto
              $scope.ps[i] = p;
            }
          }

          $scope.hide();// para esconder o forme
          ngNotify.set('Prestador \'' + p.prestador + '\' updated.', 'success');



        });


      } else {
        RestSrv.add(prestadorUrl, p, function(status, data) {
          $scope.ps.push(data.data);
          $scope.hide();
          ngNotify.set('Prestador \'' + p.prestador + '\' added.', 'success');



        });

      }
    };








        // Request all data (formularios).
        RestSrv.find(prestadorUrl, function(status, data) {
          $scope.ps = data;

          ngNotify.set('Loaded ps with success.', 'success');
        });







  });
