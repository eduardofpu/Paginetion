package org.condominio.sj.backand.apartamento;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.condominio.sj.backand.bicicleta.Bicicleta;
import org.condominio.sj.backand.morador.Morador;
import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.veiculo.Veiculo;
import org.condominio.sj.backand.z.utils.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "tb_apartamento")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))

public class Apartamento extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Não pode estar em branco")
	@NotNull
	@Column(name = "descricao_apartamento", length = 120, nullable = false)
	private String descricao;

	@Column(name = "nome_proprietario", length = 120, nullable = false)
	private String nome;

	@Column(name = "fone_proprietario", length = 255, nullable = false, unique = true)
	private String fone;

	@Column(name = "email_proprietario", length = 255, nullable = false, unique = true)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ap")
	private List<Morador> morador;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "apv")
	private List<Veiculo> veiculo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "apb")

	private List<Bicicleta> bicicleta;


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userid")

	private List<UserEntity> userEntity;






	public Apartamento() {

	}

	public Apartamento(String descricao, String nome, String fone, String email) {
		super();
		this.descricao = descricao;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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







}
