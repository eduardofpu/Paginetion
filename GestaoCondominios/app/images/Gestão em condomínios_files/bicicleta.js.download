'use strict';

angular.module('mutrack')
  .controller('bicicletaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {

    //   Tras os campos dos apartamentos cadastrados


          $scope.ap_b = {};
          $scope.aps = [];

          var apUrl =  SERVICE_PATH.PRIVATE_PATH + '/apartamento';


          RestSrv.find(apUrl,function(data) {
            $scope.aps = data;
            ngNotify.set('Loaded aps with success.', 'success');
          });



    $scope.b = {};
    $scope.bs = [];

    $scope.permissao = {};
    $scope.showAddEditUser = false;


    ngNotify.config({
      theme: 'pastel'
    });



    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.v = {};
    };

    // Manage CRUD operations.
    var bUrl =  SERVICE_PATH.PRIVATE_PATH + '/bicicleta';




    $scope.editBicicleta = function(b) {
      $scope.b = angular.copy(b);
      $scope.show();
    };

    $scope.deleteBicicleta = function(b) {
      RestSrv.delete(bUrl, b, function() {
        $scope.bs.splice($scope.bs.indexOf(b), 1);
        ngNotify.set('Bicicleta \'' + b.modelo + '\' deleted.', 'success');
      });
    };


    $scope.saveBicicleta = function(b) {
      if (b.id ) {
        RestSrv.edit(bUrl,b, function() {
          for (var i = 0; i < $scope.bs.length; i++) {
            if ($scope.bs[i].id === b.id) { //=== verifica id e o objeto
              $scope.bs[i] = b;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Bicicleta \'' + b.modelo+ '\' updated.', 'success');
        });
      } else {
        RestSrv.add(bUrl, b, function(newBicicleta) {
          $scope.bs.push(newBicicleta);
          $scope.hide();
          ngNotify.set('Bicicleta \'' + b.modelo+ '\' added.', 'success');
        });
      }
    };
    RestSrv.find(bUrl,function(data) {
    $scope.bs = data;
      ngNotify.set('Loaded bs with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
