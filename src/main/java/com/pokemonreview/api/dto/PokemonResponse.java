package com.pokemonreview.api.dto;

import lombok.Data;

import java.util.List;
@Data
public class PokemonResponse {
    private List<PokemonDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean last;

}
