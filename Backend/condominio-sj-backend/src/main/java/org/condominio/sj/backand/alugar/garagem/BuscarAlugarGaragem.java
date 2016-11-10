package org.condominio.sj.backand.alugar.garagem;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscarAlugarGaragem extends BaseBean{



	private static final long serialVersionUID = 1L;
	String modelo;

	public BuscarAlugarGaragem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuscarAlugarGaragem(String modelo) {
		super();
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


}
