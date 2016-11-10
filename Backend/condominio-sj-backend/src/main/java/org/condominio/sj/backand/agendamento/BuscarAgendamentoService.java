package org.condominio.sj.backand.agendamento;

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
@RequestMapping(path = ServicePath.ENTRADASAIDA_PATH )
public class BuscarAgendamentoService implements ServiceMap{

	@Autowired
	private AgendamentoRepository a;

	@RequestMapping(method = {RequestMethod.POST} )
	@ResponseBody
	public List<Agendamento> BuscarAgendamentoService(@RequestBody BuscarAgendamento empresa){
		return this.a.findByEmpresaContaining(empresa.getEmpresa());


	}
}
