package org.condominio.sj.backand.prestador.servico;

import org.condominio.sj.backand.z.utils.BaseBean;

public class BuscarPrestadorServico extends BaseBean{
	
	// Para buscar o nome da imagem
	
	private static final long serialVersionUID = 1L;
	String prestador;
	public BuscarPrestadorServico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuscarPrestadorServico(String prestador) {
		super();
		this.prestador = prestador;
	}
	public String getPrestador() {
		return prestador;
	}
	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}
	
	

}
