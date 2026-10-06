package ejercicios_1.Ejercicio3;

public class Principal extends Thread{

	private static Escritora hilo1 = new Escritora(false);
	private static Escritora hilo2 = new Escritora(true);
	/**
	 * con el main ejecuto los hilos
	 * @param args
	 */
	public static void main(String[] args) {
		
		hilo1.start();
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
			System.out.println("Error");
		}
	}

	@Override
	/**
	 * con este metodo inicio los hilos y ejecuto sus operaciones dependiendo del boolean
	 */
	public void run() {		
		hilo1.opciones();
		hilo2.opciones();
	}
	
	

}
