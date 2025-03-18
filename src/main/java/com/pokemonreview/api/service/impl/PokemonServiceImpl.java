package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {
  private PokemonRepository pokemonRepository;
   @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);
        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
        return pokemonResponse;
    }

    @Override
    public List<PokemonDto> getAllPokemon() {
       List<Pokemon> pokemon = pokemonRepository.findAll();
       // map return a new list with the elements of the original list transformed by the lambda function
        return pokemon.stream().map(this::mapPokemonToPokemonDto).toList();
    }

    @Override
    public PokemonDto getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(Math.toIntExact(id)).orElseThrow();
        return mapPokemonToPokemonDto(pokemon);
    }

    @Override
    public PokemonDto updatePokemon(Long id, PokemonDto pokemonDto) {
        Pokemon pokemon = pokemonRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Pokemon not be updated"));
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        Pokemon updatedPokemon = pokemonRepository.save(pokemon);
        return mapPokemonToPokemonDto(updatedPokemon);
    }

    @Override
    public void deletePokemon(Long id) {
        Pokemon pokemon = pokemonRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Pokemon id not found"));
        pokemonRepository.delete(pokemon);
    }

    private PokemonDto mapPokemonToPokemonDto(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }

    private Pokemon mapPokemonDtoToPokemon(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDto.getId());
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        return pokemon;
    }
}
