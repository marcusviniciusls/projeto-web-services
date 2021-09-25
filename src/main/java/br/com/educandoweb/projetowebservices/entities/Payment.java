package br.com.educandoweb.projetowebservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Table
@Entity(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;

    public Payment (){}

    public Payment(Instant moment, Order order) {
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId().equals(payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
