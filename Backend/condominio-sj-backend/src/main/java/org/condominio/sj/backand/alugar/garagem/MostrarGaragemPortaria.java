package org.condominio.sj.backand.alugar.garagem;

import java.util.List;

import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWLOCACAO_PATH)
public class MostrarGaragemPortaria {
	
	@Autowired
	AlugarGaragemRepository repositori;
	
	
	@RequestMapping(method = {RequestMethod.GET} )	
	
	public List<AlugarGaragem> MostrarGaragem(){
		
		return this.repositori.findAll();
	}

}
