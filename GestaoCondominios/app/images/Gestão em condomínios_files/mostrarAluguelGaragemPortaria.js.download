'use strict';

angular.module('mutrack')
  .controller('AluguelCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.aluguel = {};
    $scope.alugueis = [];


    var aluguelUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarAluguelGaragem';



              RestSrv.find(aluguelUrl,function(data) {
                $scope.alugueis = data;
                ngNotify.set('Loaded alugueis with success.', 'success');
              });


  });
