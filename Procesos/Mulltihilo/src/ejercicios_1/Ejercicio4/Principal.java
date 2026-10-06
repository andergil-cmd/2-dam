package ejercicios_1.Ejercicio4;

public class Principal extends Thread{

	//inicializo los objetos
	private static DetonadorConRetardo hilo1 = new DetonadorConRetardo("Fran", 8);
	private static DetonadorConRetardo hilo2 = new DetonadorConRetardo("Luis", 12);
	private static DetonadorConRetardo hilo3 = new DetonadorConRetardo("Francisca", 21);
	private static DetonadorConRetardo hilo4 = new DetonadorConRetardo("Juan", 13);
	public static void main(String[] args) {
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}
		
		System.out.println("Todos los hilos han finalizado");
	}
	
	@Override
	public void run() {
		hilo1.reducirContador();
		hilo2.reducirContador();
		hilo3.reducirContador();
		hilo4.reducirContador();
	}

}
