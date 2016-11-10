package org.condominio.sj.backand.alugar.apartamento;



import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.condominio.sj.backand.fotos.aluguel.apartamento.FotosAluguelApartamento;
import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name="tb_alugar_apartamento")
@AttributeOverride(name="id", column = @Column(name="pk_id"))
public class AlugarApartamento extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;

	@Column(name = "tb_valor" , length=10 , nullable=false)
	private String valor;

	@ManyToOne
	@JoinColumn(name="alugarApeUser_id")
	private UserEntity userAlugarApe;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "alugarApartamentoId")
	private List<FotosAluguelApartamento>fotosAluguelApartamento;


	public AlugarApartamento() {

	}

	public AlugarApartamento(String valor, UserEntity userAlugarApe) {
		super();
		this.valor = valor;
		this.userAlugarApe = userAlugarApe;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public UserEntity getUserAlugarApe() {
		return userAlugarApe;
	}

	public void setUserAlugarApe(UserEntity userAlugarApe) {
		this.userAlugarApe = userAlugarApe;
	}







}
