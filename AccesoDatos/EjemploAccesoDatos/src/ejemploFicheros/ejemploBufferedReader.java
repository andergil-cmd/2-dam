package ejemploFicheros;

import java.io.*;

public class ejemploBufferedReader {

	public static void main(String[] args) {

		comprobarBufferedReader();
	}

	private static void comprobarBufferedReader() {

		File fichero = null;
		BufferedReader lectorFichero = null;
		
		try {
			fichero = new File("src/ficheros/FicheroPruebaBuffer.txt");
			
			lectorFichero = new BufferedReader(new FileReader(fichero));
			
			String linea;
			
			while((linea = lectorFichero.readLine())!= null) {
				System.out.println(linea);
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				lectorFichero.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
