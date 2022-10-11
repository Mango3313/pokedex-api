package me.jaff.pokedexapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<String> mainEndpoint(){
        return new ResponseEntity<>("Welcome to Pokedex API!", HttpStatus.OK);
    }
}
