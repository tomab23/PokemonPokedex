package com.example.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokedex.dto.TypeDTO;
import com.example.pokedex.dto.mapper.TypeMapper;
import com.example.pokedex.service.ITypeService;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class TypeController {

	@Autowired
	private ITypeService typeService;

	@GetMapping("/all")
	public List<TypeDTO> getAllTypes() {
		return TypeMapper.typesToDto(typeService.getAllType());
	}
}
