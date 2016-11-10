'use strict';

var BASE_URL = 'http://localhost:8080/api';

angular.module('mutrack',[

  'checklist-model',
  'ngNotify',
  'ngRoute',
  'ngCookies',
  'ngStorage',
  'colorpicker.module',
  'angularUtils.directives.dirPagination'


   ])

    .constant('SERVICE_PATH', {
      'ROOT_PATH': BASE_URL,
      'PUBLIC_PATH': BASE_URL + '/public',
      'PRIVATE_PATH': BASE_URL + '/private'
    })
  .config(function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'src/home/home.html',
        controller: 'HomeCtrl'
      })
      .when('/login', {
        templateUrl: 'src/login/login.html',
        controller: 'LoginCtrl'
      })

      .when('/user', {
        templateUrl: 'src/user/user.html',
        controller: 'UserCtrl'
      })
      .when('/userTable', {
        templateUrl: 'src/userTable/usertable.html',
        controller: 'UserTableCtrl'
      })
      .when('/editUser', {
          templateUrl: 'src/editUser/editUser.html',
          controller: 'editUserCtrl'
        })

      .when('/Funcionario', {
      templateUrl: 'src/Funcionario/funcionario.html',
      controller: 'funcionarioCtrl'
    })

    .when('/PrestadorServico', {
    templateUrl: 'src/PrestadorServico/prestadorservico.html',
    controller: 'prestadorservicoCtrl'
  })

    .when('/pesquisaFuncionario', {
      templateUrl: 'src/pesquisaFuncionario/pesquisaFuncionario.html',
      controller: 'pesquisaFuncionarioCtrl'
    })


    .when('/pesquisaPrestadorServico', {
      templateUrl: 'src/pesquisaPrestadorServico/pesquisaPrestadorServico.html',
      controller: 'pesquisaPrestadorServicoCtrl'
    })

    .when('/PesquisaProprietario', {
      templateUrl: 'src/PesquisaProprietario/PesquisaProprietario.html',
      controller: 'pesquisaProprietarioCtrl'
    })

    .when('/PesquisaMorador', {
      templateUrl: 'src/PesquisaMorador/PesquisaMorador.html',
      controller: 'pesquisaMoradorCtrl'
    })

    .when('/PesquisaVeiculo', {
      templateUrl: 'src/PesquisaVeiculo/pesquisaVeiculo.html',
      controller: 'pesquisaVeiculoCtrl'
    })


    .when('/Cadastro', {
      templateUrl: 'src/Cadastro/cadastro.html',
      controller: 'cadastroCtrl'
    })

    .when('/Apartamento', {
      templateUrl: 'src/Apartamento/apartamento.html',
      controller: 'apCtrl'
    })

    .when('/ApartamentoMorador', {
      templateUrl: 'src/ApartamentoMorador/morador.html',
      controller: 'moradorCtrl'
    })

    .when('/Veiculo', {
      templateUrl: 'src/Veiculo/veiculo.html',
      controller: 'veiculoCtrl'
    })

    .when('/Bicicleta', {
      templateUrl: 'src/Bicicleta/bicicleta.html',
      controller: 'bicicletaCtrl'
    })

    .when('/Ocorrencia', {
      templateUrl: 'src/Ocorrencia/ocorrencia.html',
      controller: 'ocorrenciaCtrl'
    })

    .when('/Caixa', {
      templateUrl: 'src/Caixa/caixa.html',
      controller: 'caixaCtrl'
    })

    .when('/Conta', {
      templateUrl: 'src/Conta/conta.html',
      controller: 'contaCtrl'
    })

    .when('/AluguelGaragem', {
      templateUrl: 'src/AluguelGaragem/aluguelGaragem.html',
      controller: 'AluguelGaragemCtrl'
    })


    .when('/MostrarAluguelGaragemPortaria', {
      templateUrl: 'src/MostrarAluguelGaragemPortaria/mostrarAluguelGaragemPortaria.html',
      controller: 'AluguelCtrl'
    })


    .when('/Agendamento', {
      templateUrl: 'src/Agendamento/agendamento.html',
      controller: 'AgendaCtrl'
    })


    .when('/MostrarAgendamento', {
      templateUrl: 'src/MostrarAgendamento/mostrarAgendamento.html',
      controller: 'AgCtrl'
    })
    .when('/MostrarAgendamentoEntrada', {
      templateUrl: 'src/MostrarAgendamentoEntrada/mostrarAgendamentoEntrada.html',
      controller: 'AgEntradaCtrl'
    })

    .when('/MostrarAgendamentoSaida', {
      templateUrl: 'src/MostrarAgendamentoSaida/mostrarAgendamentoSaida.html',
      controller: 'AgSaidaCtrl'
    })

    .when('/AlugarApartamento', {
      templateUrl: 'src/AlugarApartamento/alugarApe.html',
      controller: 'AlugarApeCtrl'
    })

    .when('/MostrarAlugarApe', {
      templateUrl: 'src/MostrarAlugarApe/mostrarAlugarApe.html',
      controller: 'MostrarAlugarApeCtrl'
    })


    .when('/VenderApartamento', {
      templateUrl: 'src/VenderApartamento/venderApe.html',
      controller: 'VenderApeCtrl'
    })

    .when('/MostrarVendaApe', {
      templateUrl: 'src/MostrarVendaApe/mostrarVendaApe.html',
      controller: 'MostrarVendaApeCtrl'
    })

    .when('/FotoAlugarApe', {
      templateUrl: 'src/FotoAlugarApe/fotoApe.html',
      controller: 'fotoApeCtrl'
    })

    .when('/MostrarFotosAlugarApe', {
      templateUrl: 'src/MostrarFotosAlugarApe/mostrarFotoApe.html',
      controller: 'MostrarFotoApeCtrl'
    })


    .when('/FotoVendaApe', {
      templateUrl: 'src/FotoVendaApe/fotoVendaApe.html',
      controller: 'fotoVendaApeCtrl'
    })

    .when('/MostrarFotosVendaApe', {
      templateUrl: 'src/MostrarFotosVendaApe/mostrarFotoVendaApe.html',
      controller: 'MostrarFotoVendaApeCtrl'
    })

    .when('/CaixaEntrada', {
      templateUrl: 'src/CaixaEntrada/caixaEntrada.html',
      controller: 'caixaEntradaCtrl'


    })

    .when('/RelatorioJasper', {
      templateUrl: 'src/RelatorioJasper/relatorio.html',
      controller: 'relatorioCtrl'



    })

    .otherwise({
        redirectTo: '/'

  });


  }).config(function($httpProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        $httpProvider.defaults.withCredentials = true;
        $httpProvider.interceptors.push('httpRequestInterceptor');


      })
      .run(function($rootScope, ngNotify, LoginLogoutSrv) {
        $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };

        ngNotify.config({


          theme: 'pastel'


         });



        LoginLogoutSrv.verifyAuth();


});
