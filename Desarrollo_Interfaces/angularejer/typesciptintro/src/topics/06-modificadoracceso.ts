class Heroe1{
    public static conteoHeroes: number = 0;

    public nombre: string;
    private identidadSecreta: string;
    public edad:number;

    constructor(nombre:string, identidadSecreta:string, edad:number){
        this.nombre = nombre,
        this.identidadSecreta = identidadSecreta,
        this.edad = edad

        Heroe1.conteoHeroes ++;
    }

    public obtenerIdentidad(): string {
        return `${this.nombre} es en realidad ${this.identidadSecreta}`;
    }

}

const heroe = new Heroe1("Spider-Man", "Peter Parker", 18);

console.log(heroe.nombre);
console.log(heroe.obtenerIdentidad())
console.log(Heroe1.conteoHeroes);

//CLASE CON PROPIEDADES PUBLICAS Y CONSTRUCTOR

class Heroe{
    public alterEgo: string;
    public edad: number
    public nombreReal: string;

    constructor(alterEgo:string, edad:number, nombreReal:string){
        this.alterEgo = alterEgo,
        this.edad = edad,
        this.nombreReal = nombreReal
    }

}

const ironman = new Heroe("Ironman", 37, "Tony Stark");

console.log(ironman);