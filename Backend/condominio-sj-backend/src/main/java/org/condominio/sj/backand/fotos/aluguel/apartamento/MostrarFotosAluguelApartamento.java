package org.condominio.sj.backand.fotos.aluguel.apartamento;

import java.util.List;

import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWFOTOAPE_PATH)
public class MostrarFotosAluguelApartamento {
	
	@Autowired
	FotosAluguelApartamentoRepository fotoRepository;
	
	
	@RequestMapping(method = {RequestMethod.GET} )		
	public List<FotosAluguelApartamento> MostrarFotoAluguel(){
		
		return this.fotoRepository.findAll();
	}
	

}
