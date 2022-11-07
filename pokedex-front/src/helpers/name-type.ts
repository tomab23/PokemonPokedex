import TypeService from "../services/type-service";

const nameType = (id: number): any => {

    let typeName = TypeService.pokemontypes.find(one => one.id === id);

    if (typeName != undefined) {
        return typeName.name;
    }


}

export default nameType;