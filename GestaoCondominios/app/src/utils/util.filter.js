'use strict';

angular.module('mutrack')
  .filter('formatPermission', function() {
    return function(input) {
      switch (input) {
        case 'ROLE_ADMIN':
          return 'Administrador';
        break;
        case 'ROLE_FUNCIONARIO':
          return 'Funcionario';
        break;

        case 'ROLE_MORADOR':
          return 'Morador';
        break;
        case 'ROLE_PROPRIETARIO':
          return 'Proprietário';
        break;

        case 'ROLE_VISITANTE':
          return 'Visitante';
        break;

        default:
          return 'Unknown';
        break;
      };


    };



  });
