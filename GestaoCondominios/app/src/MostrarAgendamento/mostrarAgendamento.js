'use strict';

angular.module('mutrack')
  .controller('AgCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.age = {};
    $scope.ages = [];

    $scope.showAddEditAgenda = false;

    // Show the form used to edit or add packagees.
    $scope.show = function() {
      $scope.showAddEditAgenda= true;
    };

    // Hide the form used to edit or add packagees.
    $scope.hide = function() {
      $scope.showAddEditAgenda = false;
      $scope.age = {};
    };


    // var mostrarAgendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarAgendamento';

   var mostrarAgendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/agendamento/mostrar'; //Mostra a tabela ordenada

      var bucarAgendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/entradaSaida';

    $scope.buscaEmpresa = function(age) {

        RestSrv.findPesqFuncionario(bucarAgendamentoUrl, age, function(newF) {
            $scope.ages = newF;

              ngNotify.set('Funcionário: \'' + age.empresa + '\' Encontrado.', 'success');


          });

    };

    //ag.hora = ag.horaObj.getHours() + ':' + ag.horaObj.getMinutes() ;

    $scope.saveAgendamento = function(age) {


      if (age.id) {
        RestSrv.edit(mostrarAgendamentoUrl, age, function(status, data) {
          for (var i = 0; i < $scope.ages.length; i++) {
            if ($scope.ages[i].id === age.id) {
              $scope.ages[i] = age;
            }
          }

          $scope.hide();
          ngNotify.set('MostrarAgendamento \'' + age.empresa + '\' updated.', 'Modular');
        });
      } else {
        RestSrv.add(mostrarAgendamentoUrl, age, function(status, data) {
          $scope.ages.push(data.data);
          $scope.hide();
          ngNotify.set('MostrarAgendamento\'' + age.empresa + '\' added.', 'Modular');
        });
      }
    };




              RestSrv.find(mostrarAgendamentoUrl,function(status, data) {
                $scope.ages = data;
                ngNotify.set('Encontrado ages with success.', 'success');
              });





            });
