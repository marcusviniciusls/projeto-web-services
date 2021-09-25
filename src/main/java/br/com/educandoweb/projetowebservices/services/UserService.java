package br.com.educandoweb.projetowebservices.services;

import br.com.educandoweb.projetowebservices.entities.User;
import br.com.educandoweb.projetowebservices.repository.UserRepository;
import br.com.educandoweb.projetowebservices.services.exceptions.DatabaseException;
import br.com.educandoweb.projetowebservices.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User user){
        try{
            User entity = userRepository.getById(id);
            updateData(entity,user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourcesNotFoundException(id);
        }

    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
