package org.condominio.sj.backand.apartamento;

import java.util.List;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.APARTAMENTO_PATH)
public class ApartamentoService extends GenericService<Apartamento,Long>{


	@Autowired
	private ApartamentoRepository a;


	@Override
	@RequestMapping(value = "/ordenarapartamentos")
	public List<Apartamento> OrdenarApartamentos(){

		return this.a.findAllDescricao();

	}

}
