package com.example.pokedex.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pokedex.core.domain.Pokemon;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon, Long> {
	
//	@Query(value = "SELECT * FROM pokemon p \r\n"
//			+ "	INNER JOIN pokemon_type pt ON pt.pok_id = p.pok_id \r\n"
//			+ "	INNER JOIN `type` t ON t.typ_id = pt.typ_id \r\n"
//			+ "WHERE typ_name = :type", nativeQuery = true)
//	List<Pokemon> findPokemonBytype(@Param("type") String type);
	
	List<Pokemon> findByNameContaining(String name);

}
