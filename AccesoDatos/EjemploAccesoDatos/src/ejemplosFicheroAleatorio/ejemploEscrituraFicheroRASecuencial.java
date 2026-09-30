package ejemplosFicheroAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ejemploEscrituraFicheroRASecuencial {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Llamo al metodo escribirFichero
		escribirFichero();
}
	
	/**
	 * Metodo creado para escribir un fichero de forma secuencial
	 */
	public static void escribirFichero() {
	//declaro la ruta del fichero
	File fichero = new File("src/ficheros/AleatorioEmpleSecuencial.dat");
	//declara el fichero de acceso aleatorio
	RandomAccessFile accesoFichero = null;
	
	//declaramos los datos
	String apellido[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS",
			"SEVILLA", "CASILLA", "REY"};
	int dep[] = {10,20,10,10,30,30,20};
	Double salario[] = {1000.45, 2400.60, 3000.0, 1500.56,
			2200.0, 1435.87, 2000.0};
	StringBuffer buffer = null;
	
	try {
		//inicializo el fichero de acceso aleatorio
		accesoFichero = new RandomAccessFile(fichero, "rw");
		
		//declaro el tamaño del array apellido en una variable int
		int n = apellido.length;
		//recorro el tamaño del array apellido
		for (int i = 0; i < n; i++) {
			//inserto i+1 para identificar empleado
			accesoFichero.writeInt(i+1);
			buffer = new StringBuffer(apellido[i]);
			//añado 10 caracteres al apellido
			buffer.setLength(10);
			//escribo apellido
			accesoFichero.writeChars(buffer.toString());
			//inserto departamento
			accesoFichero.writeInt(dep[i]);
			//inserto salario
			accesoFichero.writeDouble(salario[i]);
			
			}
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}
}
	

