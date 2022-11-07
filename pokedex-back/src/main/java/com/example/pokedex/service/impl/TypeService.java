package com.example.pokedex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pokedex.core.domain.Type;
import com.example.pokedex.core.repository.ITypeRepository;
import com.example.pokedex.service.ITypeService;

@Service("TypeService")
public class TypeService implements ITypeService {

	@Autowired
	private ITypeRepository typeRepo;

	@Override
	public List<Type> getAllType() {
		return typeRepo.findAll();
	}
}
