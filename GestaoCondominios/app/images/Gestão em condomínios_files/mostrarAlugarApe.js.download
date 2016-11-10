'use strict';

angular.module('mutrack')
  .controller('MostrarAlugarApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.mostrarApe = {};
    $scope.mostrarApes = [];


    var mostrarApeUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarAlugarApe';



              RestSrv.find(mostrarApeUrl,function(data) {
                $scope.mostrarApes = data;
                ngNotify.set('Loaded mostrarApes with success.', 'success');
              });


  });
