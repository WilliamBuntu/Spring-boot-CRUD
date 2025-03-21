package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {
  PokemonDto createPokemon(PokemonDto pokemonDto);
  PokemonResponse getAllPokemon(int pageNo, int PageSize);
  PokemonDto getPokemonById(Long id);
  PokemonDto updatePokemon(Long id, PokemonDto pokemonDto);
  void deletePokemon(Long id);
}
