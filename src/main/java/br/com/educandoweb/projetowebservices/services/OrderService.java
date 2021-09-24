package br.com.educandoweb.projetowebservices.services;

import br.com.educandoweb.projetowebservices.entities.Order;
import br.com.educandoweb.projetowebservices.entities.User;
import br.com.educandoweb.projetowebservices.repository.OrderRepository;
import br.com.educandoweb.projetowebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }
}
