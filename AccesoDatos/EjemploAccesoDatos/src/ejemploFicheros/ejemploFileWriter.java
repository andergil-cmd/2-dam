package ejemploFicheros;

import java.io.*;

public class ejemploFileWriter {

	public static void main(String[] args) {
		
		PruebaEscrituraCaracter();
	}

	private static void PruebaEscrituraCaracter() {
		File fichero = null;
		FileWriter fic = null;
		
		fichero = new File("src/ficheros/FicheroPrueba.txt");
		
		
		try {
			fic = new FileWriter(fichero);
			
			String cadena = "Esto es una prueba con FileWriter";
			char[]cad = cadena.toCharArray();
			
			for(int i = 0; i< cad.length; i++) {
				fic.write(cad[i]);
			}
			
			fic.append("*");
			fic.flush();
			
			fic.write(cad);
			String c = "\n *esto es lo ultimo*";
			fic.write(c);
			
			String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jáen",
					"Madrid", "Segovia", "Soria", "Toledo",
					"Vallladolid", "Zamora"};
			
			fic.write("\n");
			
			for(int i=0; i<prov.length; i++) {
				fic.write(prov[i]);
				fic.write("\n");
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
