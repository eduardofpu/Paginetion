package org.condominio.sj.backand.user;

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
@RequestMapping(path = ServicePath.USUARIOS_PATH)
public class UsuariosService extends GenericService<UserEntity, Long> {


	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public ResponseEntity<?> insert(@RequestBody UserEntity user,Errors erros) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		return super.insert(user,erros);
	}

	@Override
	public ResponseEntity<?> update(@RequestBody UserEntity user,Errors erros) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		return super.update(user,erros);
	}






}
