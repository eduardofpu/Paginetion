'use strict';

angular.module('mutrack')
  .controller('fotoVendaApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {




//   Tras os campos dos apartamentos cadastrados


        $scope.ape = {};
        $scope.apes = [];

        var algUrl =  SERVICE_PATH.PRIVATE_PATH + '/venderApartamento';


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
    var vendaApeUrl =  SERVICE_PATH.PRIVATE_PATH + '/vendaApe';




        $scope.updateLinkImage = function(file){
            var arq = file.split(',');
            $scope.fotoApe.mimeType = arq[0];
            $scope.fotoApe.file = arq[1];
        };




    $scope.editFotoVendaApe  = function(fotoApe ) {
      $scope.fotoApe  = angular.copy(fotoApe );
      $scope.show();
    };

    $scope.deleteFotoVendaApe  = function(fotoApe ) {
      RestSrv.delete(vendaApeUrl, fotoApe , function() {
        $scope.fotoApes.splice($scope.fotoApes.indexOf(fotoApe), 1);
        ngNotify.set('Fotos \'' + fotoApe .comodo + '\' deleted.', 'success');
      });
    };


    $scope.saveFotoVendaApe  = function(fotoApe ) {
      if (fotoApe .id ) {
        RestSrv.edit(vendaApeUrl,fotoApe , function() {
          for (var i = 0; i < $scope.fotoApes.length; i++) {
            if ($scope.fotoApes[i].id === fotoApe.id) { //=== verifica id e o objeto
              $scope.fotoApes[i] = fotoApe;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Fotos \'' + fotoApe.comodo+ '\' updated.', 'success');
        });
      } else {
        RestSrv.add(vendaApeUrl, fotoApe , function(newVendaApe ) {
          $scope.fotoApes.push(newVendaApe);
          $scope.hide();
          ngNotify.set('Fotos \'' + fotoApe.comodo+ '\' added.', 'success');
        });
      }
    };
    RestSrv.find(vendaApeUrl,function(data) {
    $scope.fotoApes = data;
      ngNotify.set('Loaded fotoApes with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
