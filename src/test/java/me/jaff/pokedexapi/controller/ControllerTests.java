package me.jaff.pokedexapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jaff.pokedexapi.dto.PokemonDto;
import me.jaff.pokedexapi.exception.PokemonNotFoundException;
import me.jaff.pokedexapi.model.BaseResponse;
import me.jaff.pokedexapi.service.PokemonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(PokedexController.class)
public class ControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PokemonService pokedex;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testGetAllPokemons() throws Exception {
        List<PokemonDto> pokemonList = new ArrayList<>();
        when(pokedex.getAllPokemons()).thenReturn(pokemonList);

        mockMvc.perform(get("/pokedex/get-all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }
    @Test
    public void testGetPokemonById() throws Exception {
        PokemonDto pokemon = new PokemonDto();
        pokemon.setPokemonId(1);
        when(pokedex.getPokemonById(1)).thenReturn(pokemon);

        mockMvc.perform(get("/pokedex/get-by-id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.data.pokemonId").value("1"));
    }
    @Test
    public void testGetNonExistentPokemonById() throws Exception {
        when(pokedex.getPokemonById(1000)).thenThrow(new PokemonNotFoundException());

        mockMvc.perform(get("/pokedex/get-by-id/1000"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.data").doesNotExist());
    }
    @Test
    public void testCreatePokemon() throws Exception {
        PokemonDto pokemon = new PokemonDto();
        String booleanStringPokemonCreated = "true";
        when(pokedex.createPokemon(pokemon)).thenReturn(booleanStringPokemonCreated);

        mockMvc.perform(post("/pokedex/create")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(pokemon)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testDeletePokemon() throws Exception {

        mockMvc.perform(delete("/pokedex/delete")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(new PokemonDto())))
                .andExpect(status().isOk());
    }
}
