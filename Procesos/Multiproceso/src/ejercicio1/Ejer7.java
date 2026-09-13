package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejer7 {
	private static Scanner teclado;
	public static void main(String[] args) {

		teclado = new Scanner(System.in);
		
		System.out.println("Introduce un texto: ");
		String texto = teclado.nextLine();
		
		try {
			ProcessBuilder constructor = new ProcessBuilder("java", "Notepad.EjemploLectura");
			
			Process proceso = constructor.start();
			
			OutputStream entrada = proceso.getOutputStream();
			
			PrintWriter escritor = new PrintWriter(entrada);
			
			escritor.print(texto);
			escritor.flush();
			escritor.close();
			
			BufferedReader lectura = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lectura.readLine()) != null) {
				System.out.println(linea);
			}
			
			lectura.close();
			
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			
		}catch(IOException | InterruptedException error) {
			error.printStackTrace();
		}
		
		teclado.close();
	}

}
