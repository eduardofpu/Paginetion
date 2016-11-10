package org.condominio.sj.backand.prestador.servico;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.PREST_PATH )
public class PrestadorServicoService extends GenericService<PrestadorServico, Long> {
	
	
	
}
