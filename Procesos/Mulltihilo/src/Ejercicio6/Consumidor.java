package Ejercicio6;

public class Consumidor extends Thread{

	private Buffer buffer;
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char caracter = buffer.recoger();
			System.out.println("Consumidor recogio: " +caracter);
			try {
				sleep(200);
			} catch (InterruptedException error) {
				Thread.currentThread().interrupt();
				error.printStackTrace();
			}
		}
	}



}
