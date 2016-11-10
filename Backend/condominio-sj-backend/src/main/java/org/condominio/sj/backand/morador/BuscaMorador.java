package org.condominio.sj.backand.morador;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscaMorador extends BaseBean{


	private static final long serialVersionUID = 1L;

	String nome;

	public BuscaMorador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuscaMorador(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
