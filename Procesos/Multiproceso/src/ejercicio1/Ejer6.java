package ejercicio1;

import java.io.File;
import java.io.IOException;

public class Ejer6 {

	public static void main(String[] args) {

		System.out.println("Ejecutamos un programa .bat");
		
		String bat = "src" + File.separator + "archivos" + File.separator
					 + "Ejemplo.bat";
		
		String salida = "src/archivos/Salida.txt";
		String errores = "src/archivos/Errores.txt";
		
		ProcessBuilder constructor = new ProcessBuilder("cmd.exe", "/c", bat);
		
		constructor.redirectOutput(new File(salida));
		constructor.redirectError(new File(errores));
		
		try {
			
			Process proceso = constructor.start();
			
			int codigoRetorno = proceso.waitFor();
			
			System.out.println("El .bat ha terminado");
			System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			
		}catch(IOException | InterruptedException error) {
			System.out.println("Error ejecutando el .bat: " + error.getMessage());
		}
		
	}

}
