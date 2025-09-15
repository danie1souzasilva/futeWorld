package com.mundoFutebol.futeWorld.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mundoFutebol.futeWorld.modelo.Posicao;
import com.mundoFutebol.futeWorld.modelo.Times;

public record JogadoresDTO(
        @JsonProperty Long id,
        @JsonProperty String nome,
        @JsonProperty Posicao posicao,
        @JsonProperty Integer idade,
        @JsonProperty Times times
) {
}
