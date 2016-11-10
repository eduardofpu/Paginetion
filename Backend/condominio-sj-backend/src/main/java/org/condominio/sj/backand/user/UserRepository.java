package org.condominio.sj.backand.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmailAndPassword(String email,String password);

	public List<UserEntity> findByEmailOrName(String email, String name);

	public UserEntity findByEmail(String email);

	public List<UserEntity> findById(Long user);

}
