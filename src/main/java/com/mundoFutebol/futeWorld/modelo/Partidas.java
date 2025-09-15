package com.mundoFutebol.futeWorld.modelo;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity(name = "Partidas")
@Data
public class Partidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private LocalDate data;
    private Integer golsTime1;
    private Integer golsTime2;

    public Partidas() {
    }
    public Partidas(Long id, LocalDate data, Integer golsTime1, Integer golsTime2, Times time1, Times time2) {
        this.id = id;
        this.data = data;
        this.golsTime1 = golsTime1;
        this.golsTime2 = golsTime2;
        this.time1 = time1;
        this.time2 = time2;
    }
    @ManyToOne
    @JoinColumn(name = "time1_id")
    private Times time1;

    @ManyToOne
    @JoinColumn(name = "time2_id")
    private Times time2;


}
