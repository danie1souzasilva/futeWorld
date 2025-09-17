package com.mundoFutebol.futeWorld.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Times")
@Data
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long id;
    public String nome;
    @JsonIgnore
    public String pais;

    public Times() {
    }
    public Times(Long id, String nome, String pais) {this.id = id; this.nome = nome; this.pais = pais;
    }
    @OneToMany(mappedBy = "times")
    @JsonManagedReference
    @JsonIgnore
    private List<Jogadores> jogadores;


}
