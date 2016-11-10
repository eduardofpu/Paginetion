package org.condominio.sj.backand.veiculo;

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
@RequestMapping(path = ServicePath.BUSCAV_PATH)
public class BuscaVeiculoService implements ServiceMap{
	@Autowired
	private VeiculoRepository v;

	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	public List<Veiculo>BuscaVeiculoService(@RequestBody BuscaVeiculo placa){

		return this.v.findByPlacaContaining(placa.getPlaca());
	}

}
