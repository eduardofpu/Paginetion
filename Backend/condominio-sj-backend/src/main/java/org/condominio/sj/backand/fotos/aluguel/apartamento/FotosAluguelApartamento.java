package org.condominio.sj.backand.fotos.aluguel.apartamento;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.condominio.sj.backand.alugar.apartamento.AlugarApartamento;
import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.z.utils.BaseEntity;


@Entity
@Table(name="tb_foto_alugar_ape")
@AttributeOverride(name = "id" , column = @Column(name = "pk_id"))
public class FotosAluguelApartamento extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Lob
	private byte[] file;

	@Column(name = "mime_type", nullable = true)
	private String mimeType;
	
	@Column(name = "tb_comodo" , length = 120 , nullable = false)
	private String comodo;
	
	@ManyToOne
	@JoinColumn(name = "FotosApe_id")
	private UserEntity userFotoApe;
	
	
	@ManyToOne
	@JoinColumn(name = "ap_id_alugar")
	private AlugarApartamento alugarApartamentoId;
	
	

	public FotosAluguelApartamento() {
		
	}



	public FotosAluguelApartamento(byte[] file, String mimeType, String comodo, UserEntity userFotoApe,
			AlugarApartamento alugarApartamentoId) {
		super();
		this.file = file;
		this.mimeType = mimeType;
		this.comodo = comodo;
		this.userFotoApe = userFotoApe;
		this.alugarApartamentoId = alugarApartamentoId;
	}



	public byte[] getFile() {
		return file;
	}



	public void setFile(byte[] file) {
		this.file = file;
	}



	public String getMimeType() {
		return mimeType;
	}



	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}



	public String getComodo() {
		return comodo;
	}



	public void setComodo(String comodo) {
		this.comodo = comodo;
	}



	public UserEntity getUserFotoApe() {
		return userFotoApe;
	}



	public void setUserFotoApe(UserEntity userFotoApe) {
		this.userFotoApe = userFotoApe;
	}



	public AlugarApartamento getAlugarApartamentoId() {
		return alugarApartamentoId;
	}



	public void setAlugarApartamentoId(AlugarApartamento alugarApartamentoId) {
		this.alugarApartamentoId = alugarApartamentoId;
	}

	
}
