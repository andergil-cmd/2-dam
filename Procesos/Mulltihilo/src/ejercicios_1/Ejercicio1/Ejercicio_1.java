package ejercicios_1.Ejercicio1;

public class Ejercicio_1 extends Thread{

	public Ejercicio_1() {
		super();
	}
	
	@Override
	/**
	 * Con este metodo iniciamos los hilos y ejecutan el metodo contar
	 */
	public void run() {
		contar();
	}

	/**
	 * Este metodo crea un bucle para contar hasta 1000
	 * @ for
	 */
	public void contar() {
			//creo un bucle for para contar hasta 1000
			for(int i = 1; i <= 1000; i++) {
				System.out.println(i);
				try {
					sleep(100);
				}catch(InterruptedException error) {
					System.out.println(error.getMessage());
				}
			}
			
			System.out.println("Fin del bucle");
	}

	/**
	 * En el main creamos los hilos y los iniciamos
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * inicializo los objetos
		 */
		Ejercicio_1 hilo1 = new Ejercicio_1();
		Ejercicio_1 hilo2 = new Ejercicio_1();
		
		/**
		 * los objetos los paso a hilos y los inicio
		 */
		hilo1.start();
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}
		
	}

	


}
