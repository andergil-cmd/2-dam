package Notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjemploLectura {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		try {
			Process proceso = pb.start();
			
			System.out.println("Parte 1: ");
			
			InputStream lecturaStream = proceso.getInputStream();
			System.out.println("");
			
			int c;
			while((c = lecturaStream.read()) != -1){
				System.out.print((char) c);
			}
			
			lecturaStream.close();
			
			System.out.println("Parte 2");
			
			InputStream lectura = proceso.getInputStream();
			
			BufferedReader lecturaBuffer = new BufferedReader(new InputStreamReader(lectura));
			
			String linea = null;
			
			while((linea = lecturaBuffer.readLine()) != null) {
				System.out.println(linea);
			}
			
			lectura.close();
		}catch(IOException error) {
			error.printStackTrace();
		}
	}

}
