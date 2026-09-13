package Notepad;

import java.io.IOException;

public class NotepadExecRuntime {

	public static void main(String[] args) {

		System.out.println("Vaamos a lanzar el Notepad...");

		String[] infoProceso = { "notepad"};
		
		try {
			Process proceso = Runtime.getRuntime().exec(infoProceso);
			
			System.out.println("Se ha inicial el proceso con el PID = " +proceso.pid());
			
			int codigoRetorno = proceso.waitFor();
			if(codigoRetorno == 0) {
				System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			}else {
				System.out.println("Notepad no se ha cerrado correctamente");
			}
		}catch(IOException | InterruptedException error) {
			error.printStackTrace();
		}
	}

}
