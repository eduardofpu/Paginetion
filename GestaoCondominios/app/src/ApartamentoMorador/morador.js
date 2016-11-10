'use strict';

angular.module('mutrack')
  .controller('moradorCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH , MensagensRedirect) {

    //   Tras os campos dos apartamentos cadastrados


          $scope.ap = {};
          $scope.aps = [];
         //   Tras os campos dos apartamentos cadastrados
          //  var apUrl =  SERVICE_PATH.PRIVATE_PATH + '/apartamento/ordenarapartamentos';
            var apUrl =  SERVICE_PATH.PRIVATE_PATH + '/apartamento/ordenarapartamentos';

          //Tras os campos apartamentos cadastrados ordenados


          RestSrv.find(apUrl,function(status,data) {
            $scope.aps = data;
            ngNotify.set('Loaded aps with success.', 'success');

            $scope.ap = MensagensRedirect.getMensagem();
            ngNotify.set($scope.ap, 'error');
            MensagensRedirect.setMensagem('');
          });



    $scope.m = {};
    $scope.ms = [];

    $scope.permissao = {};
    $scope.showAddEditUser = false;


    ngNotify.config({
      theme: 'pastel'
    });



    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
      $scope.fields = [];
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.m = {};
    };

    // Manage CRUD operations.
      var mUrl =  SERVICE_PATH.PRIVATE_PATH + '/morador';
      var  mOUrl = SERVICE_PATH.PRIVATE_PATH + '/morador/ordenarapemoradores';



    $scope.editMorador = function(m) {
      $scope.fields = [];
      $scope.statusError = {};
      $scope.m = angular.copy(m);
      $scope.show();
    };

    $scope.deleteMorador = function(m) {
      $scope.statusError = 'success';
      $scope.message = data.atributeMessage.MESSAGE;

      RestSrv.delete(mUrl, m, function(status,data) {
        $scope.ms.splice($scope.ms.indexOf(m), 1);
        ngNotify.set('Morador \'' + m.nome + '\' deleted.', 'success');
      });
    };


    $scope.saveMorador = function(m) {

      if (m.id ) {

        RestSrv.edit(mUrl, m, function(status,data) {

          if(status ==='ok'){

          for (var i = 0; i < $scope.ms.length; i++) {
            if ($scope.ms[i].id === m.id) { //=== verifica id e o objeto
              $scope.ms[i] = m;
            }
          }
          $scope.statusError = 'success';
          $scope.message = data.atributeMessage.MENSAGEM;

          $scope.hide();// para esconder o forme
          ngNotify.set('Morador \'' + m.nome + '\' updated.', 'success');

        } else {

            $scope.statusError = 'unsuccess';
            $scope.messages = data.fieldsErrorMessages;
            $scope.fields = data.mapOfFields;

          }


        });


      } else {


        RestSrv.add(mUrl, m, function(status,data) {
          if(status ==='ok'){

          $scope.ms.push(data.data);
          $scope.statusError = 'success';
           $scope.message = data.atributeMessage.MENSAGEM;
          $scope.hide();
          ngNotify.set('Morador \'' + m.nome + '\' added.', 'success');

           }else{
                  $scope.statusError = 'unsuccess';
                  $scope.messages = data.fieldsErrorMessages;
                 $scope.fields = data.mapOfFields;
                  console.log(data);
               }

        });
      }
    };


    RestSrv.find(mOUrl,function(status,data) {
      $scope.ms = data;
      ngNotify.set('Loaded ms with success.', 'success');

      $scope.m = MensagensRedirect.getMensagem();
      ngNotify.set($scope.m, 'error');
      MensagensRedirect.setMensagem('');


    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

     RestSrv.find(permissionUrl, function(data) {


         $scope.permissions = data;


  }); // Fim










  });
