package org.condominio.sj.backand.alugar.garagem;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlugarGaragemRepository extends JpaRepository<AlugarGaragem,Long>{

	public List<AlugarGaragem> findByUser(UserEntity user);


	public List<AlugarGaragem> findByModeloContaining(String modelo);

	@Query("select u from AlugarGaragem u order by u.modelo asc")
	public List<AlugarGaragem> findAllModelo();

	public List<AlugarGaragem> findByPlacaContaining(String placa);

}
