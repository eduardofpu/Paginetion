package org.condominio.sj.backand.caixa.entrada;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="tb_entradacaixa")
@AttributeOverride(name="id",column=@Column(name="pk_id"))
public class EntradaCaixa extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;


	//@NotBlank(message = "Não pode estar em branco")
	//@NotNull
	@Column(name="tb_valor",length=20,nullable=false)
	private BigDecimal valor;

	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	@ManyToOne
	@JoinColumn(name="gerente")
	private UserEntity gerente;

	public EntradaCaixa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntradaCaixa(BigDecimal valor, Date registerDate, UserEntity gerente) {
		super();
		this.valor = valor;
		this.registerDate = registerDate;
		this.gerente = gerente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public UserEntity getGerente() {
		return gerente;
	}

	public void setGerente(UserEntity gerente) {
		this.gerente = gerente;
	}


}
