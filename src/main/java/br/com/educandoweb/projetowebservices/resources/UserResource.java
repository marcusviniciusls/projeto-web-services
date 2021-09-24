package br.com.educandoweb.projetowebservices.resources;

import br.com.educandoweb.projetowebservices.entities.User;
import br.com.educandoweb.projetowebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> listUser = userServices.findAll();
        return ResponseEntity.ok().body(listUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
