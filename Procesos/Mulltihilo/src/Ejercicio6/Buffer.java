package Ejercicio6;

import java.nio.CharBuffer;

public class Buffer {


	private char contenido;
	private boolean bufferLleno = false;
	
	public Buffer() {
		
	}
	
	public synchronized void poner(char c) {
		while(bufferLleno) {
			try {
				wait();
		}catch(InterruptedException error) {
			Thread.currentThread().interrupt();
			error.printStackTrace();
		}
	}
		contenido = c;
		bufferLleno = true;
		notifyAll();
}
	
	public synchronized char recoger() {
		
		while(!bufferLleno) {
			try {
				wait();
		}catch(InterruptedException error) {
			Thread.currentThread().interrupt();
			error.printStackTrace();
		}
	}
		char c = contenido;
		bufferLleno = false;
		notifyAll();
		return c;
	}

	@Override
	public String toString() {
		return "Buffer [contenido=" + contenido + ", bufferLleno=" + bufferLleno + "]";
	}
}
