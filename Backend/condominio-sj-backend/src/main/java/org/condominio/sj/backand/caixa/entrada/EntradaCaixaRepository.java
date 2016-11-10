package org.condominio.sj.backand.caixa.entrada;

import java.util.List;

import org.condominio.sj.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaCaixaRepository extends JpaRepository<EntradaCaixa,Long>{

	public List<EntradaCaixa>findByGerente(UserEntity gerente);

}
