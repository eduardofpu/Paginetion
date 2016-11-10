package org.condominio.sj.backand.prestarconta;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.condominio.sj.backand.z.utils.BaseEntity;
@Entity
@Table(name="tb_prestar_conta")
@AttributeOverride(name="id",column=@Column(name="pk_id"))
public class PrestarConta extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	
	@Column(name="tb_descricao",length=255,nullable=false)
	private String descricao;
	@Column(name="tb_funcionario",length=20,nullable=false)
	private String funcionario;
	@Column(name="tb_empresa",length=20,nullable=false)
	private String empresa;
	@Column(name="tb_valor_servico",length=20,nullable=false)
	private BigDecimal valor;
	
	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	public PrestarConta() {
		
	}

	public PrestarConta(String descricao, String funcionario, String empresa, BigDecimal valor, Date registerDate) {
		super();
		this.descricao = descricao;
		this.funcionario = funcionario;
		this.empresa = empresa;
		this.valor = valor;
		this.registerDate = registerDate;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	
	

}
