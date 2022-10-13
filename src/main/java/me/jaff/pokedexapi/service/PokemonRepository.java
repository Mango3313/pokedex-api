package me.jaff.pokedexapi.service;

import me.jaff.pokedexapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository  extends JpaRepository<Pokemon,Integer> {
    public Optional<List<Pokemon>> findByPokedexId(Integer pokedexId);
}
