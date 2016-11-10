'use strict';

angular.module('mutrack')  //  <script src="js/jquery.maskedinput.js"></script>

      .directive('placa',function() {
         return {
             restrict: 'A',
             link : function(scope, element, attrs) {

                  // $(element).mask("aaa-9999",{placeholder:" "});
              $(element).mask('aaa-9999');

                element.mask(attrs.placa);


               }
          };
 });
