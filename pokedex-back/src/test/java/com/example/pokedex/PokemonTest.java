package com.example.pokedex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pokedex.core.domain.Pokemon;
import com.example.pokedex.core.domain.Type;
import com.example.pokedex.dto.PokemonDTO;
import com.example.pokedex.dto.mapper.PokemonMapper;

@SpringBootTest
public class PokemonTest {
	
	@Test
	void PokemonTypeConstructor() {
		// given

		// when
		Object m = new PokemonMapper();

		// then
		assertEquals(m.getClass(), PokemonMapper.class);
	}

	@Test
	public void PokemonToDto() {
		// given
		Pokemon pok = new Pokemon();
		pok.setId((long) 1);
		pok.setName("tkt");
		pok.setHp((short) 25);
		pok.setCp((short) 25);
		pok.setPicture("huihiu");
		List<Type> types = new ArrayList<Type>();
		for (short i = 0; i < 2; i++) {
			types.add(new Type((short) 1));
		}

		pok.setTypes(types);

		// when
		PokemonDTO dto = PokemonMapper.pokemonToDto(pok);

		// then
		assertEquals(dto.getId(), pok.getId());
		assertEquals(dto.getName(), pok.getName());
		assertEquals(dto.getHp(), pok.getHp());
		assertEquals(dto.getCp(), pok.getCp());
		assertEquals(dto.getPicture(), pok.getPicture());
//		assertThat(dto.getTypes()).isNotNull().hasSameSizeAs(pok.getTypes().size());
//
//		for (Type t : pok.getTypes()) {
//			assertTrue(dto.getTypes().contains(t.getId()));
//		}
	}

	@Test
	public void PokemonDtoToEntity() {
		// given
		PokemonDTO dto = new PokemonDTO();
		dto.setId((long) 1);
		dto.setName("tkt");
		dto.setHp((short) 25);
		dto.setCp((short) 25);
		dto.setPicture("huihiu");
		dto.setTypes(new ArrayList<>());
		List<Short> types = new ArrayList<Short>();
		for (Short i = 0; i < 2; i++) {
			types.add((short) 1);
		}

		dto.setTypes(types);

		// when
		Pokemon pok = PokemonMapper.toEntity(dto);

		// then
		assertEquals(pok.getId(), dto.getId());
		assertEquals(pok.getName(), dto.getName());
		assertEquals(pok.getHp(), dto.getHp());
		assertEquals(pok.getCp(), dto.getCp());
		assertEquals(pok.getPicture(), dto.getPicture());
//		assertThat(pok.getTypes()).isNotNull().hasSameSizeAs(dto.getTypes().size());
	}

	@Test
	public void PokemonsNullToPokemonDto() {
		// given
		List<Pokemon> poks = null;

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDto(poks);

		// then
		assertThat(dtos).isNull();
	}
	
	@Test
	public void PokemonsEmptyToPokemonDto() {
		// given
		List<Pokemon> poks = new ArrayList<>();
		poks.isEmpty();

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDto(poks);

		// then
		assertThat(dtos).isNull();
	}

	@Test
	public void PokemonListToDto() {
		// given
		List<Pokemon> poks = new ArrayList<>();
		List<Type> typs = new ArrayList<>();

		for (Short i = 0; i < 2; i++) {
			typs.add(new Type((short) 1));
		}

		for (long i = 0; i < 2; i++) {
			poks.add(new Pokemon((long) 1, "ezdzd", (short) 1, (short) 1, "zefze", typs));
		}

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDto(poks);

		// then
		assertThat(dtos).isNotNull().hasSameSizeAs(poks);
	}

}
