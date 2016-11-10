package org.condominio.sj.backand.morador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoradorRepository extends JpaRepository<Morador,Long>{

	public List<Morador>findByNomeContaining(String nome);

	@Query("select u from Morador u order by u.ap asc")
	public List<Morador> findAllAp();

}
