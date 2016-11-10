'use strict';

angular.module('mutrack')
  .controller('contaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {

    //   Tras os campos dos apartamentos cadastrados



    $scope.t = {};
    $scope.ts = [];

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
      $scope.t = {};
    };

    // Manage CRUD operations.
    var contaUrl =  SERVICE_PATH.PRIVATE_PATH + '/prestarConta';



    $scope.editPrestarConta = function(t) {
      $scope.t= angular.copy(t);
      $scope.show();
    };

    $scope.deletePrestarConta = function(t) {
      RestSrv.delete(contaUrl, t, function() {
        $scope.ts.splice($scope.ts.indexOf(t), 1);
        ngNotify.set('Valor da prestação \'' + t.valor + '\' deleted.', 'success');
      });
    };


    $scope.savePrestarConta = function(t) {
      if (t.id ) {
        RestSrv.edit(contaUrl, pc, function() {
          for (var i = 0; i < $scope.ts.length; i++) {
            if ($scope.ts[i].id === t.id) { //=== verifica id e o objeto
              $scope.ts[i] = t;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Valor da prestação \'' + t.valor + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(contaUrl, t, function(newPrestarConta) {
          $scope.ts.push(newPrestarConta);
          $scope.hide();
          ngNotify.set('Valor da prestação \'' + t.valor + '\' added.', 'success');
        });
      }
    };


    RestSrv.find(contaUrl,function(data) {
      $scope.ts = data;
      ngNotify.set('Loaded ts with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
