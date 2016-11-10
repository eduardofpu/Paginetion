package org.condominio.sj.backand.agendamento;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{


	public List<Agendamento> findByUserAgenda(UserEntity userAgenda);

	@Query("select u from Agendamento u order by u.data desc")
	public List<Agendamento> findAllData();

	public List<Agendamento>findByEmpresaContaining(String empresa) ;


}
