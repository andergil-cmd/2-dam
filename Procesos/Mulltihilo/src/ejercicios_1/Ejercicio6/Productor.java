package ejercicios_1.Ejercicio6;

import java.util.Random;

public class Productor extends Thread {

	private Buffer buffer;
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		
		
		for (int i = 0; i < 10; i++) {
			int indiceAleatorio = random.nextInt(abecedario.length());
			char caracter = abecedario.charAt(indiceAleatorio);
			buffer.poner(caracter);
			System.out.println(buffer);
			try {
				sleep(100);
				
			} catch (InterruptedException error) {
				Thread.currentThread().interrupt();
				error.printStackTrace();
			}
		}
		
		
	}



}
