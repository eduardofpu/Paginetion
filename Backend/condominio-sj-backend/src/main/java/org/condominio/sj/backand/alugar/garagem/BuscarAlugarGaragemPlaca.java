package org.condominio.sj.backand.alugar.garagem;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscarAlugarGaragemPlaca extends BaseBean{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	String placa;

	public BuscarAlugarGaragemPlaca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuscarAlugarGaragemPlaca(String placa) {
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
