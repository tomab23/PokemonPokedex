package com.example.pokedex.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pokedex.core.domain.Pokemon;
import com.example.pokedex.core.domain.Type;
import com.example.pokedex.core.repository.IPokemonRepository;
import com.example.pokedex.core.repository.ITypeRepository;
import com.example.pokedex.service.IPokemonService;

@Service("PokemonService")
public class PokemonService implements IPokemonService {

	@Autowired
	private IPokemonRepository pokemonRepo;

	@Autowired
	private ITypeRepository typeRepo;


	@Override
	public List<Pokemon> getAllPokemons() {
		return pokemonRepo.findAll();
	}

	@Override
	public Pokemon getPokemon(long id) {
		return pokemonRepo.getReferenceById(id);
	}

	@Override
	public Page<Pokemon> getAllPokemons(int page) {
		return pokemonRepo.findAll(PageRequest.of(page, 12));
	}


//	@Override
//	public List<Pokemon> findPokemonByType(String type) {
//		return pokemonRepo.findPokemonBytype(type);
//	}

	@Override
	public List<Pokemon> findPokemonByName(String q) {
		return pokemonRepo.findByNameContaining(q);
	}

//	@Override
//	public Pokemon savePokemon(Pokemon pokemon) {
//		return pokemonRepo.saveAndFlush(pokemon);
//	}

	@Override
	public Pokemon savePokemon(Pokemon pokemon) {
		// get types from DB
		List<Short> idType = new ArrayList<>();
		for (Type t : pokemon.getTypes()) {
			idType.add(t.getId());
		}
		List<Type> types = typeRepo.findAllById(idType);

		pokemon.setTypes(types);

		return pokemonRepo.saveAndFlush(pokemon);
	}

	@Override
	public void deletePokemon(long id) {
		pokemonRepo.deleteById(id);
	}


}
