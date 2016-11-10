package org.condominio.sj.backand.alugar.garagem;

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
@RequestMapping(path = ServicePath.ALUGARGARAGEM_PATH)
public class AlugarGaragemService extends GenericService<AlugarGaragem,Long>{


	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AlugarGaragemRepository alugarGaragemRepository;



	@Override
	public List<AlugarGaragem> findAll() {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.alugarGaragemRepository.findByUser(user);
	}

	@Override
	public ResponseEntity<?> insert(@RequestBody AlugarGaragem alugarGaragem,Errors erros) {

		alugarGaragem.setUser(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));

		return super.insert(alugarGaragem,erros);
	}

	@Override
	public ResponseEntity<?> update(@RequestBody AlugarGaragem  alugarGaragem,Errors erros) {
		validateUserRequest(alugarGaragem);



		return super.update(alugarGaragem,erros);
	}

	@Override
	public ResponseEntity<?> deletar(@RequestBody AlugarGaragem  alugarGaragem) {
		validateUserRequest(alugarGaragem);

		return super.deletar(alugarGaragem);
	}

	private UserEntity validateUserRequest(AlugarGaragem  alugarGaragem) {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if ( alugarGaragem.getUser().getEmail().compareToIgnoreCase(user.getEmail()) != 0) {
			throw new SecurityException();
		}

		return user;
	}

	@Override
	@RequestMapping(value = "/findall")
	public List<AlugarGaragem> MostrarAlugarGaragem(){

		return this.alugarGaragemRepository.findAllModelo();
	}


}
