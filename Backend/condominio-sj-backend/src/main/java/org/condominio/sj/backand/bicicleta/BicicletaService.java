package org.condominio.sj.backand.bicicleta;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.BICICLETA_PATH)
public class BicicletaService extends GenericService<Bicicleta,Long>{

}
