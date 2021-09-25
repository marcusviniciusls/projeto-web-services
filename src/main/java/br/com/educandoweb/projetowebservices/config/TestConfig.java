package br.com.educandoweb.projetowebservices.config;

import br.com.educandoweb.projetowebservices.entities.*;
import br.com.educandoweb.projetowebservices.entities.enums.OrderStatus;
import br.com.educandoweb.projetowebservices.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("MARCUS VINICIUS LIMA SILVA","viniciusmls@outlook.com","11993527709","12345");
        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order = new Order(Instant.parse("2021-04-20T21:53:07Z"),user, OrderStatus.PAID);
        Order order1 = new Order(Instant.parse("2021-04-20T21:53:07Z"),user, OrderStatus.CANCELED);
        Order order2 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u1, OrderStatus.SHIPPED);
        Order order3 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u2, OrderStatus.SHIPPED);
        Order order4 = new Order(Instant.parse("2021-04-20T21:53:07Z"),u2,OrderStatus.DELIVERED);

        Category category = new Category("Electronic");
        Category category1 = new Category("Mobile");
        Category category2 = new Category("Books");
        Category category3 = new Category("Construction");
        Category category4 = new Category("Computer");

        Product p = new Product("The Lord of the Rings","Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("90.5"),"",category2);
        Product p1 = new Product("Smart TV","Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("150.90"),"", category);
        Product p2 = new Product("Macbook Pro","Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("5.00"),"", category4);
        Product p3 = new Product("PC Gamer","Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("450.99"),"", category);
        Product p4 = new Product("Rails for Dummies","Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("58.7"),"", category3);

        OrderItem oi1 = new OrderItem(order,p,2,230.00);
        OrderItem oi2 = new OrderItem(order,p1,7,650.00);
        OrderItem oi3 = new OrderItem(order,p2,1,340.00);
        OrderItem oi4 = new OrderItem(order,p3,3,760.00);
        OrderItem oi5 = new OrderItem(order,p4,6,120.00);

        userRepository.saveAll(Arrays.asList(user, u1,u2));
        orderRepository.saveAll(Arrays.asList(order,order1,order2,order3,order4));
        categoryRepository.saveAll(Arrays.asList(category, category1,category3,category2,category4));
        productRepository.saveAll(Arrays.asList(p,p1,p2,p3,p4));
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5));

        Payment payment = new Payment(Instant.parse("2021-04-20T21:53:07Z"), order);
        order.setPayment(payment);

        orderRepository.save(order);
    }
}
