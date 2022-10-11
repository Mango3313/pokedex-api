package me.jaff.pokedexapi.service;

import me.jaff.pokedexapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository  extends JpaRepository<Pokemon,Integer> {
}
