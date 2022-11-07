package com.example.pokedex.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.pokedex.core.domain.Type;
import com.example.pokedex.dto.TypeDTO;

public class TypeMapper {

	public static TypeDTO typeToDto(Type type) {
		TypeDTO dto = null;

		if (type != null) {
			dto = new TypeDTO(type.getId(), type.getName(), type.getColor());
		}

		return dto;
	}

	public static Type toType(TypeDTO typeDTO) {
		Type entity = null;

		if (typeDTO != null) {
			entity = new Type(typeDTO.getId());
		}

		return entity;
	}

	public static List<TypeDTO> typesToDto(List<Type> types) {
		List<TypeDTO> dtos = null;

		if (types != null && !types.isEmpty()) {
			dtos = new ArrayList<>();
			for (Type t : types) {
				dtos.add(typeToDto(t));
			}
		}

		return dtos;
	}

	/**
	 * Convert a {@link Type} to a {@link TypeDTO} with only its id set
	 * 
	 * @param type a {@link Type} to convert
	 * @return the {@link TypeDTO} corresponding to the given {@link Type}
	 */
	public static TypeDTO toDtoOnlyId(Type type) {
		TypeDTO dto = new TypeDTO();

		dto.setId(type.getId());
		return dto;
	}

	/**
	 * Convert a list of {@link Type} to a list of {@link TypeDTO} with only their
	 * ids set
	 * 
	 * @param types a list of {@link Type} to convert
	 * @return a list of {@link TypeDTO} corresponding to the given list
	 */
//	public static List<TypeDTO> toDtosOnlyId(Set<Type> types) {
//		List<TypeDTO> dtos = null;
//
//		if (types != null) {
//			dtos = new ArrayList<TypeDTO>();
//			for (Type t : types) {
//				dtos.add(toDtoOnlyId(t));
//			}
//		}
//
//		return dtos;
//	}

	public static List<TypeDTO> toDtosOnlyId(List<Type> listTypes) {
		List<TypeDTO> dtos = null;

		if (listTypes != null) {
			dtos = new ArrayList<TypeDTO>();
			for (Type t : listTypes) {
				dtos.add(toDtoOnlyId(t));
			}
		}

		return dtos;
	}

}
