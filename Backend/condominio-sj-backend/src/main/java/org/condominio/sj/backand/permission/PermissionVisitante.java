package org.condominio.sj.backand.permission;

import java.util.List;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = ServicePath.PERVISIT_PATH)
public class PermissionVisitante extends GenericService<PermissionEntity, Long> {
	
	
	
	@Autowired
	private PermissionRepository permissaoRepository;
	
	@RequestMapping(value = "/findRole/{role}", method = RequestMethod.GET)
	public PermissionEntity findRole(@PathVariable("role") String role) {
		return this.permissaoRepository.findByRole(role);
	}
	
	@Override
	public List<PermissionEntity> findAll() {
		return super.findAll();
	}
	
    
}
