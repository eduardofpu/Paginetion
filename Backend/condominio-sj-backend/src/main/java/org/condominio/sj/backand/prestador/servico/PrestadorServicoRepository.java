package org.condominio.sj.backand.prestador.servico;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


//para buscar o nome da imagem
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Long>{
	
		
	public List<PrestadorServico> findByPrestadorContaining(String prestador);
	
	
}
