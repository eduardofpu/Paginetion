package org.condominio.sj.backand.veiculo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.condominio.sj.backand.apartamento.Apartamento;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_veiculo")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Veiculo extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Column(name = "modelo_veiculo", length = 120, nullable = false)
	private String modelo;

	@Column(name = "cor_veiculo", length = 120, nullable = false)
	private String cor;

	@Column(name = "placa_veiculo", length = 120, nullable = false)
	private String placa;

	@Column(name = "motorista_veiculo", length = 120, nullable = false)
	private String motorista;

	@Column(name = "cnh_veiculo", length = 120, nullable = false)
	private String cnh;



	@ManyToOne
	@JoinColumn(name = "ap_id_v")
	private Apartamento apv;



	public Veiculo() {

	}






	public Veiculo(String modelo, String cor,String placa, String motorista, String cnh, Apartamento apv) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.motorista = motorista;
		this.cnh = cnh;
		this.apv = apv;
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






	public String getPlaca() {
		return placa;
	}






	public void setPlaca(String placa) {
		this.placa = placa;
	}






	public String getMotorista() {
		return motorista;
	}






	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}






	public String getCnh() {
		return cnh;
	}






	public void setCnh(String cnh) {
		this.cnh = cnh;
	}






	public Apartamento getApv() {
		return apv;
	}






	public void setAp_v(Apartamento apv) {
		this.apv = apv;
	}



}
