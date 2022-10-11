package me.jaff.pokedexapi.dto;

import me.jaff.pokedexapi.model.Pokemon;
import me.jaff.pokedexapi.service.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Pokedex {

    private final PokemonRepository pokeRepo;

    @Autowired
    public Pokedex(PokemonRepository pokeRepo){
        this.pokeRepo = pokeRepo;
    }
    public Pokemon findById(Integer id) throws Exception {
        Optional<Pokemon> queryResult = pokeRepo.findById(id);
        if(queryResult.isEmpty()){
            throw new Exception("Pokemon not found");
        }
        return queryResult.get();
    }
}
