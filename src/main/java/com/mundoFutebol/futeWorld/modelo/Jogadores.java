package com.mundoFutebol.futeWorld.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Jogadores")
@Data
public class Jogadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public Posicao posicao;
    public  Integer idade;

    public Jogadores() {
    }

    public Jogadores(Long id, String nome, Posicao posicao, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
    }
    @ManyToOne
    @JsonBackReference
    private Times times;
}
