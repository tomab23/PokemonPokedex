package com.example.pokedex.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.pokedex.core.domain.Pokemon;
import com.example.pokedex.core.domain.Type;
import com.example.pokedex.dto.PokemonDTO;

public class PokemonMapper {

	/**
	 * 
	 * @param pokemon
	 * @return PokemonDTO
	 */
	public static PokemonDTO pokemonToDto(Pokemon pokemon) {
		PokemonDTO dto = new PokemonDTO();

		dto.setId(pokemon.getId());
		dto.setName(pokemon.getName());
		dto.setHp(pokemon.getHp());
		dto.setCp(pokemon.getCp());
		dto.setPicture(pokemon.getPicture());

			List<Short> types = new ArrayList<>();
			for (Type t : pokemon.getTypes()) {
				types.add(t.getId());
			}

			dto.setTypes(types);

		return dto;
	}

	/**
	 * 
	 * @param pokemonDTO
	 * @return Pokemon entity
	 */
	public static Pokemon toEntity(PokemonDTO pokemon) {
		Pokemon poke = new Pokemon();

		poke.setId(pokemon.getId());
		poke.setName(pokemon.getName());
		poke.setCp(pokemon.getCp());
		poke.setHp(pokemon.getHp());
		poke.setPicture(pokemon.getPicture());

		for (Short type : pokemon.getTypes()) {
			poke.addType(new Type(type));
		}

		return poke;
	}

	/**
	 * 
	 * @param pokemons, list of Pokemon
	 * @return list of PokemonDTO
	 */
	public static List<PokemonDTO> pokemonsToDto(List<Pokemon> pokemons) {
		List<PokemonDTO> dtos = null;

		if (pokemons != null && !pokemons.isEmpty()) {
			dtos = new ArrayList<PokemonDTO>();
			for (Pokemon p : pokemons) {
				dtos.add(pokemonToDto(p));
			}
		}

		return dtos;
	}

}
