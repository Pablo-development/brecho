package br.org.catolicasc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> SaleItemList;

    private LocalDateTime dateTime;

    public Sale(){
        this.dateTime = LocalDateTime.now();
        this.SaleItemList = new ArrayList<>();
    }
}
