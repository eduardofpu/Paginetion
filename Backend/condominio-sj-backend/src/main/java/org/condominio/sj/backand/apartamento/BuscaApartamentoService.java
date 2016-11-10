package org.condominio.sj.backand.apartamento;

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
@RequestMapping(path = ServicePath.BUSCAP_PATH)
public class BuscaApartamentoService implements ServiceMap{

	@Autowired
	ApartamentoRepository ap;
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	public List<Apartamento> BuscaApartamentoService(@RequestBody BuscaApartamento descricao){

		return this.ap.findByDescricaoContaining(descricao.getDescricao());



	}

}
