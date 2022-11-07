import React, { FunctionComponent, useState, useEffect } from 'react';
import Pokemon from '../models/pokemon';
import PokemonCard from '../components/pokemon-card';
import PokemonService from '../services/pokemon-service';
import { Link } from 'react-router-dom'
import PokemonSearch from '../components/pokemon-search';
  
const PokemonList: FunctionComponent = () => {
  const [pokemons, setPokemons] = useState<Pokemon[]>([]);
  
  useEffect(() => {
    PokemonService.getPokemons().then(pokemons => setPokemons(pokemons));
  }, []);
  
  return (
    <div>
      <h1 className="center">Pokédex</h1>
      <div className="container"> 
        <div className="row"> 
        <PokemonSearch />
        {pokemons.map(pokemon => (
          <PokemonCard key={pokemon.id} pokemon={pokemon} />
        ))}
        </div>
        <Link className='btn right' style={{position: 'fixed', bottom: '50px', right: '75px'}}
        to="/pokemon/add"
        >
          <i>+</i>
        </Link>
      </div>
    </div> 
  );
}
  
export default PokemonList;

