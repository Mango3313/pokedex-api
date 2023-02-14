package me.jaff.pokedexapi.util;

import me.jaff.pokedexapi.dto.PokemonDto;
import me.jaff.pokedexapi.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonMapper {


    PokemonDto toDto(Pokemon pokemon);
    Pokemon toEntity(PokemonDto pokemonDto);
}
