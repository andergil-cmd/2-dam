package Notepad;

import java.io.IOException;
import java.io.OutputStream;

public class EjemploEscritura {

	public static void main(String[] args) {

		ProcessBuilder constructorProceso = new ProcessBuilder("CMD");
		
		try {
			
			Process proceso = constructorProceso.start();
			OutputStream escritura = proceso.getOutputStream();
			
			String dato = "DatoParaElPrograma\\n";
			escritura.write(dato.getBytes());
			escritura.flush();
			
			escritura.close();
			
		}catch(IOException error) {
			error.printStackTrace();
		}
	}

}
