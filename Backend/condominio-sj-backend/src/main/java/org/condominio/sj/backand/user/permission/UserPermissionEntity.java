package org.condominio.sj.backand.user.permission;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.condominio.sj.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 201602010251L;

}