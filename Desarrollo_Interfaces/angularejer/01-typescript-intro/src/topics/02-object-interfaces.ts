let arrayHabilidades: string[] = ['Bash', 'Counter', 'Healing'];

interface Personaje{
    nombre: string;
    hp: number;
    arrayHabilidades: string[];
    puebloNatal?: string 
}

const personaje: Personaje ={
    nombre: 'Aragorn',
    hp: 100,
    arrayHabilidades: ['Combate con espada', 'Rastreo', 'Curación']
};

personaje.puebloNatal = 'Pueblo Paleta';

console.table(personaje);
console.log(personaje);

