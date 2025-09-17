package com.mundoFutebol.futeWorld.controller;

import com.mundoFutebol.futeWorld.dto.TimeDTO;
import com.mundoFutebol.futeWorld.dto.TimesDTO;
import com.mundoFutebol.futeWorld.modelo.Times;
import com.mundoFutebol.futeWorld.repository.JogadoresRepository;
import com.mundoFutebol.futeWorld.repository.TimeRepository;
import com.mundoFutebol.futeWorld.service.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
    public Times salvarTime(@RequestBody TimesDTO timesDTO) {return timesService.salvarTimes(timesDTO);
    }
    @GetMapping("/nomeTimes")
    public List<Times> listarTimes(){return timesService.listarTimes();
    }
    @GetMapping("/buscaPorPais/{pais}")
    public List<TimeDTO> buscaPorPais(@PathVariable String pais){return timeRepository.findByPaisIgnoreCase(pais).stream().map(t -> new TimeDTO(t.getNome(), t.getPais())).toList();
    }
    @GetMapping("/buscaPorNome/{nome}")
    public List<TimeDTO> buscaPorNome(@PathVariable String nome){return timeRepository.findByNomeIgnoreCase(nome).stream().map(n -> new TimeDTO(n.getNome(), n.getPais())).toList();
    }
}
