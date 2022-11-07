package com.example.pokedex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pokedex.core.domain.Type;
import com.example.pokedex.dto.TypeDTO;
import com.example.pokedex.dto.mapper.TypeMapper;

@SpringBootTest
public class TypeTest {

	@Test
	void TypeMapperConstructor() {
		//given
		
		//when
		Object m = new TypeMapper();
				
		//then
		assertEquals(m.getClass(), TypeMapper.class);
	}

	/**
	 * test, Type Entity to DTO
	 */
	@Test
	public void typeToDto() {
		// given
		Type typ = new Type();
		typ.setId((short) 1);
		typ.setName("t");
		typ.setColor("red");

		// when
		TypeDTO dto = TypeMapper.typeToDto(typ);

		// then
		assertEquals(dto.getId(), typ.getId());
		assertEquals(dto.getName(), typ.getName());
		assertEquals(dto.getColor(), typ.getColor());
	}

	@Test
	public void typeNullToTypDTO() {
		// given
		Type typ = null;

		// when
		TypeDTO dto = TypeMapper.typeToDto(typ);

		// then
		assertThat(dto).isNull();
	}

	/**
	 * test, Type Entity to DTO (just ID)
	 */
	@Test
	public void typeToDtoId() {
		// given
		Type typ = new Type();
		typ.setId((short) 1);
		typ.setName("t");
		typ.setColor("red");

		// when
		TypeDTO dto = TypeMapper.toDtoOnlyId(typ);

		// then
		assertEquals(dto.getId(), typ.getId());
	}


	/**
	 * test, Type DTO to Entity
	 */
	@Test
	public void DtoToType() {
		// given
		TypeDTO dto = new TypeDTO();
		dto.setId((short) 1);
		dto.setName("t");
		dto.setColor("red");

		// when
		Type entity = TypeMapper.toType(dto);

		// then
		assertEquals(entity.getId(), dto.getId());

	}

	@Test
	public void typeNullToTyp() {
		// given
		TypeDTO dto = null;

		// when
		Type typ = TypeMapper.toType(dto);

		// then
		assertThat(typ).isNull();
	}

	@Test
	public void TypeListToDto() {
		// given
//		List<Type> typs = new ArrayList<Type>();
//		for (short i = 0; i < 2; i++) {
//			typs.add(new Type((short) 1, "test"));
//		}

		List<Type> typs = new ArrayList<Type>();
		Type t = new Type();
		for (short i = 0; i < 2; i++) {
			t.setName("ee" + i);
			t.setColor("ee" + i);
		}

		typs.add(t);

		// when
		List<TypeDTO> dtos = TypeMapper.typesToDto(typs);

		// then
		assertThat(dtos).isNotNull().hasSameSizeAs(typs);
	}

	@Test
	public void typesNullToTypesDTO() {
		// given
//		List<Type> typ = null;

		// when
		List<TypeDTO> dtos = TypeMapper.typesToDto(null);

		// then
		assertThat(dtos).isNull();
	}

	@Test
	public void typesEmptyToTypesDTO() {
		// given
		List<Type> typs = new ArrayList<>();
		typs.isEmpty();
		// when
		List<TypeDTO> dtos = TypeMapper.typesToDto(typs);

		// then
		assertThat(dtos).isNull();
	}

	@Test
	void TypeListToDTOsWithOnlyId() {

		// given
		List<Type> listTypes = new ArrayList<Type>();
		for (short i = 0; i < 2; i++) {
			listTypes.add(new Type(i));
		}

		// when
		List<TypeDTO> listTypeDto = TypeMapper.toDtosOnlyId(listTypes);

		// then
		assertThat(listTypeDto).isNotNull().hasSameSizeAs(listTypes);
	}

	@Test
	public void typesNullToTypesDTOOnlyId() {
		// given
//		List<Type> typs = null;

		// when
		List<TypeDTO> dtos = TypeMapper.toDtosOnlyId(new ArrayList<>());

		// then
		assertThat(dtos).isNull();
	}
}
