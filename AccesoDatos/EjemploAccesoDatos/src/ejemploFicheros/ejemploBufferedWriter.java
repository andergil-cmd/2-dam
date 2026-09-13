package ejemploFicheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ejemploBufferedWriter {

	public static void main(String[] args) {
		
		comprobarBufferedWriter();
	}

	private static void comprobarBufferedWriter() {

		File fichero = null;
		BufferedWriter escritorFichero = null;
		
		try {
			fichero = new File("src/ficheros/FicheroPruebaBuffer.txt");
			
			escritorFichero = new BufferedWriter(new FileWriter(fichero));
			
			for(int i = 1; i<11; i++) {
				escritorFichero.write("Fila numero: " +i);
				escritorFichero.newLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				escritorFichero.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
