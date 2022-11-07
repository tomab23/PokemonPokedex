import Pokemon from "../models/pokemon";
import PokemonPage from "../models/pokemonPage";
import AuthentificationService from "./Authentification-service";

export default class PokemonService {

  static pokemons:Pokemon[];

  static getPokemons(): Promise<Pokemon[]> {
      return fetch('http://localhost:8080/pokemon/', {
        headers: { 'Authorization': AuthentificationService.jwt}
        })
      .then(response => response.json())
      .catch(error => this.handleError(error));
  }

  static getPokemonsByPage(page: number): Promise<PokemonPage> {
      return fetch(`http://localhost:8080/pokemon/page/${page}`, {
        headers: { 'Authorization': AuthentificationService.jwt}
        })
      .then(response => response.json())
      .catch(error => this.handleError(error));
  }

  static getPokemon(id: number): Promise<Pokemon|null> {
      return fetch(`http://localhost:8080/pokemon/${id}`, {
        headers: { 'Authorization': AuthentificationService.jwt}
        })
      .then(response => response.json())
      .then(data => this.isEmpty(data) ? null : data)
      .catch(error => this.handleError(error));
  }

  static updatePokemon(pokemon: Pokemon): Promise<Pokemon> {
      return fetch(`http://localhost:8080/pokemon/${pokemon.id}`, {
        method: 'PUT',
        body: JSON.stringify(pokemon),
        headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt }
      })
      .then(response => response.json())
      .catch(error => this.handleError(error));
  }

  static deletePokemon(pokemon: Pokemon): Promise<{}> {
      return fetch(`http://localhost:8080/pokemon/${pokemon.id}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt}
      })
      .then(response => response.json())
      .catch(error => this.handleError(error));
    }

  static addPokemon(pokemon: Pokemon): Promise<Pokemon> {
      return fetch(`http://localhost:8080/pokemon/add`, {
        method: 'POST',
        body: JSON.stringify(pokemon),
        headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt}
      })
      .then(response => response.json())
      .catch(error => this.handleError(error));
    }

  static searchPokemon(term: string): Promise<Pokemon[]> {
      return fetch(`http://localhost:8080/pokemon/search?name=${term}`, {
        headers: { 'Authorization': AuthentificationService.jwt}
        })
      .then(response => response.json())
      .catch(error => this.handleError(error));
    }

  static isEmpty(data: Object): boolean {
    return Object.keys(data).length === 0;
  }

  static handleError(error: Error): void {
    console.error(error);
  }
}