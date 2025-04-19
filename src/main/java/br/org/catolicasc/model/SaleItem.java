package br.org.catolicasc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "sale_item")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idItem;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public SaleItem(){}

    public SaleItem(Sale sale, Product product){
        this.sale = sale;
        this.product = product;
    }
}
