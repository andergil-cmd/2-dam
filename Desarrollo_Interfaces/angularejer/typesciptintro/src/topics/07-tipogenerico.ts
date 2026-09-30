function generica<T>(valor: T) : T{
    return valor;
}

const texto = generica<string>("Hola")
const numero = generica<number>(7);
const booleano = generica<boolean>(true);
const array = generica<number[]>([1,2,3]);


console.log("Texto: " ,texto);
console.log("Numero: ", numero);
console.log("Booleano: ", booleano);
console.log("Array de numeros: ", array);