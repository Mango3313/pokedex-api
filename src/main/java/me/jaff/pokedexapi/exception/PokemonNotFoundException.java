package me.jaff.pokedexapi.exception;

public class PokemonNotFoundException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7537439253962676903L;

	public PokemonNotFoundException(){
        super("Pokemon not found!");
    }
}
