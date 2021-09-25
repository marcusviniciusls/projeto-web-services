package br.com.educandoweb.projetowebservices.resources;

import br.com.educandoweb.projetowebservices.entities.Category;
import br.com.educandoweb.projetowebservices.entities.Product;
import br.com.educandoweb.projetowebservices.services.CategoryService;
import br.com.educandoweb.projetowebservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
