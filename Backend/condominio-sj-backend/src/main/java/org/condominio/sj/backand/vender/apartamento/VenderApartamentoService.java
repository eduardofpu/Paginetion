package org.condominio.sj.backand.vender.apartamento;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.user.UserRepository;
import org.condominio.sj.backand.z.security.CurrentUser;
import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path=ServicePath.VENDERAPE_PATH)
public class VenderApartamentoService extends GenericService<VenderApartamento,Long>{



	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VenderApartamentoRepository venderApartamentoRepository;



	@Override
	public List<VenderApartamento> findAll() {
		UserEntity userVenderApe = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.venderApartamentoRepository.findByUserVenderApe(userVenderApe);
	}

	@Override
	public ResponseEntity<?> insert(@RequestBody VenderApartamento vender,Errors erros) {

		vender.setUserVenderApe(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));

		return super.insert(vender,erros);
	}

	@Override
	public ResponseEntity<?> update(@RequestBody VenderApartamento vender,Errors erros) {
		validateUserRequest( vender);



		return super.update( vender,erros);
	}

	@Override
	public ResponseEntity<?> deletar(@RequestBody VenderApartamento vender) {
		validateUserRequest( vender);

		return super.deletar( vender);
	}

	private UserEntity validateUserRequest(VenderApartamento  vender) {
		UserEntity userVenderApe = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if ( vender.getUserVenderApe().getEmail().compareToIgnoreCase(userVenderApe.getEmail()) != 0) {
			throw new SecurityException();
		}

		return userVenderApe;
	}




}
