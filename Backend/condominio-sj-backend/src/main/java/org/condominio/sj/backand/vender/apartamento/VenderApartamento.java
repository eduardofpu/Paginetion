package org.condominio.sj.backand.vender.apartamento;



import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.condominio.sj.backand.fotos.venda.apartamento.FotosVendaApartamento;
import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_vender_apartamento")
@AttributeOverride(name = "id" , column = @Column(name = "pk_id"))
public class VenderApartamento extends BaseEntity<Long>{
	

	private static final long serialVersionUID = 1L;
    private String valor;
    
    @ManyToOne
	@JoinColumn(name = "venderApeUser_id")
	private UserEntity userVenderApe;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venderApartamentoId")
    private List<FotosVendaApartamento> fotosVendaApartamento;
   
    
	public VenderApartamento() {
		
	}


	public VenderApartamento(String valor, UserEntity userVenderApe) {
		super();
		this.valor = valor;
		this.userVenderApe = userVenderApe;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public UserEntity getUserVenderApe() {
		return userVenderApe;
	}


	public void setUserVenderApe(UserEntity userVenderApe) {
		this.userVenderApe = userVenderApe;
	}
	
    
    
    

}
