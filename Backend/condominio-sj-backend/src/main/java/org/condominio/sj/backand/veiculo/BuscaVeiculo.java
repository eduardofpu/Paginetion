package org.condominio.sj.backand.veiculo;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscaVeiculo extends BaseBean{


	private static final long serialVersionUID = 1L;
	String placa;
	public BuscaVeiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuscaVeiculo(String placa) {
		super();
		this.placa = placa;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}



}
