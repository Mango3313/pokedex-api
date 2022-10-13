package me.jaff.pokedexapi.dto;

import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.BaseResponse;
import me.jaff.pokedexapi.model.Pokemon;
import me.jaff.pokedexapi.service.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class Pokedex {

    private final PokemonRepository pokeRepo;

    @Autowired
    public Pokedex(PokemonRepository pokeRepo){
        this.pokeRepo = pokeRepo;
    }

    public BaseResponse getAll(){
        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK.value(),HttpStatus.OK.toString(),
                "/pokedex/getAll", pokeRepo.findAll());
        return baseResponse;
    }
    public BaseResponse findById(Integer id) throws Exception {
        Optional<List<Pokemon>> queryResult = pokeRepo.findByPokedexId(id);
        if(queryResult.isEmpty()){
            throw new PokemonNotFoundException();
        }
        return new BaseResponse(HttpStatus.OK.value(),HttpStatus.OK.toString(),"/pokedex/getById/"+id,
                queryResult.get());
    }

    public BaseResponse insertPokemon(Pokemon pokemon){
        pokeRepo.save(pokemon);
        return new BaseResponse(HttpStatus.OK.value(),HttpStatus.CREATED.toString(), "/pokedex/create",
                Arrays.asList(pokemon));
    }
}
