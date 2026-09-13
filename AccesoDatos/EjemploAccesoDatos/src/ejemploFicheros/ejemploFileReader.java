package ejemploFicheros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ejemploFileReader {

	public static void main(String[] args) {

		pruebaLecturaCaracter();
		
	}

	private static void pruebaLecturaCaracter() {
		
		File fichero = null;
		FileReader fic = null;
		
		try {
			fichero = new File("src/ficheros/FicheroPrueba.txt");
			
			fic = new FileReader(fichero);
			
			int i;
			
			
			while((i = fic.read()) != -1) {
				System.out.println((char) i + "==>" + i);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fic.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
