package com.example.pokedex.core.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pok_id")
	private Long id;

	@Column(name = "pok_name")
	private String name;

	@Column(name = "pok_hp")
	private Short hp;

	@Column(name = "pok_cp")
	private Short cp;

	@Column(name = "pok_picture")
	private String picture;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "pokemon_type", 
			joinColumns = {@JoinColumn(name = "pok_id")},
			inverseJoinColumns = {@JoinColumn(name = "typ_id")})
	private List<Type> types;

	public Pokemon() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param hp
	 * @param cp
	 * @param picture
	 */
	public Pokemon(Long id, String name, Short hp, Short cp, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.cp = cp;
		this.picture = picture;
	}


	public Pokemon(long id, String name, short hp, short cp, String picture, List<Type> types) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.cp = cp;
		this.picture = picture;
		this.types = types;
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

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	/**
	 * add a type to a pokemon
	 * 
	 * @param type a new type to add
	 */
	public void addType(Type type) {
		if (types == null) {
			types = new ArrayList<Type>();
		}
		types.add(type);
	}

	/**
	 * remove a type to a pokemon
	 * 
	 * @param type a new type to add
	 */
	public void removeType(Type type) {
		if (types != null) {
			types.remove(type);
		}
	}


}
