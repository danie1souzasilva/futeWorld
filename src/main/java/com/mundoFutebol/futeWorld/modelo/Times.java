package com.mundoFutebol.futeWorld.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Times")
@Data
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String pais;

    public Times() {
    }
    public Times(Long id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }
    @OneToMany(mappedBy = "times")
    @JsonManagedReference
    private List<Jogadores> jogadores;


}
