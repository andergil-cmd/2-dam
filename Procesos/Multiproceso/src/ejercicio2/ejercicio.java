package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ejercicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTaskmgr;
	private JTextField tfIpconfig;
	private JTextField tfPrueba;
	private JButton btnStartTaskmgr;
	private JButton btnStartIpconfig;
	private JButton btnStartPrueba;
	
	private static Scanner teclado;
	
	private JTextArea taCadena;
	private JTextArea taInformacion;
	private JLabel lblPIDTaskmgr;
	private JLabel lblPIDPadreTaskmgr;
	private JLabel lblPIDIpconfig;
	private JLabel lblPIDPPadreIpconfig;
	private JLabel lblPIDPrueba;
	private JLabel lblPIDPadrePrueba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		teclado = new Scanner(System.in);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio frame = new ejercicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Inicializamos los diferentes componentes del JFrame
	 */
	public ejercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfTaskmgr = new JTextField();
		tfTaskmgr.setBounds(106, 73, 106, 20);
		contentPane.add(tfTaskmgr);
		tfTaskmgr.setColumns(10);
		
		tfIpconfig = new JTextField();
		tfIpconfig.setColumns(10);
		tfIpconfig.setBounds(303, 73, 106, 20);
		contentPane.add(tfIpconfig);
		
		tfPrueba = new JTextField();
		tfPrueba.setColumns(10);
		tfPrueba.setBounds(478, 73, 106, 20);
		contentPane.add(tfPrueba);
		
		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(24, 170, 24, 14);
		contentPane.add(lblPID);
		
		JLabel lblPIDPADRE = new JLabel("PID Padre");
		lblPIDPADRE.setBounds(24, 208, 48, 14);
		contentPane.add(lblPIDPADRE);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(24, 272, 48, 14);
		contentPane.add(lblResultado);
		
		taCadena = new JTextArea();
		taCadena.setBounds(449, 267, 288, 232);
		contentPane.add(taCadena);
		
		taInformacion = new JTextArea();
		taInformacion.setBounds(151, 267, 288, 232);
		taInformacion.setEditable(true);
		contentPane.add(taInformacion);
		
		btnStartTaskmgr = new JButton("Start");
		btnStartTaskmgr.addActionListener(this);
		btnStartTaskmgr.setBounds(116, 121, 89, 23);
		contentPane.add(btnStartTaskmgr);
		
		btnStartIpconfig = new JButton("Start");
		btnStartIpconfig.addActionListener(this);
		btnStartIpconfig.setBounds(309, 121, 89, 23);
		contentPane.add(btnStartIpconfig);
		
		btnStartPrueba = new JButton("Start");
		btnStartPrueba.addActionListener(this);
		btnStartPrueba.setBounds(483, 121, 89, 23);
		contentPane.add(btnStartPrueba);
		
		lblPIDTaskmgr = new JLabel("");
		lblPIDTaskmgr.setBounds(135, 170, 46, 14);
		contentPane.add(lblPIDTaskmgr);
		
		lblPIDPadreTaskmgr = new JLabel("");
		lblPIDPadreTaskmgr.setBounds(135, 208, 46, 14);
		contentPane.add(lblPIDPadreTaskmgr);
		
		lblPIDIpconfig = new JLabel("");
		lblPIDIpconfig.setBounds(331, 170, 46, 14);
		contentPane.add(lblPIDIpconfig);
		
		lblPIDPPadreIpconfig = new JLabel("");
		lblPIDPPadreIpconfig.setBounds(331, 208, 46, 14);
		contentPane.add(lblPIDPPadreIpconfig);
		
		lblPIDPrueba = new JLabel("");
		lblPIDPrueba.setBounds(507, 170, 46, 14);
		contentPane.add(lblPIDPrueba);
		
		lblPIDPadrePrueba = new JLabel("");
		lblPIDPadrePrueba.setBounds(507, 208, 46, 14);
		contentPane.add(lblPIDPadrePrueba);

	}
	
	/**
	 * Metodo creado para iniciar el comando taskmgr y obtener el pid del proceso
	 * IOException
	 */
	public void iniciarTaskmgr() {
		System.out.println("Iniciando el comando Taskmgr");
		
		try {
			String [] arrayComando = {"taskmgr.exe"};
			
			Process proceso = Runtime.getRuntime().exec(arrayComando);	
			
			long pidHijo = proceso.pid();
			lblPIDTaskmgr.setText(String.valueOf(pidHijo));
			System.out.println("PID de Taskmgr: " +pidHijo);
			
			ProcessHandle manejador = ProcessHandle.current();
			long pidPadre = manejador.pid();
			lblPIDPadreTaskmgr.setText(String.valueOf(pidPadre));
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}
	
	/**
	 * Metodo creado para iniciar el comando ipconfig y obtener el pid del proceso
	 * Añado el resultado del comando en el TextArea taInformacion
	 * IOException 
	 */
	public void iniciarIpconfig() {
		System.out.println("Iniciando el comando Ipconfig");
		
		String comando = "ipconfig";
		
		try {
			String [] arrayComando = {"ipconfig"};
			Process proceso = Runtime.getRuntime().exec(arrayComando);
			
			long pidHijo = proceso.pid();
			lblPIDIpconfig.setText(String.valueOf(pidHijo));
			System.out.println("PID de Ipconfig: " +pidHijo);
			
			ProcessHandle manejador = ProcessHandle.current();
			long pidPadre = manejador.pid();
			lblPIDPPadreIpconfig.setText(String.valueOf(pidPadre));
			
			OutputStream entrada = proceso.getOutputStream();
			
			entrada.write(comando.getBytes());
			entrada.flush();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
				taInformacion.append(linea + "\n");
			}
			
			entrada.close();
			
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
	}
	
	
	/**
	 * Metodo creado para llamar 5 veces al programa EjemploLectura y obtener su pid 
	 * Añado el resultado al TextArea taCadena
	 * IOException
	 */
	public void iniciarPrueba() {
		teclado = new Scanner(System.in);
		
		System.out.println("Introduce una cadena: ");
		String texto = teclado.nextLine();
		
		teclado.close();
		
		taCadena.setText("");
		
		for(int i = 1; i <= 5; i++) {
		
			taCadena.append("Introduce una cadena:" + "\n" +texto + "\n");
		
		try {
			ProcessBuilder constructor = new ProcessBuilder("java", "Notepad.EjemploLectura");
			
			Process proceso = constructor.start();
			
			long pidHijo = proceso.pid();
			lblPIDPrueba.setText(String.valueOf(pidHijo));
			System.out.println("PID de Prueba: " + pidHijo);
			
			ProcessHandle manejador = ProcessHandle.current();
			long pidPadre = manejador.pid();
			lblPIDPadrePrueba.setText(String.valueOf(pidPadre));
			
			OutputStream entrada = proceso.getOutputStream();
			
			PrintWriter escritor = new PrintWriter(entrada);
			
			escritor.print(texto);
			escritor.flush();
			escritor.close();
			
			BufferedReader lectura = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			
			while((linea = lectura.readLine()) != null) {
				System.out.println(linea);
				
			}
			
			lectura.close();
			
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del proceso con el codigo " +codigoRetorno);
			
		}catch(IOException | InterruptedException  error) {
			System.out.println(error.getMessage());
		}
	}
	
	}
	
	/**
	 * Metodo creado para añadir funciones a los botones y asi usar los metodos creados anteriormente
	 * ActionEvent evento
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {

		if(evento.getSource() == btnStartTaskmgr) {
			iniciarTaskmgr();
			tfTaskmgr.setText("taskmgr");
		}
		
		if(evento.getSource() == btnStartIpconfig) {
			iniciarIpconfig();
			tfIpconfig.setText("ipconfig");
		}
		
		if(evento.getSource() == btnStartPrueba) {
			iniciarPrueba();
			tfPrueba.setText("prueba");
		}
	}
}
