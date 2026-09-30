package Ejercicio7;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread{

	private JProgressBar barra;
	private String caballo;
	private JLabel ganador;
	private Carrera carrera;
	
	private volatile boolean corriendo = true; 
	
	public HiloCaballo(JProgressBar barra, String caballo, JLabel ganador, Carrera carrera) {
		this.barra = barra;
		this.caballo = caballo;
		this.ganador = ganador;
		this.carrera = carrera;
	}

	@Override
	public void run() {
		int progreso = 0;
		
		while(progreso < 100 && corriendo) {
			try {
				sleep(80);
				
				int numeroAleatorio =  (int) ((Math.random() * 5) + 1);
				progreso += numeroAleatorio;
				
				if(progreso > 100) {
					progreso = 100;
				}
				
				barra.setValue(progreso);
			} catch (InterruptedException e) {
				e.printStackTrace();
				corriendo = false;
			}
		}
		
		if (progreso >= 100 && corriendo) {
			evaluarGanadorAbsoluto();
		}
		
	}
	
	public void terminar() {
		this.corriendo = false;
	}
	
	private synchronized void evaluarGanadorAbsoluto() {
		if(ganador.getText().contains("Ninguno")|| ganador.getText().contains("comenzado")) {
			ganador.setText("El ganador es el "+ caballo + "!");
			carrera.detenerCaballos();
		}
	}

}
