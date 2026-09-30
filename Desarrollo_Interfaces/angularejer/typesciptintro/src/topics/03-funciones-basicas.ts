function sumar(parametro1:string, parametro2:string) : string {
    return parametro1 + parametro2;
}

const resultado: string = sumar("Fernando","Herrera");
console.log(resultado);

function multiplicar(numero: number, otroNumero?:number, base:number = 3){
   return numero * base;
}

const resultadoOpcional = multiplicar(6,7);
console.log(resultadoOpcional);

const resultadoNumero = multiplicar(6);
console.log(resultadoNumero);

const resultadoObligatorio = multiplicar(6,7,5);
console.log(resultadoObligatorio);

const resultadoUndefined = multiplicar(5,10,undefined);
console.log(resultadoUndefined);
