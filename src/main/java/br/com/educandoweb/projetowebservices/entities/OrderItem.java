package br.com.educandoweb.projetowebservices.entities;

import br.com.educandoweb.projetowebservices.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK orderItemPK = new OrderItemPK();

    private Integer quatity;
    private Double price;

    public OrderItem(){}

    public OrderItem(Order order, Product product, Integer quatity, Double price) {
        this.quatity = quatity;
        this.price = price;
        this.orderItemPK.setOrder(order);
        this.orderItemPK.setProduct(product);
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return orderItemPK.getOrder();
    }

    public Product getProduct(){
        return orderItemPK.getProduct();
    }

    public void setOrder(Order order){
        orderItemPK.setOrder(order);
    }

    public void setProduct(Product product){
        orderItemPK.setProduct(product);
    }

    public Double getSubTotal(){
        return this.quatity * this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemPK.equals(orderItem.orderItemPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemPK);
    }


}
