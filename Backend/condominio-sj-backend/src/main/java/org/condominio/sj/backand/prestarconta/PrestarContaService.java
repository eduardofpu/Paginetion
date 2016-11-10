package org.condominio.sj.backand.prestarconta;

import java.util.Date;

import javax.transaction.Transactional;

import org.condominio.sj.backand.caixa.Caixa;
import org.condominio.sj.backand.caixa.CaixaRepository;
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
@RequestMapping(path = ServicePath.CONTA_PATH)
public class PrestarContaService extends GenericService<PrestarConta, Long> {

	@Autowired
	private CaixaRepository caixaRepository;


	@Override
	@Transactional
	public ResponseEntity<?> insert(@RequestBody PrestarConta prestarConta,Errors erros) {
		prestarConta.setRegisterDate(new Date());

		Caixa caixa = caixaRepository.findAll(new PageRequest(0, 1)).getContent().get(0);

		// Metodo subtractValor criado na tabela Caixa

		caixa.subtractValor(prestarConta.getValor());

		caixaRepository.save(caixa);

		return super.insert(prestarConta,erros);
	}

}
