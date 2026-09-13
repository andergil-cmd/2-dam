package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel menuPrincipal;
	private JButton btnCargarMensajes;
	private JButton btnGuardarMensajes;
	private JButton btnImprimirMensajes;
	private JButton btnAñadirMensajes;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 553);
		menuPrincipal = new JPanel();
		
		menuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menuPrincipal);
		
		btnCargarMensajes = new JButton("Cargar mensajes");
		btnCargarMensajes.setBounds(27, 41, 125, 29);
		btnCargarMensajes.addActionListener(this);
		menuPrincipal.setLayout(null);
		menuPrincipal.add(btnCargarMensajes);
		
		btnGuardarMensajes = new JButton("Guardar mensajes");
		btnGuardarMensajes.setBounds(217, 41, 125, 29);
		btnGuardarMensajes.addActionListener(this);
		menuPrincipal.add(btnGuardarMensajes);
		
		btnImprimirMensajes = new JButton("Imprimir mensajes");
		btnImprimirMensajes.setBounds(217, 85, 125, 29);
		btnImprimirMensajes.addActionListener(this);
		menuPrincipal.add(btnImprimirMensajes);
		
		btnAñadirMensajes = new JButton("Añadir mensajes");
		btnAñadirMensajes.setBounds(27, 167, 125, 23);
		btnAñadirMensajes.addActionListener(this);
		menuPrincipal.add(btnAñadirMensajes);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(228, 226, 89, 23);
		btnSalir.addActionListener(this);
		menuPrincipal.add(btnSalir);

	}
	
	public static void escribirMensajes() {
		
		String rutaFichero = "src/ficheros/Mensajes.txt";
		
		File fichero = null;
		
		BufferedWriter escritorFichero = null;
		
		try {
			fichero = new File(rutaFichero);
			escritorFichero = new BufferedWriter(new FileWriter(fichero));
			
			escritorFichero.write("fecha: 2021-03-04");
			escritorFichero.newLine();
			escritorFichero.write("hora: 10:45");
			escritorFichero.newLine();
			escritorFichero.write("para: Aner");
			escritorFichero.newLine();
			escritorFichero.write("de: Eneritz");
			escritorFichero.newLine();
			escritorFichero.write("asunto: Quedada");
			escritorFichero.newLine();
			escritorFichero.write("contenido: A las 5 de la tarde en la puerta del teatro.");
			escritorFichero.newLine();
			
			escritorFichero.write("******************");
			escritorFichero.newLine();
			
			escritorFichero.write("fecha: 2021-01-31");
			escritorFichero.newLine();
			escritorFichero.write("hora: 12:15");
			escritorFichero.newLine();
			escritorFichero.write("para: Eneritz");
			escritorFichero.newLine();
			escritorFichero.write("de: Aner");
			escritorFichero.newLine();
			escritorFichero.write("asunto: Respuesta");
			escritorFichero.newLine();
			escritorFichero.write("contenido: Ok.");
			escritorFichero.newLine();
			
			escritorFichero.write("******************");
			escritorFichero.newLine();
			
			System.out.println("El fichero se ha escrito correctamente");
			
		}catch(IOException error) {
			error.printStackTrace();
		}
		finally {
			try {
				escritorFichero.close();
			}catch(IOException error) {
				error.printStackTrace();
			}
		}
	}
	
	private void cargarFichero() {
		ArrayList<String> listaMensajes = new ArrayList<>();
		
		String rutaFichero = "src/ficheros/Mensajes.txt";
		
		BufferedReader lectorFichero = null;
		
		try {
			lectorFichero = new BufferedReader(new FileReader(rutaFichero));
			
			String linea;
			
			while((linea= lectorFichero.readLine()) != null) {
				listaMensajes.add(linea);
			}
		}catch(IOException error) {
			System.out.println("Error al leer el archivo:" + error.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if(evento.getSource() == btnCargarMensajes) {
			cargarFichero();
			
		}
		
		if(evento.getSource() == btnGuardarMensajes) {
			
		}
		
		if(evento.getSource() == btnImprimirMensajes) {
			
		}
		
		if(evento.getSource() == btnAñadirMensajes) {
			
		}
		
		if(evento.getSource() == btnSalir) {
			
		}
	}
}
