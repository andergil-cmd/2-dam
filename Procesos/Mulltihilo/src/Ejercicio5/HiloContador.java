package Ejercicio5;

import javax.swing.JLabel;

public class HiloContador extends Thread{

	private int contador = 0;
	private boolean corriendo = true;
	private final JLabel lblContador;
	private final JLabel lblPrioridad;
	private final String nombre;
	
	public HiloContador(String nombre, JLabel lblContador, JLabel lblPrioridad) {
		this.nombre = nombre;
		this.lblContador = lblContador;
		this.lblPrioridad = lblPrioridad;
		this.setPriority(NORM_PRIORITY);
		actualizarPrioridad();
	}


	@Override
	public void run() {
		//si el hilo esta corriendo le voy sumando el contador
		while(corriendo) {
			try {
				sleep(1000);
				if(corriendo) {
					contador++;
					lblContador.setText(nombre + ": "+ contador);
				}
			}catch(InterruptedException error) {
				Thread.currentThread().interrupt();
			}
		}
	}

	
	/**
	 * Metodo creado para actualizar la prioridad de cada hilo y añadiendolo en el lblPrioridad
	 */
	private void actualizarPrioridad() {

		lblPrioridad.setText("Pri: " + getPriority());
	}
	
	/**
	 * Metodo creado para establecer la prioridad maxima de un hilo
	 */
	public void establecerPrioridadMaxima() {
		//le agrego la maxima prioridad y añado el metodo actualizarPrioridad
		setPriority(MAX_PRIORITY);
		actualizarPrioridad();
	}
	
	/**
	 * Metodo creado para establecer la prioridad minima de un hilo
	 */
	public void establecerPrioridadMinima() {
		setPriority(MIN_PRIORITY);
		actualizarPrioridad();
	}
	
	/**
	 * Metodo creado para finalizar los hilos
	 */
	public void finalizar() {
		this.corriendo = false;
	}
	

}
