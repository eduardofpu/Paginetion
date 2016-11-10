package org.condominio.sj.backand.ocorrencia;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="td_ocorrencia")
@AttributeOverride(name="id", column=@Column(name="pk_id"))
public class Ocorrencia extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "tb_registro", length = 500, nullable = false)
	private String registro;
	
	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	public Ocorrencia() {
		
	}

	public Ocorrencia(String registro, Date registerDate) {
		super();
		this.registro = registro;
		this.registerDate = registerDate;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	
	
	

}
