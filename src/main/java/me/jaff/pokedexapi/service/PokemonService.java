package me.jaff.pokedexapi.service;

import java.util.List;

import me.jaff.pokedexapi.dto.PokemonDto;
import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.Pokemon;

public interface PokemonService {
    public List<PokemonDto> getAllPokemons();
    public PokemonDto getPokemonById(Integer idInteger) throws PokemonNotFoundException;
    public String createPokemon(PokemonDto pokemon);

    public void deletePokemon(PokemonDto pokemon);
}
