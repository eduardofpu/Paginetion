'use strict';

angular.module('mutrack')
  .controller('caixaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {

    //   Tras os campos dos apartamentos cadastrados



    $scope.c = {};
    $scope.cs = [];

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
      $scope.c = {};
    };

    // Manage CRUD operations.
    var cUrl =  SERVICE_PATH.PRIVATE_PATH + '/caixa';




    $scope.editCaixa = function(c) {
      $scope.c = angular.copy(c);
      $scope.show();
    };

    $scope.deleteCaixa = function(c) {
      RestSrv.delete(cUrl, c, function() {
        $scope.cs.splice($scope.cs.indexOf(c), 1);
        ngNotify.set('Ocorrencia \'' + c.valor + '\' deleted.', 'success');
      });
    };


    $scope.saveCaixa = function(c) {
      if (c.id ) {
        RestSrv.edit(cUrl, c, function() {
          for (var i = 0; i < $scope.cs.length; i++) {
            if ($scope.cs[i].id === c.id) { //=== verifica id e o objeto
              $scope.cs[i] = c;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Caixa \'' + c.valor + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(cUrl, c, function(newCaixa) {
          $scope.cs.push(newCaixa);
          $scope.hide();
          ngNotify.set('Caixa \'' + c.valor + '\' added.', 'success');
        });
      }
    };
    RestSrv.find(cUrl,function(data) {
      $scope.cs = data;
      ngNotify.set('Loaded cs with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
