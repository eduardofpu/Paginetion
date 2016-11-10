
    'use strict';

    angular.module('mutrack').controller('editUserCtrl', function ($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {



        var userUrl = SERVICE_PATH.PRIVATE_PATH + '/edituser';


      $scope.user = {};
      $scope.users = [];
      $scope.permissions= {};
      $scope.showAddEditUser = false;


      ngNotify.config({
        theme: 'pastel'
      });

      $scope.msg = 'Para Editar insira os novos dados!'


      // Show the form used to edit or add users.
      $scope.show = function() {
        $scope.showAddEditUser = true;
      };

      // Hide the form used to edit or add users.
      $scope.hide = function() {
        $scope.showAddEditUser = false;
        $scope.user = {};
      };


      $scope.updateLinkImageEdit = function(file){
          var arq = file.split(',');
          $scope.userEdit.mimeType = arq[0];
          $scope.userEdit.file = arq[1];
      };




      $scope.updateLinkImage = function(file){
          var arq = file.split(',');
          $scope.user.mimeType = arq[0];
          $scope.user.file = arq[1];
      };


      $scope.editarUser = function(user) {

        if ( user.id) {

          RestSrv.edit(userUrl, user, function() {


            for (var i = 0; i < $scope.users.length; i++) {
              if ($scope.users[i].id === user.id) { //=== verifica id e o objeto
                $scope.users[i] = user;

              }
            }

            ngNotify.set('User \'' + user.name + '\' updated.', 'success');

          });


        }

      };

      // Busca os dados do usuário que esta logado
      RestSrv.find(userUrl, function(data) {

         $scope.users = data;
         console.log($scope.authDetails);  // Apertar F12 na pagina para mostrar os dados dos usuário logado
         $scope.userEdit =  $scope.users[0];



      });

      // Request all data (permission and user).
      var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';
      RestSrv.find(permissionUrl, function(data) {
        $scope.permissions = data;

      });







      });
