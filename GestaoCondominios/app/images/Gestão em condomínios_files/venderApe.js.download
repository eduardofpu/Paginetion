'use strict';

angular.module('mutrack')
  .controller('VenderApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.venderApe = {};
    $scope.venderApes = [];
    $scope.showAddVenderApe = false;

    // Show the form used to edit or add packagees.
    $scope.show = function() {
      $scope.showAddVenderApe= true;
    };

    // Hide the form used to edit or add packagees.
    $scope.hide = function() {
      $scope.showAddVenderApe = false;
      $scope.venderApe = {};
    };

    // Manage CRUD operations.
    var venderApeUrl = SERVICE_PATH.PRIVATE_PATH + '/venderApartamento';

    $scope.editVenderApe = function(venderApe) {
      $scope.venderApe = angular.copy(venderApe);
      $scope.show();
    };

    $scope.deleteVenderApe = function(venderApe) {
      RestSrv.delete(venderApeUrl,venderApe, function() {
        $scope.venderApes.splice($scope.venderApes.indexOf(venderApe), 1);
        ngNotify.set('VenderrApartamento \'' + venderApe.valor + '\' deleted.', 'success');
      });
    };

    $scope.saveVenderApe = function(venderApe) {
      if (venderApe.id) {
        RestSrv.edit(venderApeUrl, venderApe, function() {
          for (var i = 0; i < $scope.venderApes.length; i++) {
            if ($scope.venderApes[i].id === venderApe.id) {
              $scope.venderApes[i] = venderApe;
            }
          }

          $scope.hide();
          ngNotify.set('VenderApartamento \'' + venderApe.valor + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(venderApeUrl, venderApe, function(newVenderApe) {
          $scope.venderApes.push(newVenderApe);
          $scope.hide();
          ngNotify.set('VenderApartamento\'' + venderApe.valor + '\' added.', 'success');
        });
      }
    };

    // Request all data (packagees).
    RestSrv.find(venderApeUrl, function(data) {
      $scope.venderApes = data;
      ngNotify.set('Loaded venderApes with success.', 'success');
    });

  });
