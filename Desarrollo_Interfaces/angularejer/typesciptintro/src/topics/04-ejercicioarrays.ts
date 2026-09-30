interface Producto {
    descripcion: string,
    precio:number
};

const telefono: Producto = {
    descripcion : "Un telefono",
    precio: 60
};

const tableta: Producto = {
    descripcion : "Una tablet",
    precio: 80
};

function calculaISV(productos: Producto[]): [number, number]{
    let total = 0;

    for(const {precio} of productos){
        total += precio;
    }

    const isv = total * 0.15

    return [total, isv];
}

const articulos = [telefono, tableta];

const [totalFactura, totalIsv] = calculaISV(articulos)

console.log("Total sin impuestos: ",totalFactura);

console.log("ISV(15%): ",totalIsv);