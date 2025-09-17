package com.mundoFutebol.futeWorld.controller;

import com.mundoFutebol.futeWorld.dto.PartidasDTO;
import com.mundoFutebol.futeWorld.modelo.Partidas;
import com.mundoFutebol.futeWorld.repository.PartidasRepository;
import com.mundoFutebol.futeWorld.service.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @Autowired
    private PartidasService partidasService;
    @Autowired
    private PartidasRepository partidasRepository;

    @GetMapping
    public List<Partidas> listarPartidas(){
        return partidasService.listarJogos();
    }
    @PostMapping
    public ResponseEntity<PartidasDTO> criarPartida(@RequestBody PartidasDTO dto) {
        Partidas partidaSalva = partidasService.salvarPartidas(dto);

        PartidasDTO resposta = new PartidasDTO(
                partidaSalva.getId(),
                partidaSalva.getData(),
                partidaSalva.getTime1().getId(),
                partidaSalva.getTime2().getId(),
                partidaSalva.getTime1(),
                partidaSalva.getTime2(),
                partidaSalva.getGolsTime1(),
                partidaSalva.getGolsTime2()
        );
        return ResponseEntity.ok(resposta);
    }
    @DeleteMapping
    public ResponseEntity<Void> excluirTodasPartidas() {
        partidasRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
