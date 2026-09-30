interface Pasajero {
    nombre:string,
    hijos?:string[]
}

const pasajero1 : Pasajero={
    nombre: "Jorge"
}

const pasajero2: Pasajero={
    nombre: "Felipe",
    hijos: ["Natalia", "Gabriel"]
}

function imprimirHijos(pasajero: Pasajero): void{
    const numeroHijos = pasajero.hijos?.length
    console.log(numeroHijos)
}

function imprimirHijos2(pasajero: Pasajero): void{
    const numeroHijos = pasajero.hijos?.length || 0;
    console.log(numeroHijos);
}

console.log("--- Resultados de imprimirHijos ---");
console.log("Numero de hijos del primer pasajero: ", imprimirHijos(pasajero1))
console.log("Numero de hijos del segundo pasajero: ", imprimirHijos(pasajero2))

console.log("--- Resultados de imprimirHijos2 ---");
console.log("Numero de hijos del primer pasajero: ", imprimirHijos2(pasajero1))
console.log("Numero de hijos del segundo pasajero: ", imprimirHijos2(pasajero2))

