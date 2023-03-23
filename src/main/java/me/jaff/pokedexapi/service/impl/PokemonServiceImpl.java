package me.jaff.pokedexapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import me.jaff.pokedexapi.dto.PokemonDto;
import me.jaff.pokedexapi.util.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.Pokemon;
import me.jaff.pokedexapi.repositories.PokemonRepository;
import me.jaff.pokedexapi.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

@Autowired
private PokemonRepository pokemonRepository;
@Autowired
private PokemonMapper pokemonMapper;

    @Override
    public List<PokemonDto> getAllPokemons() {
        List<PokemonDto> allPokemon = new ArrayList<>();
        pokemonRepository.findAll().iterator().forEachRemaining(
                (pokemon)->{allPokemon.add(pokemonMapper.toDto(pokemon));});
        return allPokemon;
    }

    @Override
    public PokemonDto getPokemonById(Integer idInteger) throws PokemonNotFoundException {
        Optional<Pokemon> pokemon = pokemonRepository.findById(idInteger);
        return pokemonMapper.toDto(pokemon.orElseThrow(()->new PokemonNotFoundException()));
    }

    @Override
    public String createPokemon(PokemonDto pokemonDto) {
        Pokemon toBeSavedPokemon = pokemonMapper.toEntity(pokemonDto);
        Optional<PokemonDto> savedPokemon = Optional.of(
                pokemonMapper.toDto(pokemonRepository.save(toBeSavedPokemon)));
        return String.format("%b",savedPokemon.isPresent());
    }

    @Override
    public void deletePokemon(PokemonDto pokemon) {
        pokemonRepository.delete(pokemonMapper.toEntity(pokemon));
    }
}
