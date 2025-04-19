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

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(Double price, int quantity, Category category) {
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product() {}

    public boolean hasStock(int quantity) {
        return this.quantity >= quantity;
    }

    public void increaseStock(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseStock(int quantity) {
        this.quantity -= quantity;
    }
}