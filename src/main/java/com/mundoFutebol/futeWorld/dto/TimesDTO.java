package com.mundoFutebol.futeWorld.dto;

import java.util.List;

public record TimesDTO(
        Long id,
        String nome,
        String pais,
        List<JogadoresDTO> jogadores
) {
}
