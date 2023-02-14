package me.jaff.pokedexapi.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pokemon {
    @Id
    private Integer pokemonId;

    private Integer pokedexId;
    @NotBlank(message = "Name is mandatory")
    private String pokemonName;
    @NotBlank(message = "Type is mandatory")
    private String typeOne;
    private String typeTwo;
    private Integer total;
    private Integer healthPoints;
    private Integer attackPoints;
    private Integer defensePoints;
    private Integer attackSpeed;
    private Integer defenseSpeed;

    private Integer speed;
    private Integer generation;
    private Boolean isLegendary;

    public Pokemon(){

    }

    public Pokemon(Integer pokemonId, Integer pokedexId, String pokemonName, String typeOne, String typeTwo, Integer total, Integer healthPoints, Integer attackPoints, Integer defensePoints, Integer attackSpeed, Integer defenseSpeed, Integer speed, Integer generation, Boolean isLegendary) {
        this.pokemonId = pokemonId;
        this.pokedexId = pokedexId;
        this.pokemonName = pokemonName;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.total = total;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.attackSpeed = attackSpeed;
        this.defenseSpeed = defenseSpeed;
        this.speed = speed;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public Integer getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(Integer defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Integer getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(Integer attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public Integer getDefenseSpeed() {
        return defenseSpeed;
    }

    public void setDefenseSpeed(Integer defenseSpeed) {
        this.defenseSpeed = defenseSpeed;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Boolean getLegendary() {
        return isLegendary;
    }

    public void setLegendary(Boolean legendary) {
        isLegendary = legendary;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }
}
