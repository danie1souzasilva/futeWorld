package com.mundoFutebol.futeWorld.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mundoFutebol.futeWorld.modelo.Times;

import java.time.LocalDate;

public record PartidasDTO (
        @JsonProperty @JsonIgnore Long id,
        @JsonProperty @JsonIgnore LocalDate data,
        @JsonProperty @JsonIgnore Long time1Id,
        @JsonProperty @JsonIgnore Long time2Id,
        @JsonProperty Times time1,
        @JsonProperty Times time2,
        @JsonProperty Integer golsTime1,
        @JsonProperty Integer golsTime2
){
}
