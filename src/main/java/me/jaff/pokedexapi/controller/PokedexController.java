package me.jaff.pokedexapi.controller;
import me.jaff.pokedexapi.model.BaseResponse;
import me.jaff.pokedexapi.model.Pokemon;
import me.jaff.pokedexapi.service.PokemonService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokemonService pokedex;

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse> getAllPokemons(HttpServletRequest request){
        return new ResponseEntity<>(new BaseResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase()
        		,request.getRequestURI(),pokedex.getAllPokemons()),HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<BaseResponse> getPokemonById(HttpServletRequest request,
    		@PathVariable Integer id) throws Exception {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.OK.value(),
            		HttpStatus.OK.getReasonPhrase(),request.getRequestURI(),
            		pokedex.getPokemonById(id)),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createPokemon(HttpServletRequest request,
    		@RequestBody Pokemon pokemon){
        return new ResponseEntity<>(new BaseResponse(HttpStatus.OK.value(),
        		HttpStatus.OK.getReasonPhrase(),request.getRequestURI(),
        		pokedex.createPokemon(pokemon)),HttpStatus.OK);
        
    }
}
