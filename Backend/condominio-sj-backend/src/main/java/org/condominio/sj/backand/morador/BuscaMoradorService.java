package org.condominio.sj.backand.morador;

import java.util.List;

import org.condominio.sj.backand.z.utils.ServiceMap;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.BUSCAM_PATH)
public class BuscaMoradorService implements ServiceMap{


	@Autowired
	MoradorRepository m;

	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	public List<Morador> BuscaMoradorService(@RequestBody BuscaMorador nome){

		return m.findByNomeContaining(nome.getNome());
	}

}
