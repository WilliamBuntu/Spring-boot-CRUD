package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    private PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getPokemons(
            @RequestParam(value = "pageNo",defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false) int pageSize
    ){

      return new ResponseEntity<>(pokemonService.getAllPokemon(pageNo,pageSize), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDto> pokemonDetail(@PathVariable int id){

        return ResponseEntity.ok(pokemonService.getPokemonById((long) id));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){

        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable ("id") int pokemonId, @RequestBody PokemonDto pokemonDto){
       PokemonDto response = pokemonService.updatePokemon((long) pokemonId, pokemonDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable int id){
        pokemonService.deletePokemon((long) id);
        return new ResponseEntity<>("Pokemon with id "+id+" has been deleted", HttpStatus.OK);
    }
}
