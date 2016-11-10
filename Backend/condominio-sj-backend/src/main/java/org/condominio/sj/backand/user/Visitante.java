
package org.condominio.sj.backand.user;



import org.condominio.sj.backand.permission.PermissionEntity;
import org.condominio.sj.backand.permission.PermissionRepository;
import org.condominio.sj.backand.user.permission.UserPermissionEntity;
import org.condominio.sj.backand.user.permission.UserPermissionKey;
import org.condominio.sj.backand.user.permission.UserPermissionRepository;
import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = ServicePath.VISITANTES_PATH)
public class Visitante extends GenericService<UserEntity, Long> {



	@Autowired
	private UserRepository userRepository;

	@Autowired
	PermissionRepository permissaoRepository;

	@Autowired
	UserPermissionRepository userPermission;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<?> insert(@RequestBody UserEntity user,Errors erros) {

		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		this.userRepository.saveAndFlush(user);

		PermissionEntity permissao = this.permissaoRepository.findByRole("ROLE_VISITANTE");

		if (permissao == null) {
			PermissionEntity permissao2 = new PermissionEntity();
			permissao2.setRole("ROLE_VISITANTE");

			permissao = this.permissaoRepository.save(permissao2);
		}
		UserPermissionKey userPermissionKey = new UserPermissionKey();
		userPermissionKey.setPermissionId(permissao.getId());
		userPermissionKey.setUserId(user.getId());

		UserPermissionEntity userPermission = new UserPermissionEntity();
		userPermission.setId(userPermissionKey);

		this.userPermission.save(userPermission);

		//return this.userRepository.saveAndFlush(user,erros);

		return ((Visitante) this.userRepository).insert(user,erros);
	}

}
