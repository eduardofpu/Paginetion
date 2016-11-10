'use strict';

angular.module('mutrack')
  .controller('caixaEntradaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH , MensagensRedirect) {

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
      $scope.fields = [];
      $scope.statusError = {};
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;

    };

    // Manage CRUD operations.
    var cUrl =  SERVICE_PATH.PRIVATE_PATH + '/entradacaixa';

    $scope.editCaixa = function(c) {

      $scope.fields = [];
      $scope.statusError = {};
      $scope.c = angular.copy(c);
      $scope.show();
    };

    $scope.deleteCaixa = function(c) {
      RestSrv.delete(cUrl, c, function(status,data) {

        $scope.statusError = 'success';
        $scope.message = data.atributeMessage.MESSAGE;

        $scope.cs.splice($scope.cs.indexOf(c), 1);
        ngNotify.set('Valor \'' + c.valor + '\' deleted.', 'success');
      });
    };


    $scope.saveCaixa = function(c) {
      if (c.id ) {
        RestSrv.edit(cUrl, c, function(status,data) {

        if(status ==='ok'){

          for (var i = 0; i < $scope.cs.length; i++) {
            if ($scope.cs[i].id === c.id) { //=== verifica id e o objeto
              $scope.cs[i] = c;
            }
          }
          $scope.statusError = 'success';
          $scope.message = data.atributeMessage.MENSAGEM;

          $scope.hide();// para esconder o forme
          ngNotify.set('Caixa \'' + c.valor + '\' updated.', 'success');

        }else{
            $scope.statusError = 'unsuccess';
           $scope.messages = data.fieldsErrorMessages;
          $scope.fields = data.mapOfFields;
         }



        });


      } else {
        RestSrv.add(cUrl, c, function(status, data) {

          //  $scope.cs.push(newCaixa);

         if(status ==='ok'){
            $scope.cs.push(data.data);
            $scope.statusError = 'success';
             $scope.message = data.atributeMessage.MENSAGEM;

             $scope.hide();
             ngNotify.set('Caixa \'' + c.valor + '\' added.', 'success');


        }else{
               $scope.statusError = 'unsuccess';
               $scope.messages = data.fieldsErrorMessages;
              $scope.fields = data.mapOfFields;
               console.log(data);
            }



        });
      }
    };


    RestSrv.find(cUrl,function(status,data) {
      $scope.cs = data;
      ngNotify.set('Loaded cs with success.', 'success');

      $scope.c = MensagensRedirect.getMensagem();
      ngNotify.set($scope.c, 'error');
      MensagensRedirect.setMensagem('');


    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;




  }); // Fim










  });
