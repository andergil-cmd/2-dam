package ejercicio_3_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		
		Socket cliente = null;
		int numeroPuerto = 50000;
		InetAddress ip = null;
		DataOutputStream salida;
		DataInputStream entrada;
		try {
			 ip = InetAddress.getByName("127.0.0.1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cliente = new Socket(ip, numeroPuerto);
			
			salida = new DataOutputStream(cliente.getOutputStream());
			if(cliente.isConnected()) {
				System.out.println("Conexion realizada con el servidor");
				salida.writeUTF("Hola servidor, soy un cliente");
			}
			
			entrada = new DataInputStream(cliente.getInputStream());
			
			String textoRecibido = entrada.readUTF();
		System.out.println(textoRecibido);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
