package ejercicios_1;

public class HiloThread extends Thread{

	private String nombre;
	
	/**
	 * constructor de HiloThread
	 * @param nombre identificativo del hilo
	 */
	public HiloThread(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	@Override
	/**
	 *Este metodo inicia los hilos con el bucle implementado
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
		//Inicializo los objetos
		HiloThread hilo1 = new HiloThread("Hilo 1");
		HiloThread hilo2 = new HiloThread("Hilo 2");
		
		//Inicio los objetos como hilos
		hilo1.start();
		hilo2.start();
		
		//Junto los hilos para que se ejecuten en paralelo
		try {
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}
		
		//compruebp si han terminado los hilos
		if(!hilo1.isAlive() || !hilo2.isAlive()) {
			System.out.println("Hilos terminados");
		}else {
			System.out.println("Los hilos continuan");
		}
	}

}
