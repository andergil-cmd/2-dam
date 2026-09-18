package ejercicio1;

import java.io.IOException;


public class Ejer1 {

	public static void main(String[] args) {
		System.out.println("Vamos a lanzar el Visual Studio...");
		
		String[] infoProceso = {"C:\\Program Files\\Microsoft VS Code\\Code.exe"};
		
		try {
			ProcessBuilder pb = new ProcessBuilder(infoProceso);
			
			Process proceso = pb.start();
			
			System.out.println("El PID del proceso es "+proceso.pid());
			
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del proceso con el codigo " + codigoRetorno);
			
		}catch(IOException | InterruptedException error) {
			error.printStackTrace();
		}
	}

}
