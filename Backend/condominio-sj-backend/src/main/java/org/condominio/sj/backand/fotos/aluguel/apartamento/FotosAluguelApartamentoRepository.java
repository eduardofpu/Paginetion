package org.condominio.sj.backand.fotos.aluguel.apartamento;

import java.util.List;
import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotosAluguelApartamentoRepository extends JpaRepository<FotosAluguelApartamento, Long> {
	
	public List<FotosAluguelApartamento> findByUserFotoApe(UserEntity userFotoApe);
	
	

}
