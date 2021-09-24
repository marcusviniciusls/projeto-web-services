package br.com.educandoweb.projetowebservices.repository;

import br.com.educandoweb.projetowebservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
