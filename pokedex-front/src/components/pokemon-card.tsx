import React, { FunctionComponent, useState} from 'react';
import Pokemon from '../models/pokemon';
import './pokemon-card.css';
import formatDate from'./../helpers/format-date';
import formatType from './../helpers/format-type';
import { useHistory } from 'react-router-dom';
import nameType from '../helpers/name-type';
import colorType from '../helpers/color-type';
import pokemonType from '../models/pokemonType';
  
type Props = {
  pokemon: Pokemon,
  borderColor?: string,
  // types: pokemonType
};
  
const PokemonCard: FunctionComponent<Props> = ({pokemon, borderColor = '#009688'}) => {
    
    const [color, setColor] = useState<string>();
    const history = useHistory();

    const showBorder = () => {
        setColor(borderColor);
    }

    const hideBorder = () => {
        setColor('#f5f5f5');
    }

    const goToPokemon = (id: number) => {
        history.push(`/pokemons/${id}`)
    }


  return (
    <div className="col s6 m4" onClick={() => goToPokemon(pokemon.id)} onMouseEnter={showBorder} onMouseLeave={hideBorder}>
      <div className="card horizontal" style={{borderColor: color}}>
        <div className="card-image"> 
          <img src={pokemon.picture} alt={pokemon.name}/>
        </div>
        <div className="card-stacked">
          <div className="card-content">
            <p>{pokemon.name}</p>
            {pokemon.types.map(type => (
                <span key={type} className={"chip"} style={{color: "white", backgroundColor: colorType(type)}} > {nameType(type)}</span>
               ))}
            {/* {<p><small>{formatDate(pokemon.created)}</small></p>} */}
          </div>
        </div>
      </div> 
    </div>
  );
}
  
export default PokemonCard;