package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
  PokemonDto createPokemon(PokemonDto pokemonDto);
  List<PokemonDto> getAllPokemon();
  PokemonDto getPokemonById(Long id);
  PokemonDto updatePokemon(Long id, PokemonDto pokemonDto);
  void deletePokemon(Long id);
}
