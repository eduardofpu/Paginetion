package org.condominio.sj.backand.apartamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApartamentoRepository extends JpaRepository<Apartamento,Long>{

	public List<Apartamento> findByDescricaoContaining(String descricao);

	@Query("select u from Apartamento u order by u.descricao asc")
	public List<Apartamento> findAllDescricao();

}
