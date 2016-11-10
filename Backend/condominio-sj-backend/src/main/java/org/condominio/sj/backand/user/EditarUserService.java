package org.condominio.sj.backand.user;




import java.util.List;

import org.condominio.sj.backand.z.security.CurrentUser;
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
@RequestMapping(path = ServicePath.EDITUSER_PATH)
public class EditarUserService extends GenericService<UserEntity, Long> {
	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public List<UserEntity> findAll() {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.userRepository.findById(user.getId());
	}

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
