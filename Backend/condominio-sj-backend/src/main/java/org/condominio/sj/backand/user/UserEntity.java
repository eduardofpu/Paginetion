package org.condominio.sj.backand.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.condominio.sj.backand.apartamento.Apartamento;
import org.condominio.sj.backand.permission.PermissionEntity;
import org.condominio.sj.backand.z.utils.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 128, nullable = false)
	private String password;

	@Lob
	private byte[] file;

	@Column(name = "mime_type", nullable = true)
	private String mimeType;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private Apartamento userid;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="permission_id"))
	private List<PermissionEntity> permissions;

	public UserEntity() {
	}

	public UserEntity(String name, String email, String password, byte[] file, String mimeType, Apartamento userid) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.file = file;
		this.mimeType = mimeType;
		this.userid = userid;

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	public List<PermissionEntity> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
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

	public Apartamento getUserid() {
		return userid;
	}

	public void setUserid(Apartamento userid) {
		this.userid = userid;
	}

}
