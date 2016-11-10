package org.condominio.sj.backand.caixa.entrada;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.condominio.sj.backand.caixa.Caixa;
import org.condominio.sj.backand.caixa.CaixaRepository;
import org.condominio.sj.backand.user.UserEntity;
import org.condominio.sj.backand.user.UserRepository;
import org.condominio.sj.backand.z.security.CurrentUser;
import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path=ServicePath.ENTRADACAIXA_PATH)
public class EntradaCaixaService extends GenericService<EntradaCaixa,Long>{

	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntradaCaixaRepository entradaCaixaRepository;

	@Autowired
	private CaixaRepository caixaRepository;


	@Override
	public List<EntradaCaixa> findAll() {
		UserEntity gerente = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.entradaCaixaRepository.findByGerente(gerente);
	}



	@Override
	@Transactional
	public ResponseEntity<?> insert(@RequestBody EntradaCaixa entradaCaixa,Errors erros){

		entradaCaixa.setGerente(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));
		entradaCaixa.setRegisterDate(new Date());

		Caixa caixa = caixaRepository.findAll(new PageRequest(0, 1)).getContent().get(0);

		// Metodo adicionarValor criado na tabela Caixa
		caixa.adicionarValor(entradaCaixa.getValor());

		caixaRepository.save(caixa);

		return super.insert(entradaCaixa,erros);
	}


}
