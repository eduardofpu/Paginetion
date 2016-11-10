package org.condominio.sj.backand.funcionario;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscarFuncionario extends BaseBean{
	
	// Para buscar o nome da imagem
	
	private static final long serialVersionUID = 1L;
	String funcionario;
	public BuscarFuncionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BuscarFuncionario(String funcionario) {
		super();
		this.funcionario = funcionario;
	}


	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
	

}
