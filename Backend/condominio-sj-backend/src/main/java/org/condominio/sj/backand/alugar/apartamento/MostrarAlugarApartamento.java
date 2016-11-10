package org.condominio.sj.backand.alugar.apartamento;

import java.util.List;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWALUGARAPE_PATH)
public class MostrarAlugarApartamento {
	
	@Autowired
	AlugarApartamentoRepository alugarApartamentoRepository;
	
	@RequestMapping(method = {RequestMethod.GET} )		
	public List<AlugarApartamento> MostrarApartamentoParaAluguel(){
		
		return this.alugarApartamentoRepository.findAll();
	}

}
