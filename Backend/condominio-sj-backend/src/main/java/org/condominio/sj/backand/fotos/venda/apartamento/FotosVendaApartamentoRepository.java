package org.condominio.sj.backand.fotos.venda.apartamento;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotosVendaApartamentoRepository extends JpaRepository<FotosVendaApartamento,Long>{
	
	public List<FotosVendaApartamento>findByUserFotoVendaApe(UserEntity userFotoVendaApe);

}
