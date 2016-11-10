
angular.module('mutrack')
  .controller('pesquisaFuncionarioCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

// Pesquisa funcionario


    $scope.ff = {};
    $scope.ffs = [];
    $scope.showF = false;

            ngNotify.config({
              theme: 'pastel'
            });




                // Show the form used to edit or add users.
                $scope.show = function() {
                  $scope.showF = true;
                };

                // Hide the form used to edit or add users.
                $scope.hide = function() {
                  $scope.showF = false;
                  $scope.ff = {};
                };




    // Manage CRUD operations.
    var pesquisaUrl = SERVICE_PATH.PRIVATE_PATH + '/fmap';
    var funcionarioUrl = SERVICE_PATH.PRIVATE_PATH + '/funcionario';

       $scope.msg=('Nome das Imagens: ');




$scope.editFile = function(ff) {
  $scope.ff = angular.copy(ff);
  $scope.show();
};

$scope.deleteFile = function(ff) {
  RestSrv.delete(funcionarioUrl, ff, function(status, data) {
    $scope.ffs.splice($scope.ffs.indexOf(f), 1);
    ngNotify.set('Funcionario \'' + ff.funcionario + '\' deleted.', 'success');
  });
};


$scope.updateLinkImageEdit = function(ff){
    var arq = ff.split(',');
    $scope.fileuploadEdit.mimeType = arq[0];
    $scope.fileuploadEdit.file = arq[1];
};




$scope.updateLinkImage = function(ff){
    var arq = ff.split(',');
    $scope.ff.mimeType = arq[0];
    $scope.ff.file = arq[1];
};



// Busca a imagem pelo nome

$scope.buscaFuncionario = function(ff) {

    RestSrv.findPesqFuncionario(pesquisaUrl, ff, function(newF) {
        $scope.ffs = newF;

          ngNotify.set('Funcionário: \'' + ff.funcionario + '\' Encontrado.', 'success');


      });

};


// Fim Pesquisa Funcionario



$scope.salvarFuncionario = function(ff) {
  if (ff.id) {
    RestSrv.edit(funcionarioUrl, ff, function(status, data) {
      for (var i = 0; i < $scope.ffs.length; i++) {
        if ($scope.ffs[i].id === ff.id) { //=== verifica id e o objeto
          $scope.ffs[i] = ff;
        }


      }

      $scope.hide();// para esconder o forme
      ngNotify.set('Funcionario\'' + ff.funcionario + '\' updated.', 'success');



    });


  } else {
    RestSrv.add(funcionarioUrl, ff, function(status, data) {
      $scope.fs.push(data.data);
      $scope.hide();
      ngNotify.set('Funcionario \'' + ff.funcionario + '\' added.', 'success');


});



}
};



//  Mostra a tabela no html

    RestSrv.find(funcionarioUrl, function(status, data) {
      $scope.ffs = data;

       //$scope.fileuploadEdit =  $scope.ffs[0];
      ngNotify.set('Pesquisa Funcionario com  ffs with success.', 'success');
    });




  });
