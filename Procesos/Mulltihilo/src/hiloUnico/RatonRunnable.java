package hiloUnico;

public class RatonRunnable implements Runnable{
	private String nombre = "";
	private int tiempo = 0;
	

	public RatonRunnable(String nombre, int tiempo) {
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
		
		RatonRunnable raton1 = new RatonRunnable ("1", 4);
		RatonRunnable raton2 = new RatonRunnable("2", 2);
		RatonRunnable raton3 = new RatonRunnable("3", 5);

		//se utiliza start porque es lo que permite que los threads ocurran
		new Thread(raton1).start();
		new Thread(raton2).start();
		new Thread(raton3).start();
		
		try {
			new Thread(raton1).join();
			new Thread(raton2).join();
			new Thread(raton3).join();
		}catch(InterruptedException error) {
			error.printStackTrace();
		}
		

		System.out.printf("Todos los ratones han comido %n");
		
	}

	@Override
	public void run() {
		comer();
		
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}
