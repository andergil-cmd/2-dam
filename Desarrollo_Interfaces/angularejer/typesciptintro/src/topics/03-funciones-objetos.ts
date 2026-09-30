interface SuperHeroe {
    nombre: string,
    edad: number,
    direccion: {
        calle: string,
        pais:string,
        ciudad:string
    }
    mostrarDireccion: () => string;
}

const superHeroe: SuperHeroe={
    nombre : 'Spiderman',
    edad: 30,
    direccion: {
        calle: 'Main St',
        pais: 'USA',
        ciudad: 'NY'
    },
    mostrarDireccion(){
        return `${this.nombre}, ${this.direccion.ciudad}, ${this.direccion.pais}`;
    }
};

const direccion = superHeroe.mostrarDireccion

console.log(direccion)

// DESESTRUCTURACION DE ARREGLOS

const arrayPersonajes: string[] = ["p1", "p2", "p3"];
const [primero, segundo, tercero] = arrayPersonajes;

console.log("Primer personaje: ", primero)
console.log("Segundo personaje: ", segundo)
console.log("Tercer personaje: ", tercero)
