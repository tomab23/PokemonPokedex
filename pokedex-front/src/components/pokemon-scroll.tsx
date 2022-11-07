import React from "react";
import { FunctionComponent } from "react";
import { useHistory } from "react-router-dom";
import PokemonPage from "../models/pokemonPage"

type Props = {
    pokemonPage: PokemonPage
};

const PokemonScroll: FunctionComponent<Props> = ({ pokemonPage }) => {

    const history = useHistory();

    const next = () => {
        history.push(`pokemons/page/${pokemonPage.currentPage + 1}`);
    }

    const previous = () => {
        history.push(`pokemons/page/${pokemonPage.currentPage - 1}`);
    }

    return(
        <div className="row">
            <div className="col s12 m6">
                {pokemonPage.hasPrevious ?
                <a className="btn chip halfway-fab waves-effect waves-kight">
                    <i onClick={previous}>↓</i>
                </a>
                :
                <a className="btn chip halfway-fab waves-effect waves-kight">
                    <i>↓</i>
                </a>
                }
                <span>page {pokemonPage.currentPage + 1}/{pokemonPage.totalPages}</span>
                {pokemonPage.hasNext ?
                <a className="btn chip halfway-fab waves-effect waves-kight">
                    <i onClick={next}>↓</i>
                </a>
                :
                <a className="btn chip halfway-fab waves-effect waves-kight">
                    <i>↓</i>
                </a>
                }
            </div>
        </div>


    );


}

export default PokemonScroll;