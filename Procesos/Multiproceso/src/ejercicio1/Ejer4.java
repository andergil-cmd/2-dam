package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejer4 {

	public static void main(String[] args) {

		System.out.println("Mostramos los procesos en ejecucion");
		
		String comando = "tasklist";
		
		try {
			String[]arrayComando = {"cmd.exe" , "/c", "tasklist"};
			
			Process proceso = Runtime.getRuntime().exec(arrayComando);
			
			OutputStream salida = proceso.getOutputStream();
			
			salida.write(comando.getBytes());
			salida.close();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			
			salida.close();
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}

}
