package org.condominio.sj.backand.z.utils;

public final class ServicePath {

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";
	public static final String ROOT_PATH = "/api";
	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

	///////////////////////////////////////////////////////////////
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////


	public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";
	public static final String PERVISIT_PATH = PUBLIC_ROOT_PATH + "/permisvisit";


	public static final String EDITUSER_PATH = PRIVATE_ROOT_PATH + "/edituser";
	public static final String USUARIOS_PATH = PRIVATE_ROOT_PATH + "/usuarios";
	public static final String VISITANTES_PATH = PUBLIC_ROOT_PATH + "/visitantes";



	public static final String APARTAMENTO_PATH = PRIVATE_ROOT_PATH + "/apartamento";
	public static final String MORADOR_PATH = PRIVATE_ROOT_PATH +"/morador";
	public static final String VEICULO_PATH = PRIVATE_ROOT_PATH +"/veiculo";
	public static final String BICICLETA_PATH = PRIVATE_ROOT_PATH +"/bicicleta";
	public static final String FUNCIONARIO_PATH = PRIVATE_ROOT_PATH + "/funcionario";
	public static final String FMAP_PATH = PRIVATE_ROOT_PATH + "/fmap";
	public static final String PREST_PATH = PRIVATE_ROOT_PATH + "/prestadorservico";
	public static final String PMAP_PATH  = PRIVATE_ROOT_PATH + "/pmap";
	public static final String OCORRENCIA_PATH  = PRIVATE_ROOT_PATH + "/ocorrencia";
	public static final String CAIXA_PATH = PRIVATE_ROOT_PATH+ "/caixa";
	public static final String CONTA_PATH = PRIVATE_ROOT_PATH + "/prestarConta";


	public static final String ALUGARGARAGEM_PATH = PRIVATE_ROOT_PATH + "/alugarGaragem";
	public static final String VIEWLOCACAO_PATH = PRIVATE_ROOT_PATH + "/mostrarAluguelGaragem";
	public static final String BG_PATH = PRIVATE_ROOT_PATH + "/bg";
	public static final String BGP_PATH = PRIVATE_ROOT_PATH + "/bgp";


	public static final String AGENDAMENTO_PATH = PRIVATE_ROOT_PATH + "/agendamento";
	public static final String VIEWAGENDAMENTO_PATH = PRIVATE_ROOT_PATH + "/mostrarAgendamento";

	public static final String ALUGARAPE_PATH = PRIVATE_ROOT_PATH + "/alugarApartamento";
	public static final String VIEWALUGARAPE_PATH = PRIVATE_ROOT_PATH + "/mostrarAlugarApe";


	public static final String VENDERAPE_PATH = PRIVATE_ROOT_PATH + "/venderApartamento";
	public static final String VIEWVENDERAPE_PATH = PRIVATE_ROOT_PATH + "/mostrarApeAVenda";

	public static final String FOTOSALUGARAPE_PATH = PRIVATE_ROOT_PATH + "/fotosAlugarApe";
	public static final String VIEWFOTOAPE_PATH = PRIVATE_ROOT_PATH + "/mostrarFotoApeAlugar";

	public static final String FOTOSVENDAPE_PATH = PRIVATE_ROOT_PATH + "/vendaApe";
	public static final String VIEWFOTOVENDAPE_PATH = PRIVATE_ROOT_PATH + "/mostrarFotoApeVenda";

	public static final String ENTRADACAIXA_PATH = PRIVATE_ROOT_PATH + "/entradacaixa";


	public static final String JASPER_PATH = PRIVATE_ROOT_PATH + "/relatorio";


	public static final String ENTRADASAIDA_PATH = PRIVATE_ROOT_PATH + "/entradaSaida";

	public static final String BUSCAP_PATH = PRIVATE_ROOT_PATH + "/buscap";
	public static final String BUSCAV_PATH = PRIVATE_ROOT_PATH + "/buscav";
	public static final String BUSCAM_PATH = PRIVATE_ROOT_PATH + "/buscam";


	///////////////////////////////////////////////////////////////
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////


	public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";
	public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";


}
