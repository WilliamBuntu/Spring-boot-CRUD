package com.pokemonreview.api.dto;

public class PokemonDto {
    private int id;
    private String name;
    private String type;

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
