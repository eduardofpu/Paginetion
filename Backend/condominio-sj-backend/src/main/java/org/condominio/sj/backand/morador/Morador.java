package org.condominio.sj.backand.morador;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.condominio.sj.backand.apartamento.Apartamento;
import org.condominio.sj.backand.z.utils.BaseEntity;



@Entity
@Table(name = "tb_morador")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Morador extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@Column(name = "nome_morador", length = 120, nullable = false)
	private String nome;
	
	@Column(name = "fone_morador", length = 255, nullable = false, unique = true)
	private String fone;
	
	@Column(name = "email_morador", length = 255, nullable = false, unique = true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ap_id")
	private Apartamento ap;

	public Morador() {
		
	}

	public Morador(String nome, String fone, String email, Apartamento ap) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.ap = ap;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Apartamento getAp() {
		return ap;
	}

	public void setAp(Apartamento ap) {
		this.ap = ap;
	}

	
}
