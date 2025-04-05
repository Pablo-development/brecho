package br.org.catolicasc.autocat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> vendaList;

    private LocalDateTime dateTime;

    public Venda(){
        this.dateTime = LocalDateTime.now();
        this.vendaList = new ArrayList<>();
    }
}
