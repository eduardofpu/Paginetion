package org.condominio.sj.backand.vender.apartamento;

import java.util.List;
import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VIEWVENDERAPE_PATH)
public class MostrarApartamentoAVenda {
	
	@Autowired
	VenderApartamentoRepository venderApartamentoRepository;
	
	@RequestMapping(method = {RequestMethod.GET} )		
	public List<VenderApartamento> MostrarApartamentoParaVenda(){
		
		return this.venderApartamentoRepository.findAll();
	}


}
