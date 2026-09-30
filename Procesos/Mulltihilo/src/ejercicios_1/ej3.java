package ejercicios_1;

public class ej3 extends Thread{

	private String nombre;
	
	public ej3(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	@Override
	/**
	 * Con este metodo inicio los hilos y ejecuto las operaciones
	 */
	public void run() {
		operaciones();
	}
	
	/**
	 * con este metodo creo un bucle para que hagan 3 operaciones
	 */
	public void operaciones() {
		for (int i = 0; i < 3; i++) {
			int v = i + 1;
			System.out.println("operacion " +v);
			try {
				sleep(10);
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

		//inicio los objetos
		ej3 hilo1 = new ej3("Jon");
		ej3 hilo2 = new ej3("Ander");
		
		//inicio los objetos como hilos
		hilo1.start();
		hilo2.start();
		
		//junto los hilos para que se ejcuten en paralelo
		try {
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}
	}

}
