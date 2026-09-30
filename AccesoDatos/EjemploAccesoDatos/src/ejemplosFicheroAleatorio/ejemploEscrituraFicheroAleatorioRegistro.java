package ejemplosFicheroAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ejemploEscrituraFicheroAleatorioRegistro {

	public static void main(String[] args) {
		//Llamo al metodo escribirFichero
		escribirFichero();
	}
	
	/**
	 * Creo este metodo para escribir un fichero aleatorio con registro
	 */
	private static void escribirFichero() {
		//declaro la ruta de acceso aleatorio
		File fichero = new File("src/ficheros/AleatorioEmpleRegistro.dat");
		//declaro el fichero de acceso aleatorio
		RandomAccessFile accesoFichero = null;
		//declaro un stringBuffer para asi poder modificar un string
		StringBuffer buffer = null;
		String apellido="GONZALEZ";
		Double salario = 1230.87;
		int dep = 10;
		int id=20;
		// inicalizo la posicion
		long posicion = (id -1)*36;
		
		try {
			//inicializo el fichero de acceso aleatorio
			accesoFichero = new RandomAccessFile(fichero, "rw");
			//nos posicionamos
			accesoFichero.seek(posicion);
			//inserto el id para identificar empleado
			accesoFichero.writeInt(id);
			//añado un stringBuffer con el apellido
			buffer = new StringBuffer(apellido);
			//asignamos 10 caracteres para el apellido
			buffer.setLength(10);
			//escribo apellido
			accesoFichero.writeChars(buffer.toString());
			//inserto departamento
			accesoFichero.writeInt(dep);
			//inserto el salario
			accesoFichero.writeDouble(salario);
			accesoFichero.close();
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}
}
	
	


