package com.mundoFutebol.futeWorld.service;

import com.mundoFutebol.futeWorld.dto.JogadoresDTO;
import com.mundoFutebol.futeWorld.modelo.Jogadores;
import com.mundoFutebol.futeWorld.repository.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadoresService {
    @Autowired
    private JogadoresRepository jogadoresRepository;

    public JogadoresService(JogadoresRepository jogadoresRepository) {
        this.jogadoresRepository = jogadoresRepository;
    }
    public Jogadores salvarJogador(JogadoresDTO jogadoresDTO){
        Jogadores jogador = new Jogadores();
        jogador.setNome(jogadoresDTO.nome());
        jogador.setIdade(jogadoresDTO.idade());
        jogador.setPosicao(jogadoresDTO.posicao());
        jogador.setId(jogadoresDTO.id());
        jogador.setTimes(jogadoresDTO.times());

        return jogadoresRepository.save(jogador);
    }
}
