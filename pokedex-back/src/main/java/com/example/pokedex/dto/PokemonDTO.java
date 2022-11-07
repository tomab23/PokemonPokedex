package com.example.pokedex.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonDTO {

	private Long id;
	private String name;
	private Short hp;
	private Short cp;
	private String picture;
	
	private List<Short> types;

	public PokemonDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hp
	 */
	public Short getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(Short hp) {
		this.hp = hp;
	}

	/**
	 * @return the cp
	 */
	public Short getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(Short cp) {
		this.cp = cp;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Short> getTypes() {
		return types;
	}

	public void setTypes(List<Short> types) {
		this.types = types;
	}

	
	

}
