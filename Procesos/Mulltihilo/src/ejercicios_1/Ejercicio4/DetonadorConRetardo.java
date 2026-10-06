package ejercicios_1.Ejercicio4;

public class DetonadorConRetardo extends Thread{

	private String nombre;
	private int contador;
	
	public DetonadorConRetardo(String nombre, int contador) {
		super();
		this.nombre = nombre;
		this.contador = contador;
	}
	
	public void run() {
		reducirContador();
	}
	
	public void reducirContador() {
		System.out.println(nombre);
		do {
			System.out.println(contador);
			contador--;
		}while(contador != 0);
		System.out.println("La tarea ha sido terminada");
	}
	

}
