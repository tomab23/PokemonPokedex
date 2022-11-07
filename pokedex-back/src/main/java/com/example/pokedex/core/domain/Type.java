package com.example.pokedex.core.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typ_id")
	private Short id;

	@Column(name = "typ_name")
	private String name;

	@Column(name = "typ_color")
	private String color;
	
	@ManyToMany(mappedBy = "types")
	private List<Pokemon> pokemons;

	public Type() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param color
	 */
	public Type(Short id, String color) {
		super();
		this.id = id;
		this.color = color;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Type(Short id) {
		super();
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Short id) {
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
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the pokemons
	 */
	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	/**
	 * @param pokemons the pokemons to set
	 */
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}
