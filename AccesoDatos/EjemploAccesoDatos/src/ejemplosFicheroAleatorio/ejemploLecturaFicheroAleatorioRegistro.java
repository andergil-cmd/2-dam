package ejemplosFicheroAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ejemploLecturaFicheroAleatorioRegistro {

	
	public static void main(String[] args) {
			//llamo al metodo leerFichero
			leerFichero();	
	}
	
	/**
	 * Creo este metodo para leer el archivo aleatorio con registro
	 * uso RandomAccesFile para leer el archivo
	 * 
	 */
	public static void leerFichero() {
		File fichero = new File("src/ficheros/AleatorioEmpleRegistro.dat");
		//declaro el fichero de acceso aleatorio
		RandomAccessFile accesoFichero = null;
		
		int id = 20,dep = 0,posicion;
		Double salario;
		char apellido[] = new char[10], aux;
		
		try {
			//inicializo el fichero de acceso aleatorio
			accesoFichero = new RandomAccessFile(fichero, "r");
			
			posicion = (id - 1) * 36;
			//me aseguro de que exista el id
			if(posicion >= accesoFichero.length()) {
				System.out.printf("ID: %d, NO EXISTE EL EMPLEADO...", id);
			}else {
				//nos posicionamos
				accesoFichero.seek(posicion);
				//obtengo el id del empleado
				id = accesoFichero.readInt();
				for(int i = 0; i < apellido.length; i++) {
					//recorro uno a uno los caracteres del apellido
					aux = accesoFichero.readChar();
					//los voy guardadando en el array
					apellido[i] = aux;
				}
				//convierto a string el array
				String apellidos = new String (apellido);
				//obtengo dep
				dep = accesoFichero.readInt();
				//obtengo salario
				salario = accesoFichero.readDouble();
				System.out.println("ID: " +id+ ", Apellido: " +apellidos.trim()+ ", Departamento: " +dep+ ", Salario: " +salario);
			}
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
	}finally {
		try {
			if (accesoFichero != null) {
				accesoFichero.close();
			}
		}catch(IOException error) {
			System.out.println("Error al cerrar el fichero");
		}
	}
	
	}
}

			
		
	

