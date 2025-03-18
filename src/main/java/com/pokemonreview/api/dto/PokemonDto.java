package com.pokemonreview.api.dto;

import lombok.Getter;
import lombok.Setter;

public class PokemonDto {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String type;

//    public void setId(Long id) {
//        this.id = Math.toIntExact(id);
//    }

}
