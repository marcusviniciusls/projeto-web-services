package br.com.educandoweb.projetowebservices.config;

import br.com.educandoweb.projetowebservices.entities.Order;
import br.com.educandoweb.projetowebservices.entities.User;
import br.com.educandoweb.projetowebservices.repository.OrderRepository;
import br.com.educandoweb.projetowebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("MARCUS VINICIUS LIMA SILVA","viniciusmls@outlook.com","11993527709","12345");
        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order = new Order(Instant.parse("2021-04-20T21:53:07Z"),user);
        Order order1 = new Order(Instant.parse("2021-04-20T21:53:07Z"),user);
        Order order2 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u1);
        Order order3 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u2);
        Order order4 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u2);

        userRepository.saveAll(Arrays.asList(user, u1,u2));
        orderRepository.saveAll(Arrays.asList(order,order1,order2,order3,order4));
    }
}
