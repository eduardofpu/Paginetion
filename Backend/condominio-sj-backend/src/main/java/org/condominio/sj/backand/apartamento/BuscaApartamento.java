package org.condominio.sj.backand.apartamento;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscaApartamento extends BaseBean{

	private static final long serialVersionUID = 1L;
	String descricao;

	public BuscaApartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuscaApartamento(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



}
