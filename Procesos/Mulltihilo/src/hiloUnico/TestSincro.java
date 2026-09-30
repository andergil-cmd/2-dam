package hiloUnico;

public class TestSincro extends Thread{

	private int cant = 0;
	private String nom = null;
	private volatile static int cajero = 40;
	
	public TestSincro(int cant, String nom) {
		super();
		this.cant = cant;
		this.nom = nom;
	}
	
	public void RetirarDinero(int cant, String nom) {
	
		if(cajero >= cant) {
			System.out.printf("%s comprueba el saldo: SÍ hay dinero suficiente (%d€). Se prepara para retirar...%n", nom, cajero);			
			cajero -= cant;
			System.out.printf("Retirada completada. Quedan un total de %d€ en el cajero.%n%n", cajero);
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException error) {
				error.printStackTrace();
			}
			 cajero -= cant;
	            System.out.printf("¡%s ha sacado %d€! Saldo actual de la cuenta: %d€%n%n", nom, cant, cajero);
	        } else {
	            System.out.printf("Lo sentimos %s, no hay saldo suficiente (%d€) para retirar %d€.%n%n", nom, cajero, cant);
	        }
	    }
	
	public synchronized void retirarDinero(int cant, String nom) {
		if (cajero >= cant) {
            System.out.printf("%s comprueba el saldo: SÍ hay dinero suficiente (%d€). Se prepara para retirar...%n", nom, cajero);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cajero -= cant;
            System.out.printf("¡%s ha sacado %d€! Saldo actual de la cuenta: %d€%n%n", nom, cant, cajero);
        } else {
            System.out.printf("Lo sentimos %s, no hay saldo suficiente (%d€) para retirar %d€.%n%n", nom, cajero, cant);
        }
		
	}

	@Override
	public void run() {
		RetirarDinero(cant, nom);
		retirarDinero(cant, nom);		
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static void main(String[] args) {
		TestSincro jon = new TestSincro(40, "Jon");
		TestSincro ander = new TestSincro(30, "Ander");

		
		jon.start();
		ander.start();
		
		
		
	}

}
