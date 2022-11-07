import Type from "../models/pokemonType";
import AuthentificationService from "./Authentification-service";

export default class TypeService {
static pokemontypes:Type[];

    static getTypes(): Promise<Type[]> {
        return fetch('http://localhost:8080/type/all', {
            headers: { 'Authorization': AuthentificationService.jwt}
        })
        .then(response => response.json())
        .catch(error => this.handleError(error));
    }

    static plusTypes(): void {
        this.getTypes().then(tlist => this.pokemontypes = tlist);
      }


    static handleError(error: any): any {
        throw new Error("Method not implemented.");
    }
}