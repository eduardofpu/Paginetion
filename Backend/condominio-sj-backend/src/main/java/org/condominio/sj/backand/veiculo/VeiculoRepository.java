package org.condominio.sj.backand.veiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long>{

	public List<Veiculo> findByPlacaContaining(String placa);



	@Query("select u from Veiculo u order by u.apv asc")
	public List<Veiculo> findAllApv();

}
