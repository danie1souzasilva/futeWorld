package com.mundoFutebol.futeWorld.service;

import com.mundoFutebol.futeWorld.dto.JogadoresDTO;
import com.mundoFutebol.futeWorld.modelo.Jogadores;
import com.mundoFutebol.futeWorld.repository.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JogadoresService {
    @Autowired
    private JogadoresRepository jogadoresRepository;

    public Jogadores salvarJogador(JogadoresDTO jogadoresDTO){
        Jogadores jogador = new Jogadores();
        jogador.setNome(jogadoresDTO.nome());
        jogador.setIdade(jogadoresDTO.idade());
        jogador.setPosicao(jogadoresDTO.posicao());
        jogador.setId(jogadoresDTO.id());
        jogador.setTimes(jogadoresDTO.times());

        return jogadoresRepository.save(jogador);
    }
    public List<JogadoresDTO> listarJogadores() {
        return jogadoresRepository.findAll().stream()
                .map(j -> new JogadoresDTO(j.getId(), j.getNome(), j.getPosicao(), j.getIdade(), j.getTimes()))
                .toList();
    }
    public void deletar(){
        jogadoresRepository.deleteAll();
    }

}
