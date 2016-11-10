'use strict';

angular.module('mutrack')
  .controller('MostrarVendaApeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.mostrarVendaApe = {};
    $scope.mostrarVendaApes = [];


    var mostrarVendaApeUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarApeAVenda';



              RestSrv.find(mostrarVendaApeUrl,function(data) {
                $scope.mostrarVendaApes = data;
                ngNotify.set('Loaded mostrarVendaApes with success.', 'success');
              });


  });
