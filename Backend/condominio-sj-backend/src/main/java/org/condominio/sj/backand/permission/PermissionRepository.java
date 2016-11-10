package org.condominio.sj.backand.permission;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

	
	public PermissionEntity findByRole(String role);
	
	public PermissionEntity findById(Long id);
	
    
}
