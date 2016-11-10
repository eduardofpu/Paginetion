package org.condominio.sj.backand.veiculo;

import java.util.List;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VEICULO_PATH)
public class VeiculoService extends GenericService<Veiculo,Long>{

	@Autowired
	private VeiculoRepository v;


	@Override
	@RequestMapping(value = "/ordenarveiculos")
	public List<Veiculo> OrdenarVeiculos(){

		return this.v.findAllApv();

	}

}
