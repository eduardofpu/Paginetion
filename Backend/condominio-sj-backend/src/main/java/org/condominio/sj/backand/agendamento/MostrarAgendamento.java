/*
package org.condominio.sj.backand.agendamento;

import java.util.List;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWAGENDAMENTO_PATH)
public class MostrarAgendamento extends GenericService<Agendamento,Long>{


	@Autowired
	AgendamentoRepository agendamentoRepository;


	@Override
	//@RequestMapping(value = "/mostrarodernado")
	public List<Agendamento> MostrarAgenda(){

		return this.agendamentoRepository.findAllData();

	}



	@Override
	public ResponseEntity<?> insert(@RequestBody Agendamento agenda,Errors erros) {


		return super.insert(agenda,erros);
	}


	//@RequestMapping(value = "/update")
	public ResponseEntity<?> updateByFuncionario(@RequestBody Agendamento  agenda, Errors erros) {



		return super.update( agenda,erros);
	}


	@Override
	public ResponseEntity<?> deletar(@RequestBody Agendamento agenda) {


		return super.deletar(agenda);
	}









}
 */
