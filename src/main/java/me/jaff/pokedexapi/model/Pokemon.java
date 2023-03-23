package me.jaff.pokedexapi.model;


import lombok.*;
import me.jaff.pokedexapi.dto.PokemonDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    private Integer pokemonId;

    private Integer pokedexId;
    @NotBlank(message = "Name is mandatory")
    private String pokemonName;
    @NotBlank(message = "Type is mandatory")
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
