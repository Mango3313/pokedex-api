package me.jaff.pokedexapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.Pokemon;
import me.jaff.pokedexapi.repositories.PokemonRepository;
import me.jaff.pokedexapi.service.PokemonService;

public class PokemonServiceImpl implements PokemonService {

@Autowired
private PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon getPokemonById(Integer idInteger) throws PokemonNotFoundException {
        Optional<Pokemon> pokemon = pokemonRepository.findById(idInteger);
        if(pokemon.isEmpty()) throw new PokemonNotFoundException();
        return pokemon.get();
    }

    @Override
    public String createPokemon(Pokemon pokemon) {
        return null;
    }
     
}
