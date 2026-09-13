package Notepad;

import java.io.IOException;
import java.util.Map;

public class NotepadExecProccesBuilder {
	public static void main(String[] args) {
	
		System.out.println("Vamos a lanzar el Notepad...");
		
		String[] infoProceso = {"Notepad.exe"};
		
		try {
			ProcessBuilder pb = new ProcessBuilder(infoProceso);
			
			Map <String, String> environment = pb.environment();
			imprimirVariablesEntorno (environment);
			System.out.println("Numero de Procesadores: " + environment.get("NUMBER_OF_PROCESSORS"));
			
			Process proceso = pb.start();
			
			System.out.println("El PID del proceso es "+proceso.pid());
			
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del proceso con el codigo " + codigoRetorno);
			
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo creado para mostrar las variables del entorno
	 * @param mapaEntorno
	 */
	public static void imprimirVariablesEntorno(Map<String, String> mapaEntorno) {
		
		for(String key: mapaEntorno.keySet()) {
			System.out.println("Variable " +key+ " : " +mapaEntorno.get(key));
		}

		
	}
}
