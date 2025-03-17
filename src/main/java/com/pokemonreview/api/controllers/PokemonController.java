package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.PokemonDto;
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
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Pikachu", "Electric"));
        pokemons.add(new Pokemon(2, "Charmander", "Fire"));
        pokemons.add(new Pokemon(3, "Squirtle", "Water"));
        pokemons.add(new Pokemon(4, "Bulbasaur", "Grass"));
        pokemons.add(new Pokemon(5, "Jigglyp", "Normal"));
      return ResponseEntity.ok().body(pokemons);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDetail(@PathVariable int id){
        return new Pokemon(id, "puskas", "Electric");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){

        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable ("id") int pokemonId, @RequestBody Pokemon pokemon){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }
    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable int id){
        return new ResponseEntity<>("Pokemon with id "+id+" has been deleted", HttpStatus.OK);
    }
}
