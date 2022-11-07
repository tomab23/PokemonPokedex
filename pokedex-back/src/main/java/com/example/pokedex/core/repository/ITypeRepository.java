package com.example.pokedex.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pokedex.core.domain.Type;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Short> {

}
