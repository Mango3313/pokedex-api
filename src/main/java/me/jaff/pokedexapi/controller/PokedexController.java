package me.jaff.pokedexapi.controller;

import me.jaff.pokedexapi.dto.Pokedex;
import me.jaff.pokedexapi.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {
    private final Pokedex pokedex;

    @Autowired
    public PokedexController(Pokedex pokedex){
        this.pokedex = pokedex;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) throws Exception {
            return new ResponseEntity<>(pokedex.findById(id), HttpStatus.OK);
    }
}
