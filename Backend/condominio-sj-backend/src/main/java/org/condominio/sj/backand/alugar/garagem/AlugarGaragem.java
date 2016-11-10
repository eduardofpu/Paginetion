package org.condominio.sj.backand.alugar.garagem;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_alugar_garagem")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class AlugarGaragem extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "modelo_veiculo_cliente", length = 120, nullable = false)
	private String modelo;

	@Column(name = "cor_veiculo_cliente", length = 120, nullable = false)
	private String cor;

	@Column(name = "placa_veiculo_cliente", length = 120, nullable = false)
	private String placa;
	@Column(name = "motorista_cliente", length = 120, nullable = false)
	private String motorista;
	@Column(name = "cnh_cliente", length = 120, nullable = false)
	private String cnh;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_inicial_cliente", length = 19, nullable = false)
	private Date dataInicial;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_final_cliente", length = 19, nullable = false)
	private Date dataFinal;

	@Column(name = "descricao_cliente", length = 255, nullable = false)
	private String descricaoCliente;

	@ManyToOne
	@JoinColumn(name = "aluguelUser_id")
	private UserEntity user;

	public AlugarGaragem() {

	}

	public AlugarGaragem(String modelo, String cor, String placa, String motorista, String cnh, Date dataInicial,
			Date dataFinal, String descricaoCliente, UserEntity user) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.motorista = motorista;
		this.cnh = cnh;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.descricaoCliente = descricaoCliente;
		this.user = user;

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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricaoCliente() {
		return descricaoCliente;
	}

	public void setDescricaoCliente(String descricaoCliente) {
		this.descricaoCliente = descricaoCliente;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
