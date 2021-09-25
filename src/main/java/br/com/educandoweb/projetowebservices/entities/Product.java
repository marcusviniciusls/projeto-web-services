package br.com.educandoweb.projetowebservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;

    @ManyToOne
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "orderItemPK.product")
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Product(String name, String description, BigDecimal price, String imgUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        category.addListProduct(this);
    }

    public Product(){}

    @JsonIgnore
    public List<Order> getOrders(){
        List<Order> list = new ArrayList<>();
        for(OrderItem x : items){
            list.add(x.getOrder());
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
