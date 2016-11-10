
package org.condominio.sj.backand.agendamento;

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
@Table(name="tb_agendamento")
@AttributeOverride(name="id",column = @Column(name="pk_id"))
public class Agendamento extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;

	@Column(name="agenda_descricao", length=255 , nullable=false)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "agenda_data", length = 19, nullable = false)
	private Date data;


	//@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm")
	@Column(name="hora_prevista", length=255 , nullable=false)
	private String hora;

	@JsonFormat(pattern="HH:mm")
	@Column(name="hora_entrada", length=255 , nullable=true)
	private String horaentrada;


	@JsonFormat(pattern="HH:mm")
	@Column(name="hora_saida", length=255 , nullable=true)
	private String horasaida;





	@Column(name="agenda_empresa", length=120 , nullable=false)
	private String empresa;

	@ManyToOne
	@JoinColumn(name="agendaUser_id")
	private UserEntity userAgenda;

	public Agendamento() {

	}

	public Agendamento(String descricao, Date data,  String hora, String empresa,
			UserEntity userAgenda,String horaentrada,String horasaida) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.hora = hora;
		this.empresa = empresa;
		this.userAgenda = userAgenda;
		this.horaentrada = horaentrada;
		this.horasaida = horasaida;

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public  String getHora() {
		return hora;
	}

	public void setHora( String hora) {
		this.hora = hora;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public UserEntity getUserAgenda() {
		return userAgenda;
	}

	public void setUserAgenda(UserEntity userAgenda) {
		this.userAgenda = userAgenda;
	}

	public String getHoraentrada() {
		return horaentrada;
	}

	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}

	public String getHorasaida() {
		return horasaida;
	}

	public void setHorasaida(String horasaida) {
		this.horasaida = horasaida;
	}








}
