'use strict';

angular.module('mutrack')
  .controller('relatorioCtrl', function($scope,$http,SERVICE_PATH) {

  var Url = SERVICE_PATH.PRIVATE_PATH + '/relatorio';

    $scope.geraRelatorio = function() {
      $http.get(Url,{responseType: 'arraybuffer'})
       .success(function (data) {
           var file = new Blob([data], {type: 'application/pdf'});
           var fileURL = URL.createObjectURL(file);
           window.open(fileURL);
         });
    };




});
