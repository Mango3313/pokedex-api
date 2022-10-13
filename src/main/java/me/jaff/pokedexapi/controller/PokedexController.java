package me.jaff.pokedexapi.controller;

import me.jaff.pokedexapi.dto.Pokedex;
import me.jaff.pokedexapi.model.BaseResponse;
import me.jaff.pokedexapi.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    private final Pokedex pokedex;

    @Autowired
    public PokedexController(Pokedex pokedex){
        this.pokedex = pokedex;
    }

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse> getAllPokemons(){
        return new ResponseEntity<>(pokedex.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<BaseResponse> getPokemonById(@PathVariable Integer id) throws Exception {
            return new ResponseEntity<>(pokedex.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createPokemon(@RequestBody Pokemon pokemon){
        return new ResponseEntity<>(pokedex.insertPokemon(pokemon),HttpStatus.OK);
    }
}
