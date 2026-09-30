package Ejercicio7;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Carrera extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEmpezar;
	
	// Atributos necesarios para que el ActionListener y los hilos puedan acceder a ellos
	private JLabel lblGanador;
	private JProgressBar pbCaballo1;
	private JProgressBar pbCaballo2;
	private JProgressBar pbCaballo3;
	private JProgressBar pbCaballo4;
	
	//Declaro las trampas para poner prioridades a los hilos
	private JSpinner trampa1;
	private JSpinner trampa2;
	private JSpinner trampa3;
	private JSpinner trampa4;
	
	private HiloCaballo[] caballos = new HiloCaballo[4];
	private boolean carreraActiva = false;
	private Thread hiloSupervisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrera frame = new Carrera();
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
	public Carrera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 15));
		
		// Inicializamos el label del ganador de forma global y centrado
		lblGanador = new JLabel("Ganador: Ninguno (Pulsa Empezar)");
		lblGanador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGanador, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		// Espaciado interno para que no se vea pegado
		panel.setLayout(new GridLayout(4, 2, 10, 15)); 
		
		//CABALLO 1
		
		JLabel lblCaballo1 = new JLabel("Caballo 1");
		lblCaballo1.setForeground(new Color(255, 128, 128));
		lblCaballo1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCaballo1);
		
		pbCaballo1 = new JProgressBar(0, 100);
		pbCaballo1.setForeground(new Color(255, 128, 128));
		// Muestra el porcentaje
		pbCaballo1.setStringPainted(true); 
		panel.add(pbCaballo1);
		
		JPanel panelTrampa1 = new JPanel();
		panelTrampa1.add(new JLabel("Prioridad:"));
		trampa1 = new JSpinner(new SpinnerNumberModel(6, 1, 10, 1)); // Por defecto 6 (Mín 1, Máx 10)
		panelTrampa1.add(trampa1);
		panel.add(panelTrampa1);
		
		//CABALLO 2

		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setForeground(new Color(0, 0, 255));
		lblCaballo2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCaballo2);
		
		pbCaballo2 = new JProgressBar(0, 100);
		pbCaballo2.setForeground(new Color(0, 0, 255));
		pbCaballo2.setStringPainted(true);
		panel.add(pbCaballo2);
		
		JPanel panelTrampa2 = new JPanel();
		panelTrampa2.add(new JLabel("Prioridad:"));
		trampa2 = new JSpinner(new SpinnerNumberModel(6, 1, 10, 1)); // Por defecto 6 (Mín 1, Máx 10)
		panelTrampa2.add(trampa2);
		panel.add(panelTrampa2);
		
		//CABALLO 3

		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setForeground(new Color(255, 0, 255));
		lblCaballo3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCaballo3);
		
		pbCaballo3 = new JProgressBar(0, 100);
		pbCaballo3.setForeground(new Color(255, 0, 255));
		pbCaballo3.setStringPainted(true);
		panel.add(pbCaballo3);
		
		JPanel panelTrampa3 = new JPanel();
		panelTrampa3.add(new JLabel("Prioridad:"));
		trampa3 = new JSpinner(new SpinnerNumberModel(6, 1, 10, 1)); // Por defecto 6 (Mín 1, Máx 10)
		panelTrampa3.add(trampa3);
		panel.add(panelTrampa3);
		
		//CABALLO 4

		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setForeground(new Color(0, 255, 0));
		lblCaballo4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCaballo4);
		
		pbCaballo4 = new JProgressBar(0, 100);
		pbCaballo4.setForeground(new Color(0, 255, 0));
		pbCaballo4.setStringPainted(true);
		panel.add(pbCaballo4);
		
		JPanel panelTrampa4 = new JPanel();
		panelTrampa4.add(new JLabel("Prioridad:"));
		trampa4 = new JSpinner(new SpinnerNumberModel(6, 1, 10, 1)); // Por defecto 6 (Mín 1, Máx 10)
		panelTrampa4.add(trampa4);
		panel.add(panelTrampa4);
		
		//BOTON EMPEZAR CARRERA
		btnEmpezar = new JButton("Empezar carrera");
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnEmpezar, BorderLayout.SOUTH);
		
		btnEmpezar.addActionListener(this);
		
		}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btnEmpezar) {
			btnEmpezar.setEnabled(false);
			lblGanador.setText("¡La carrera ha comenzado!");
			carreraActiva = true;
			
			pbCaballo1.setValue(0);
			pbCaballo2.setValue(0);
			pbCaballo3.setValue(0);
			pbCaballo4.setValue(0);
			
			caballos[0] = new HiloCaballo(pbCaballo1, "Caballo 1", lblGanador, this);
			caballos[1] = new HiloCaballo(pbCaballo2, "Caballo 2", lblGanador, this);
			caballos[2] = new HiloCaballo(pbCaballo3, "Caballo 3", lblGanador, this);
			caballos[3] = new HiloCaballo(pbCaballo4, "Caballo 4", lblGanador, this);
			
			caballos[0].setPriority((int) trampa1.getValue());
			caballos[1].setPriority((int) trampa2.getValue());
			caballos[2].setPriority((int) trampa3.getValue());
			caballos[3].setPriority((int) trampa4.getValue());
			
			for (int i = 0; i < caballos.length; i++) {
				caballos[i].start();
				
				}
			}
		}
	
	
	/**
	 * Metodo creado para detener los caballos cuando uno haya llegado al final
	 */
	public synchronized void detenerCaballos() {
		for (int i = 0; i < caballos.length; i++) {
			if(caballos[i] != null) {
				caballos[i].terminar();
			}
		}
		
		btnEmpezar.setEnabled(true);
	}
}

