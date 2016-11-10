package org.condominio.sj.backand.alugar.apartamento;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlugarApartamentoRepository extends JpaRepository<AlugarApartamento,Long>{
	
	public List<AlugarApartamento> findByUserAlugarApe(UserEntity userAlugarApe);

}
