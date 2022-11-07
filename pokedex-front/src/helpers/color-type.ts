import TypeService from "../services/type-service";

const colorType = ( id:number)  => {

   let typeColor = TypeService.pokemontypes.find(one => one.id === id);

   
   if (typeColor != undefined) {
    return "#" + typeColor.color;
}

return 'light-grey';

}

export default colorType;