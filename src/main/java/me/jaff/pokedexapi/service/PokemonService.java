package me.jaff.pokedexapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.Pokemon;

@Service
public interface PokemonService {
    public List<Pokemon> getAllPokemons();
    public Pokemon getPokemonById(Integer idInteger) throws PokemonNotFoundException;
    public String createPokemon(Pokemon pokemon);
}
