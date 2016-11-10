'use strict';

angular.module('mutrack')
  .controller('fotoApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {




//   Tras os campos dos apartamentos cadastrados


        $scope.ape = {};
        $scope.apes = [];

        var algUrl =  SERVICE_PATH.PRIVATE_PATH + '/alugarApartamento';


        RestSrv.find(algUrl,function(data) {
          $scope.apes = data;
          ngNotify.set('Loaded apes with success.', 'success');
        });






    $scope.fotoApe = {};
    $scope.fotoApes = [];

    $scope.permissao = {};
    $scope.showAddFotoApe = false;


    ngNotify.config({
      theme: 'pastel'
    });



    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddFotoApe= true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddFotoApe = false;
      $scope.fotoApe = {};
    };

    // Manage CRUD operations.
    var fotoApeUrl =  SERVICE_PATH.PRIVATE_PATH + '/fotosAlugarApe';




        $scope.updateLinkImage = function(file){
            var arq = file.split(',');
            $scope.fotoApe.mimeType = arq[0];
            $scope.fotoApe.file = arq[1];
        };




    $scope.editFotoApe  = function(fotoApe ) {
      $scope.fotoApe  = angular.copy(fotoApe );
      $scope.show();
    };

    $scope.deleteFotoApe  = function(fotoApe ) {
      RestSrv.delete(fotoApeUrl, fotoApe , function() {
        $scope.fotoApes.splice($scope.fotoApes.indexOf(fotoApe), 1);
        ngNotify.set('Fotos \'' + fotoApe .comodo + '\' deleted.', 'success');
      });
    };


    $scope.saveFotoApe  = function(fotoApe ) {
      if (fotoApe .id ) {
        RestSrv.edit(fotoApeUrl,fotoApe , function() {
          for (var i = 0; i < $scope.fotoApes.length; i++) {
            if ($scope.fotoApes[i].id === fotoApe.id) { //=== verifica id e o objeto
              $scope.fotoApes[i] = fotoApe;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Fotos \'' + fotoApe.comodo+ '\' updated.', 'success');
        });
      } else {
        RestSrv.add(fotoApeUrl, fotoApe , function(newFotoApe ) {
          $scope.fotoApes.push(newFotoApe );
          $scope.hide();
          ngNotify.set('Fotos \'' + fotoApe.comodo+ '\' added.', 'success');
        });
      }
    };
    RestSrv.find(fotoApeUrl,function(data) {
    $scope.fotoApes = data;
      ngNotify.set('Loaded fotoApes with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
