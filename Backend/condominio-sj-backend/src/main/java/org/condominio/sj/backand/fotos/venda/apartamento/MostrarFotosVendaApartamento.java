package org.condominio.sj.backand.fotos.venda.apartamento;

import java.util.List;


import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWFOTOVENDAPE_PATH)
public class MostrarFotosVendaApartamento {
	
	@Autowired
	FotosVendaApartamentoRepository fotoRepository;
	
	
	@RequestMapping(method = {RequestMethod.GET} )		
	public List<FotosVendaApartamento> MostrarFotosVendaApe(){
		
		return this.fotoRepository.findAll();
	}
	

}
