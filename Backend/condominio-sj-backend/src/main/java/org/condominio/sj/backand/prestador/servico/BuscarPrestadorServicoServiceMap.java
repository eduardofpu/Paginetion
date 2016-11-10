package org.condominio.sj.backand.prestador.servico;


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
@RequestMapping(ServicePath.PMAP_PATH)
public class BuscarPrestadorServicoServiceMap implements ServiceMap{


	// para fazer o request no nome da imagem digitado no html fronte end.
	@Autowired
	private PrestadorServicoRepository repository;

	@RequestMapping(method = {RequestMethod.POST} )
	@ResponseBody
	public List<PrestadorServico> BuscarPrestadorServicoServiceMap(@RequestBody BuscarPrestadorServico PrestadorAuth){

		return  this.repository.findByPrestadorContaining(PrestadorAuth.getPrestador());



	}


}
