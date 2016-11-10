package org.condominio.sj.backand.funcionario;


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
@RequestMapping(path = ServicePath.FMAP_PATH )
public class BuscarFuncionarioServiceMap  implements ServiceMap {

	// para fazer o request no nome da imagem digitado no html fronte end.

	@Autowired
	private FuncionarioRepository repository;


	@RequestMapping(method = {RequestMethod.POST} )
	@ResponseBody
	public List<Funcionario> BuscarFuncionarioServiceMap(@RequestBody BuscarFuncionario funcionario){

		return  this.repository.findByFuncionarioContaining(funcionario.getFuncionario());


	}




}
