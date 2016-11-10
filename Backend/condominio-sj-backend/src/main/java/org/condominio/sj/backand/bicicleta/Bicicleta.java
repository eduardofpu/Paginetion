package org.condominio.sj.backand.bicicleta;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.condominio.sj.backand.apartamento.Apartamento;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="tb_bicicleta")
@AttributeOverride(name="id" , column = @Column(name="pk_id"))
public class Bicicleta extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Column(name = "modelo_bicicleta", length = 120, nullable = false)
	private String modelo;

	@Column(name = "cor_bicicleta", length = 120, nullable = false)
	private String cor;

	@Column(name = "dono_bicicleta" , length = 120, nullable = false)
	private String dono;


	@ManyToOne
	@JoinColumn(name = "ap_id_b")
	private Apartamento apb;

	public Bicicleta() {


	}

	public Bicicleta(String modelo, String cor,String dono, Apartamento apb) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.dono = dono;
		this.apb = apb;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public Apartamento getApb() {
		return apb;
	}

	public void setAp_b(Apartamento apb) {
		this.apb = apb;
	}





}
