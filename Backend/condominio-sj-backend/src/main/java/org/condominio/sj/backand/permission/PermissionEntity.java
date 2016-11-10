package org.condominio.sj.backand.permission;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_permission")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class PermissionEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010401L;

	@Column(name = "role", length = 45, nullable = false, unique = true)
	private String role;

	public PermissionEntity() {
	}

	public PermissionEntity(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
