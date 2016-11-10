package org.condominio.sj.backand.vender.apartamento;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenderApartamentoRepository extends JpaRepository<VenderApartamento,Long>{
	
	public List<VenderApartamento> findByUserVenderApe(UserEntity userVenderApe);

}
