package org.condominio.sj.backand.user.permission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermissionEntity, UserPermissionKey> {
	
	public UserPermissionEntity findById(Long id);

}
