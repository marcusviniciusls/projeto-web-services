package br.com.educandoweb.projetowebservices.repository;

import br.com.educandoweb.projetowebservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
