package me.jaff.pokedexapi.repositories;

import me.jaff.pokedexapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository  extends CrudRepository<Pokemon,Integer> {
}
