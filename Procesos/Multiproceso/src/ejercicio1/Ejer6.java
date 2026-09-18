package ejercicio1;

import java.io.File;
import java.io.IOException;

public class Ejer6 {
	
	private static final String rutaSalida = "src/archivos/Salida.txt";
	private static final String rutaErrores = "src/archivos/Errores.txt";
	private static final String rutaBat = "src" + File.separator + "archivos" + File.separator
			 						  + "Ejemplo.bat";

	public static void main(String[] args) {

		System.out.println("Ejecutamos un programa .bat");
		
		try {
			
		String bat = rutaBat;
		
		String salida = rutaSalida;
		String errores = rutaErrores;
		
		ProcessBuilder constructor = new ProcessBuilder("cmd.exe", "/c", bat);
		
		constructor.redirectOutput(new File(salida));
		constructor.redirectError(new File(errores));
		
			
			Process proceso = constructor.start();
			
			int codigoRetorno = proceso.waitFor();
			
			System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			
		}catch(IOException | InterruptedException error) {
			System.out.println("Error ejecutando el .bat: " + error.getMessage());
		}
		
	}

}
