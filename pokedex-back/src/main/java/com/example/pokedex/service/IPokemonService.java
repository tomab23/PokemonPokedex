package com.example.pokedex.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.pokedex.core.domain.Pokemon;

public interface IPokemonService {

	List<Pokemon> getAllPokemons();

	Pokemon getPokemon(long id);

	Page<Pokemon> getAllPokemons(int page);

//	List<Pokemon> findPokemonByType(String type);

	List<Pokemon> findPokemonByName(String q);

	Pokemon savePokemon(Pokemon pokemon);

	void deletePokemon(long id);

}
