package Ejercicio2;

public class HiloRunnable implements Runnable {

	private String nombre;

	/**
	 * Constructor de la clase HiloRunnable
	 * @param nombre identificativo del Hilo
	 */
	public HiloRunnable(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	/**
	 * Con este metodo inicias los hilos y inicia el metodo bucle
	 */
	public void run() {
		bucle();
	}

	/**
	 * Este metodo crea un bucle
	 */
	public void bucle() {
		for (int i = 0; i <= 20; i++) {
			System.out.println(i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException error) {
				error.printStackTrace();
			}
		}
	}

	/**
	 * En el main creamos los hilos y los iniciamos
	 * @param args
	 */
	public static void main(String[] args) {

		// creo los objetos
		HiloRunnable contendido1 = new HiloRunnable("Hilo 1");
		HiloRunnable contenido2 = new HiloRunnable("Hilo 2");

		// inicializo los objetos como hilos
		Thread hilo1 = new Thread(contendido1);
		Thread hilo2 = new Thread(contenido2);
		
		//Inicio los hilos
		hilo1.start();
		hilo2.start();
		

		try {
			// junto los hilos para que se ejecuten en paralelo
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException error) {
			System.out.println(error.getMessage());
		}
		
		//si los hilos no estan activos el hilo termina
		if (!hilo1.isAlive() || !hilo2.isAlive()) {
			System.out.println("Los hilos han terminado");
		}else {
			System.out.println("Los hilos continuan");
		}
	}

}
