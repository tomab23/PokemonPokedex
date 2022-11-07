export default class Type {
    id: number;
    name: String;
    color: String;

    constructor(
        id: number,
        name: string,
        color: string,
       ) {
        // 3. Initialisation des propiétés d'un pokémons.
        this.id = id;
        this.name = name;
        this.color = color;
       }
}