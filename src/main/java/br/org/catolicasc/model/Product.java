package br.org.catolicasc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double price;
    private int quantity;

    public Product(Double price, int quantity){
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {}

    public boolean hasStock(int quantity){
        return this.quantity >= quantity;
    }

    public void increaseStock(int quantity){
        this.quantity += quantity;
    }

    public void decreaseStock(int quantity){
        this.quantity -= quantity;
    }
}
