package ejercicios_1.Ejercicio3;

public class Escritora extends Thread{

	private boolean escritura = false;

	/**
	 * Constructor de Escritora
	 * @param escritura opcion para que los hilos hagan diferentes operaciones
	 */
	public Escritora(boolean escritura) {
		super();
		this.escritura = escritura;
	}

	@Override
	/**
	 * con este metodo ejecutas el metodo opciones
	 */
	public void run() {
		opciones();
	}

	/**
	 * dependiendo de si escritura es true escriba numeros y si es false escriba letras
	 */
	public void opciones() {
				
		if (escritura == true) {
			for (int i = 1; i <= 30; i++) {
				System.out.println(i);
			}
		} else {
			for(char i = 'a'; i <= 'z'; i++) {
				System.out.println(i + " ");
			}
		}

	}

}
