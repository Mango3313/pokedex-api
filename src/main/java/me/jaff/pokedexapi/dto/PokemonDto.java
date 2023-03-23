package me.jaff.pokedexapi.dto;

import lombok.*;
import me.jaff.pokedexapi.model.Pokemon;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PokemonDto {

    private Integer pokemonId;

    private Integer pokedexId;
    private String pokemonName;
    private String typeOne;
    private String typeTwo;
    private Integer total;
    private Integer healthPoints;
    private Integer attackPoints;
    private Integer defensePoints;
    private Integer attackSpeed;
    private Integer defenseSpeed;

    private Integer speed;
    private Integer generation;
    private Boolean isLegendary;
}
