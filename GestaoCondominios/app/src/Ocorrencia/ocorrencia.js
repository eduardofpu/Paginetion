'use strict';

angular.module('mutrack')
  .controller('ocorrenciaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {

    //   Tras os campos dos apartamentos cadastrados



    $scope.o = {};
    $scope.os = [];

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
      $scope.o = {};
    };

    // Manage CRUD operations.
    var oUrl =  SERVICE_PATH.PRIVATE_PATH + '/ocorrencia';




    $scope.editOcorrencia = function(o) {
      $scope.o = angular.copy(o);
      $scope.show();
    };

    $scope.deleteOcorrencia = function(o) {
      RestSrv.delete(oUrl, o, function(status, data) {
        $scope.os.splice($scope.os.indexOf(o), 1);
        ngNotify.set('Morador \'' + o.registro + '\' deleted.', 'success');
      });
    };


    $scope.saveOcorrencia = function(o) {
      if (o.id ) {
        RestSrv.edit(oUrl, o, function(status, data) {
          for (var i = 0; i < $scope.os.length; i++) {
            if ($scope.os[i].id === o.id) { //=== verifica id e o objeto
              $scope.os[i] = o;
            }
          }
          $scope.hide();// para esconder o forme
          ngNotify.set('Ocorrencia \'' + o.registro + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(oUrl, o, function(status, data) {
          $scope.os.push(data.data);
          $scope.hide();
          ngNotify.set('Ocorrencia \'' + o.registro + '\' added.', 'success');
        });
      }
    };
    RestSrv.find(oUrl,function(status, data) {
      $scope.os = data;
      ngNotify.set('Loaded os with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(status,data) {


         $scope.permissions = data;


  }); // Fim










  });
