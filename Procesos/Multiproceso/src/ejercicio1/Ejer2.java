package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejer2 {

	public static void main(String[] args) {
		
		System.out.println("Vamos a ejecutar un comando de Windows");
		
		String comando = "ipconfig";
		
		try {
			
			String[]comandos = {"cmd.exe", "/c", "ipconfig"};
			
			Process proceso = Runtime.getRuntime().exec(comandos);
			
			OutputStream entrada = proceso.getOutputStream();
			
			entrada.write(comando.getBytes());
			entrada.flush();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			
			entrada.close();
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
		
	}

}
