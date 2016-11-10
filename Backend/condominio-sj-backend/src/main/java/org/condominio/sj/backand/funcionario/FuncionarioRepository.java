package org.condominio.sj.backand.funcionario;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


//para buscar o nome da imagem
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public  List<Funcionario> findByFuncionarioContaining(String funcionario);


}
