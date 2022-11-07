package com.example.pokedex.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokedex.core.domain.Pokemon;
import com.example.pokedex.dto.PokemonDTO;
import com.example.pokedex.dto.mapper.PokemonMapper;
import com.example.pokedex.service.IPokemonService;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class PokemonController {

	@Autowired
	private IPokemonService pokemonService;
	
	@GetMapping("/")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<PokemonDTO> getAllPokemons() {
		return PokemonMapper.pokemonsToDto(pokemonService.getAllPokemons());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public PokemonDTO getPokemon(@PathVariable("id") long id, HttpServletResponse response) {
		PokemonDTO cust = PokemonMapper.pokemonToDto(pokemonService.getPokemon(id));

		if (cust == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return cust;
	}

	@GetMapping("/page/{page}")
	public ResponseEntity<Map<String, Object>> getAllPokemons(@PathVariable int page, HttpStatus reponse) {
		Map<String, Object> response = new LinkedHashMap<>();
		
		try {
			Page<Pokemon> fromDB = pokemonService.getAllPokemons(page);
			
			response.put("Premiere Page", fromDB.isFirst());
			response.put("Page actuelle", fromDB.getNumber());
			response.put("Items par page", fromDB.getSize());
			response.put("Des pages avant", fromDB.hasPrevious());
			response.put("Des pages apres", fromDB.hasNext());
			response.put("total Items", fromDB.getTotalElements());
			response.put("total Pages", fromDB.getTotalPages());
			response.put("Derniere Page", fromDB.isLast());
			response.put("NoItems", fromDB.isEmpty());
			response.put("Pokemons", PokemonMapper.pokemonsToDto(fromDB.getContent()));
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/search")
	public List<PokemonDTO> findPokemonByName(@RequestParam(name = "name") String name) {
		return PokemonMapper.pokemonsToDto(pokemonService.findPokemonByName(name));
	}

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PokemonDTO savePokemon(@RequestBody PokemonDTO pokemon) {
		return PokemonMapper.pokemonToDto(pokemonService.savePokemon(PokemonMapper.toEntity(pokemon)));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deletePokemon(@PathVariable("id") long id) {
		pokemonService.deletePokemon(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void setPokemon(@PathVariable long id, @RequestBody PokemonDTO pokemon) {
		if (pokemon.getId() == id) {
			pokemonService.savePokemon(PokemonMapper.toEntity(pokemon));
		}
	}


}
