package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejer3 {

	public static void main(String[] args) {
		
		System.out.println("Vamos a obtener la direccion MAC");
		
		String comando = "ipconfig /all";
		
		try {
			String[]arrayComando = {"cmd.exe", "/c", "ipconfig /all"};
			
			Process proceso = Runtime.getRuntime().exec(arrayComando);
			
			OutputStream salida = proceso.getOutputStream();
			
			salida.write(comando.getBytes());
			salida.flush();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			
			salida.close();
		}catch(IOException error) {
			error.printStackTrace();
		}
		

	}

}
