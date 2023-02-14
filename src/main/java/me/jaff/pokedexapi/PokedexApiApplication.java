package me.jaff.pokedexapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PokedexApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexApiApplication.class, args);
    }

}
