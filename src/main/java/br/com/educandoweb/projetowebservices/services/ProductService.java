package br.com.educandoweb.projetowebservices.services;

import br.com.educandoweb.projetowebservices.entities.Category;
import br.com.educandoweb.projetowebservices.entities.Product;
import br.com.educandoweb.projetowebservices.repository.CategoryRepository;
import br.com.educandoweb.projetowebservices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }
}
