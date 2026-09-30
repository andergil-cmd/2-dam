interface PersonajeLOR{
    nombre: string;
    vida: number;
}

function curar(personaje: PersonajeLOR, vida:number): void{
    personaje.vida += vida;
    console.log("Personaje actualizado: ", + personaje)
}

const nuevoPersonaje: PersonajeLOR = {
    nombre:  'Strider',
    vida: 50
};

curar(nuevoPersonaje, 20)