package org.condominio.sj.backand.caixa;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="tb_caixa")
@AttributeOverride(name="id",column=@Column(name="pk_id"))
public class Caixa extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;

	@Column(name="tb_valor",length=20,nullable=false)
	private BigDecimal valor;

	public Caixa() {

	}

	public Caixa(BigDecimal valor) {
		super();
		this.valor = valor;

	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	// Metodo para subtrair valor na tabela PrestarConta

	public void subtractValor(BigDecimal valor) {
		this.valor = this.valor.subtract(valor);
	}


	// Metodo para adicionar valor na tabela EntradaCaixaService

	public void adicionarValor(BigDecimal valor) {

		this.valor = this.valor.add(valor);
	}



}
