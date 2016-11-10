'use strict';

angular.module('mutrack')
  .controller('MostrarFotoVendaApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {





    $scope.mostrarFoto = {};
    $scope.mostrarFotos = [];





    var vUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarFotoApeVenda';


    $scope.updateLinkImage = function(file){
            var arq = file.split(',');
            $scope.mostrarFoto.mimeType = arq[0];
            $scope.mostrarFoto.file = arq[1];
        };


        $scope.MosrarFotoApe  = function(fotoApe ) {
          $scope.fotoApe   = angular.copy(fotoApe  );
          $scope.show();
        };







    RestSrv.find(vUrl,function(data) {
      $scope.mostrarFotos = data;
      ngNotify.set('Loaded mostrarFotos with success.', 'success');

   });


      var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

        RestSrv.find(permissionUrl, function(data) {


            $scope.permissions = data;


     }); // Fim





});
