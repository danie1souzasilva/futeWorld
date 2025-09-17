package com.mundoFutebol.futeWorld.controller;

import com.mundoFutebol.futeWorld.dto.TimesDTO;
import com.mundoFutebol.futeWorld.modelo.Times;
import com.mundoFutebol.futeWorld.repository.JogadoresRepository;
import com.mundoFutebol.futeWorld.repository.TimeRepository;
import com.mundoFutebol.futeWorld.service.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimesController {

    @Autowired
    private TimesService timesService;
    @Autowired
    private JogadoresRepository jogadoresRepository;
    @Autowired
    private TimeRepository timeRepository;


    @PostMapping
    public Times salvarTime(@RequestBody TimesDTO timesDTO) {
        return timesService.salvarTimes(timesDTO);
    }
    @GetMapping("/nomeTimes")
    public List<Times>listarTimes(){
        return timesService.listarTimes();
    }
    @GetMapping("/buscaPorPais/{pais}")
    public List<Times> buscaPorPais(@PathVariable String pais){
        return timeRepository.findByPaisIgnoreCase(pais);
    }
    @GetMapping("/buscaPorNome/{nome}")
    public List<Times> buscaPorNome(@PathVariable String nome){
        return timeRepository.findByNomeIgnoreCase(nome);
    }
}
