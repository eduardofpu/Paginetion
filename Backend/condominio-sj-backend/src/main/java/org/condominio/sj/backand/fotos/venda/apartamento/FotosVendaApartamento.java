package org.condominio.sj.backand.fotos.venda.apartamento;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.vender.apartamento.VenderApartamento;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="tb_foto_venda_ape")
@AttributeOverride(name = "id" , column = @Column(name = "pk_id"))
public class FotosVendaApartamento extends BaseEntity<Long>{

	
	private static final long serialVersionUID = 1L;
	
	@Lob
	private byte[] file;

	@Column(name = "mime_type", nullable = true)
	private String mimeType;
	
	@Column(name = "tb_venda_comodo" , length = 120 , nullable = false)
	private String comodo;
	
	@ManyToOne
	@JoinColumn(name = "userape_id")
	private UserEntity  userFotoVendaApe;
	
	@ManyToOne
	@JoinColumn(name = "apid_alugar")	
	private VenderApartamento venderApartamentoId;
	

	public FotosVendaApartamento() {
		
	}


	public FotosVendaApartamento(byte[] file, String mimeType, String comodo, UserEntity userFotoVendaApe,
			VenderApartamento venderApartamentoId) {
		super();
		this.file = file;
		this.mimeType = mimeType;
		this.comodo = comodo;
		this.userFotoVendaApe = userFotoVendaApe;
		this.venderApartamentoId = venderApartamentoId;
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


	public UserEntity getUserFotoVendaApe() {
		return userFotoVendaApe;
	}


	public void setUserFotoVendaApe(UserEntity userFotoVendaApe) {
		this.userFotoVendaApe = userFotoVendaApe;
	}


	public VenderApartamento getVenderApartamentoId() {
		return venderApartamentoId;
	}


	public void setVenderApartamentoId(VenderApartamento venderApartamentoId) {
		this.venderApartamentoId = venderApartamentoId;
	}
	
	

}
