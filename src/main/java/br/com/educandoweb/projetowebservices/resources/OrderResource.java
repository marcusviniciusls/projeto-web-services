package br.com.educandoweb.projetowebservices.resources;

import br.com.educandoweb.projetowebservices.entities.Order;
import br.com.educandoweb.projetowebservices.entities.User;
import br.com.educandoweb.projetowebservices.repository.OrderRepository;
import br.com.educandoweb.projetowebservices.services.OrderService;
import br.com.educandoweb.projetowebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> listOrder = orderService.findAll();
        return ResponseEntity.ok().body(listOrder);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
