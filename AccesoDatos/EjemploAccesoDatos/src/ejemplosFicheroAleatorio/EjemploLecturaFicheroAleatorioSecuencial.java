package ejemplosFicheroAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * 
 */
public class EjemploLecturaFicheroAleatorioSecuencial {

	public static void main(String[] args) {
		//Llamo al metodo leerFichero
		leerFichero();
	}
	
	/**
	 * Creo este metodo para leer el fichero aleatorio de forma secuencial
	 */
	private static void leerFichero() {
		File fichero = new File("src/ficheros/AleatorioEmpleSecuencial.dat");
		int id,dep,posicion;
		Double salario;
		char apellido[] = new char[10], aux;
		
		try {
			
			//inicializo el fichero de acceso aleatorio
			RandomAccessFile accesoFichero = new RandomAccessFile(fichero, "r");
			posicion = 0;
			//nos posicionamos
			accesoFichero.seek(posicion);
			//recorro el fichero
			while(accesoFichero.getFilePointer()< accesoFichero.length()) {
				//obtengo el id del empleado
				id = accesoFichero.readInt();
				//recorro uno a uno los caracteres del apellido
				for (int i = 0; i < apellido.length; i++) {
					aux = accesoFichero.readChar();
					//los voy guardando en el array
					apellido[i] = aux;
				}
				//convierto String al array
				String apellidos = new String(apellido);
				//obtengo dep
				dep = accesoFichero.readInt();
				//obtengo salario
				salario = accesoFichero.readDouble();
				if(id > 0) {
					System.out.printf("ID: %s,Apellido: %s, Departamento: %d, Salario: %2f %n", id, apellidos.trim(), dep, salario);
				}
				//me posiciono para el siguiente empleado
				posicion += 36;
			}
			
			accesoFichero.close();
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}
}
	
	


