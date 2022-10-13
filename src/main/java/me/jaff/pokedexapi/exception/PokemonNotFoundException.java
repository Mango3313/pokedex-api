package me.jaff.pokedexapi.exception;

public class PokemonNotFoundException extends Exception{
    public PokemonNotFoundException(){
        super("Pokemon not found!");
    }
}
