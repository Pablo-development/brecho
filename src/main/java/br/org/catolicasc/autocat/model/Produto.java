package br.org.catolicasc.autocat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long preco;
    private int quantidade;

    public Produto(Long preco, int quantidade){
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {}
}
