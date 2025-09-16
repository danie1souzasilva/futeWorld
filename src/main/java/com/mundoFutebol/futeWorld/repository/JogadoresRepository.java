package com.mundoFutebol.futeWorld.repository;

import com.mundoFutebol.futeWorld.modelo.Jogadores;
import com.mundoFutebol.futeWorld.modelo.Posicao;
import com.mundoFutebol.futeWorld.modelo.Times;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadoresRepository extends JpaRepository<Jogadores, Long> {
    List<Jogadores> findByNomeIgnoreCase(String nome);
    List<Jogadores> findByPosicao(Posicao posicao);
}
