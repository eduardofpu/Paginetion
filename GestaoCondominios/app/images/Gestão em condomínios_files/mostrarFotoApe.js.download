'use strict';

angular.module('mutrack')
  .controller('MostrarFotoApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {





    $scope.mostrarFoto = {};
    $scope.mostrarFotos = [];





    var mUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarFotoApeAlugar';


    $scope.updateLinkImage = function(file){
            var arq = file.split(',');
            $scope.mostrarFoto.mimeType = arq[0];
            $scope.mostrarFoto.file = arq[1];
        };


        $scope.MosrarFotoApe  = function(fotoApe ) {
          $scope.fotoApe   = angular.copy(fotoApe  );
          $scope.show();
        };







    RestSrv.find(mUrl,function(data) {
      $scope.mostrarFotos = data;
      ngNotify.set('Loaded mostrarFotos with success.', 'success');

   });


      var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

        RestSrv.find(permissionUrl, function(data) {


            $scope.permissions = data;


     }); // Fim





});
