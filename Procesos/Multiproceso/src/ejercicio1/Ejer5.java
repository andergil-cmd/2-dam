package ejercicio1;

import java.io.IOException;

public class Ejer5 {

	public static void main(String[] args) {

		System.out.println("Detectamos si el bloc de notas se esta ejecutando");
		
		String[]infoProceso = {"Notepad.exe"};
		
		try {
			ProcessBuilder constructor = new ProcessBuilder(infoProceso);
			
			Process proceso = constructor.start();
			
			if(proceso.isAlive() == true) {
				System.out.println("El proceso se eliminara");
				proceso.destroy();
			}
			
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			
		}catch(IOException | InterruptedException error) {
			error.printStackTrace();
		}
	}

}
