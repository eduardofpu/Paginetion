package org.condominio.sj.backand.agendamento;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscarAgendamento extends BaseBean{


	private static final long serialVersionUID = 1L;
	String empresa;
	public BuscarAgendamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuscarAgendamento(String empresa) {
		super();
		this.empresa = empresa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}





}
