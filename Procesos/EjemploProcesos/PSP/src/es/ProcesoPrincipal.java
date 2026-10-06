package es;

import java.io.File;

public class ProcesoPrincipal {
 public static void main(String[] args) {
	 //Entrar proceso Principal
	 System.out.println("Entrando en el proceso principal ...\n");
	try {
		ProcessBuilder builder;
		builder = new ProcessBuilder("java","es.ProcesoSecundario");
		builder.directory(new File("bin"));
		Process process = builder.start();
		// Esperamos a que termine
		int valorRetorno = process.waitFor();
		if (valorRetorno== 0) {
			System.out.println("Proceso Secundario finalizadocon exito");
			
		} else {
			System.out.println("El proceso secundario ha fallado");
			System.out.println("Codigo de error  " + valorRetorno);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
