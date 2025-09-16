package com.mundoFutebol.futeWorld.controller;

import com.mundoFutebol.futeWorld.dto.JogadoresDTO;
import com.mundoFutebol.futeWorld.modelo.Jogadores;
import com.mundoFutebol.futeWorld.modelo.Posicao;
import com.mundoFutebol.futeWorld.modelo.Times;
import com.mundoFutebol.futeWorld.repository.JogadoresRepository;
import com.mundoFutebol.futeWorld.service.JogadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadoresController {
    @Autowired
    private JogadoresService jogadoresService;
    @Autowired
    private JogadoresRepository jogadoresRepository;

    @PostMapping
    public ResponseEntity<JogadoresDTO> criarJogador(@RequestBody JogadoresDTO jogadoresDTO){
        Jogadores jogadoresSalvos = jogadoresService.salvarJogador(jogadoresDTO);

        JogadoresDTO jogadoresDTO1 = new JogadoresDTO(
                jogadoresSalvos.getId(),
                jogadoresSalvos.getNome(),
                jogadoresSalvos.getPosicao(),
                jogadoresSalvos.getIdade(),
                jogadoresSalvos.getTimes()
        );
        return ResponseEntity.ok(jogadoresDTO1);
    }
    @GetMapping
    public List<JogadoresDTO> mostrarJogadores(){
        return jogadoresService.listarJogadores();
    }
    @GetMapping("/buscarPorNome/{nome}")
    public List<Jogadores> buscarPorTime(@PathVariable String nome){
        return jogadoresRepository.findByNomeIgnoreCase(nome);
    }
    @GetMapping("/posicao/{posicao}")
    public List<Jogadores> buscarPosicao(@PathVariable Posicao posicao){
        return jogadoresRepository.findByPosicao(posicao);
    }
    @GetMapping("/id/{id}")
    public Optional<Jogadores> buscarId(@PathVariable long id){
        return jogadoresRepository.findById(id);
    }

    @DeleteMapping
    public void deletarJogadores(){
        jogadoresService.deletar();
    }

}
