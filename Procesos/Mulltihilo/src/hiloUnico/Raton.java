package hiloUnico;

public class Raton extends Thread{

	@Override
	public void run() {
		comer();
	}

	private String nombre = "";
	private int tiempo = 0;

	public Raton(String nombre, int tiempo) {
		super();
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	public void comer() {
		try {
			System.out.printf("El Raton %s empieza a comer %n", nombre);
			Thread.sleep(tiempo * 1000);
			System.out.printf("El Raton %s ha terminado de comer %n", nombre);
		} catch (InterruptedException error) {
			error.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Raton raton1 = new Raton("1", 4);
		Raton raton2 = new Raton("2", 6);
		Raton raton3 = new Raton("3", 2);

		raton1.setPriority(MAX_PRIORITY);
		raton2.setPriority(MIN_PRIORITY);
		raton3.setPriority(NORM_PRIORITY);
		
		
		raton1.start();//se utiliza start porque es lo que permite que los threads ocurran
		raton2.start();
		raton3.start();
		
		try {
			raton1.join();
			raton2.join();
			raton3.join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}

		System.out.printf("Todos los ratones han comido %n");

	}

}