package br.com.educandoweb.projetowebservices.repository;

import br.com.educandoweb.projetowebservices.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
