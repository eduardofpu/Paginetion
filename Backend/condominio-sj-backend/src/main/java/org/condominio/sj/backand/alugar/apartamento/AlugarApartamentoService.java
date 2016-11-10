package org.condominio.sj.backand.alugar.apartamento;

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
@RequestMapping(path = ServicePath.ALUGARAPE_PATH)
public class AlugarApartamentoService extends GenericService<AlugarApartamento,Long>{

	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AlugarApartamentoRepository alugarApartamentoRepository;



	@Override
	public List<AlugarApartamento> findAll() {
		UserEntity userAlugarApe = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.alugarApartamentoRepository.findByUserAlugarApe(userAlugarApe);
	}

	@Override
	public ResponseEntity<?> insert(@RequestBody AlugarApartamento alugar,Errors erros) {

		alugar.setUserAlugarApe(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));

		return super.insert(alugar,erros);
	}

	@Override
	public ResponseEntity<?> update(@RequestBody AlugarApartamento alugar,Errors erros) {
		validateUserRequest( alugar);



		return super.update( alugar,erros);
	}

	@Override
	public ResponseEntity<?> deletar(@RequestBody AlugarApartamento alugar) {
		validateUserRequest( alugar);

		return super.deletar( alugar);
	}

	private UserEntity validateUserRequest(AlugarApartamento  alugar) {
		UserEntity userAlugarApe = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if ( alugar.getUserAlugarApe().getEmail().compareToIgnoreCase(userAlugarApe.getEmail()) != 0) {
			throw new SecurityException();
		}

		return userAlugarApe;
	}



}
