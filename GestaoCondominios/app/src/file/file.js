
angular.module('mutrack')
  .controller('FileCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

    $scope.fileupload = {};
    $scope.fileuploads = [];
    $scope.showAddEditformulario = false;
    $scope.showTable = false;

    ngNotify.config({
      theme: 'pastel'
    });


    // Show the form used to edit or add formularios.
    $scope.show = function() {
      $scope.showAddEditformulario = true;
    };

    $scope.showTable = function() {
      $scope.showTable = true;
    };

    // Hide the form used to edit or add formularios.
    $scope.hide = function() {
      $scope.showTable = false;
      $scope.fileupload = {};
    };
    $scope.hideTable = function() {
      $scope.showAddEditformulario = false;
      $scope.fileupload = {};
    };

    // Manage CRUD operations.
    var fileUrl = SERVICE_PATH.PRIVATE_PATH + '/upload';



    $scope.editFile = function(fileupload) {
      $scope.fileupload = angular.copy(fileupload);
      $scope.show();
    };

    $scope.deleteFile = function(fileupload) {
      RestSrv.delete(fileUrl, fileupload, function() {
        $scope.fileuploads.splice($scope.fileuploads.indexOf(fileupload), 1);
        ngNotify.set('Fileupload \'' + fileupload.name + '\' deleted.', 'success');
      });
    };


    $scope.updateLinkImageEdit = function(file){
        var arq = file.split(',');
        $scope.fileuploadEdit.mimeType = arq[0];
        $scope.fileuploadEdit.file = arq[1];
    };




    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.fileupload.mimeType = arq[0];
        $scope.fileupload.file = arq[1];
    };






    $scope.saveFile = function(fileupload) {
      if (fileupload.id) {
        RestSrv.edit(fileUrl, fileupload, function() {


          for (var i = 0; i < $scope.fileuploads.length; i++) {
            if ($scope.fileuploads[i].id === fileupload.id) { //=== verifica id e o objeto
              $scope.fileuploads[i] = fileupload;
            }
          }

          $scope.hide();// para esconder o forme
          ngNotify.set('Fileupload \'' + fileupload.name + '\' updated.', 'success');



        });


      } else {
        RestSrv.add(fileUrl, fileupload, function(newFile) {
          $scope.fileuploads.push(newFile);
          $scope.hide();
          ngNotify.set('Fileupload \'' + fileupload.name + '\' added.', 'success');



        });

      }
    };






    // Request all data (formularios).
    RestSrv.find(fileUrl, function(data) {
      $scope.fileuploads = data;

         console.log($scope.fileuploads);

       $scope.fileuploadEdit =  $scope.fileuploads[0];
      ngNotify.set('Loaded fileuploads with success.', 'success');
    });



  });
