'use strict';

angular.module('mutrack')
  .controller('AluguelCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.aluguel = {};
    $scope.aluguels = [];

    $scope.showModelo = false;


            ngNotify.config({
              theme: 'pastel'
            });




                // Show the form used to edit or add users.
                $scope.show1 = function() {
                  $scope.showModelo = true;

                };

                // Hide the form used to edit or add users.
                $scope.hide1 = function() {
                  $scope.showModelo = false;

                  $scope.aluguel = {};
                };




    var Url = SERVICE_PATH.PRIVATE_PATH + '/bg';
    var pUrl = SERVICE_PATH.PRIVATE_PATH + '/bgp';
    var aluguelUrl = SERVICE_PATH.PRIVATE_PATH + '/alugarGaragem/findall';




    $scope.buscar = function(aluguel){
             RestSrv.findPesqFuncionario(Url,aluguel,function(status,data){


                 $scope.aluguels = data.data ;
                   ngNotify.set('Modelo: \'' + aluguel.modelo + '\' Encontrada.', 'success');

                  
             });






    };

    $scope.buscarPlaca = function(aluguel){
             RestSrv.findPesqFuncionario(pUrl,aluguel,function(status,data){

                 $scope.aluguels = data.data ;
                   ngNotify.set('Placa: \'' + aluguel.placa + '\' Encontrada.', 'success');

             });



    };



              RestSrv.find(aluguelUrl,function(status, data) {
                $scope.aluguels = data;
                ngNotify.set('Loaded aluguels with success.', 'success');
              });


  });
