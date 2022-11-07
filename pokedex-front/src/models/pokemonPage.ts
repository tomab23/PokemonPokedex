import pokemon from "./pokemon";

export default class PokemonPage {
    currentPage: number;
    hasPrevious: boolean;
    hasNext: boolean;
    totalItems: number;
    totalPages: number;
    pokemons: Array<pokemon>;


    constructor(
        currentPage: number = 0,
        hasPrevious: boolean = false,
        hasNext: boolean = false,
        totalItems:  number = 0,
        totalPages: number = 0,
        pokemons: Array<pokemon> = []
    ) {
        this.currentPage = currentPage;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.pokemons = pokemons;
    }

}