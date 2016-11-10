package org.condominio.sj.backand.ocorrencia;




import java.util.Date;

import org.condominio.sj.backand.z.utils.GenericService;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.OCORRENCIA_PATH)
public class OcorrenciaService extends GenericService<Ocorrencia,Long>{

	@Override
	public ResponseEntity<?> insert(@RequestBody Ocorrencia ocorrencia,Errors erros){

		ocorrencia.setRegisterDate(new Date());

		return super.insert(ocorrencia,erros);


	}

}
