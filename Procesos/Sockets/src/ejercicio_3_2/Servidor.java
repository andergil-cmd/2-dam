package ejercicio_3_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		Socket socketServicio;
		int numeroPuerto = 50000;
		InetAddress ip = null;
		DataInputStream entradaCliente;
		DataOutputStream salidaCliente;
		int contador = 1;
		try {
			 ip = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			servidor = new ServerSocket(numeroPuerto, 100, ip);
			do {
				socketServicio = servidor.accept();
				entradaCliente = new DataInputStream(socketServicio.getInputStream());
				salidaCliente = new DataOutputStream(socketServicio.getOutputStream());
				socketServicio.setSoTimeout(1000);
				salidaCliente.writeUTF("saludos desde el servidor al cliente no: " + contador);
				String textoRecibido = entradaCliente.readUTF();
				System.out.println(textoRecibido);
				System.out.println("Recibido ------");
				contador++;
			}while(contador != 3);
			
			System.out.println("Demasiados clientes por hoy");
	
			
		}catch(IOException error) {
			error.printStackTrace();
		}
	}

}
