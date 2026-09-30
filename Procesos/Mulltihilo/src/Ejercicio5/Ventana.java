package Ejercicio5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnMenos_1;
	private JButton btnMenos_2;
	private JButton btnMenos_3;
	
	private JButton btnMas_1;
	private JButton btnMas_2;
	private JButton btnMas_3;
	
	private JButton btnFinHilo_1;
	private JButton btnFinHilo_2;
	private JButton btnFinHilo_3;
	private JButton btnFinalizarTodos;
	
	private HiloContador hilo1;
	private HiloContador hilo2;
	private HiloContador hilo3;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pnSeccion1 = new JPanel();
		
		JPanel pnSeccion2 = new JPanel();
		
		JPanel pnSeccion3 = new JPanel();
		
		btnMenos_3 = new JButton("--");
		btnMenos_3.addActionListener(this);

		pnSeccion3.add(btnMenos_3);
		
		JPanel pnSeccion4 = new JPanel();
		
		btnFinalizarTodos = new JButton("Finalizar todos");
		btnFinalizarTodos.addActionListener(this);
		pnSeccion4.add(btnFinalizarTodos);
		
		btnMenos_2 = new JButton("--");
		btnMenos_2.addActionListener(this);
		pnSeccion2.add(btnMenos_2);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnMenos_1 = new JButton("--");
		btnMenos_1.addActionListener(this);
		pnSeccion1.add(btnMenos_1);
		
		btnFinHilo_1 = new JButton("Fin hilo 1");
		btnFinHilo_1.addActionListener(this);

		pnSeccion1.add(btnFinHilo_1);
		
		btnMas_1 = new JButton("++");
		btnMas_1.addActionListener(this);

		pnSeccion1.add(btnMas_1);
		contentPane.add(pnSeccion1);
		contentPane.add(pnSeccion2);
		
		btnFinHilo_2 = new JButton("Fin hilo 2");
		btnFinHilo_2.addActionListener(this);
		pnSeccion2.add(btnFinHilo_2);
		
		btnMas_2 = new JButton("++");
		btnMas_2.addActionListener(this);
		pnSeccion2.add(btnMas_2);
		
		contentPane.add(pnSeccion3);
		
		btnFinHilo_3 = new JButton("Fin hilo 3");
		btnFinHilo_3.addActionListener(this);
		pnSeccion3.add(btnFinHilo_3);
		
		btnMas_3 = new JButton("++");
		btnMas_3.addActionListener(this);

		pnSeccion3.add(btnMas_3);
		contentPane.add(pnSeccion4);
		
		JPanel pnSeccion5 = new JPanel();
		contentPane.add(pnSeccion5);
		pnSeccion5.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnSeccion5_Hilo = new JPanel();
		pnSeccion5.add(pnSeccion5_Hilo);
		pnSeccion5_Hilo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHilo1 = new JLabel("");
		lblHilo1.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion5_Hilo.add(lblHilo1);
		
		JPanel pnSeccion5_Pri = new JPanel();
		pnSeccion5.add(pnSeccion5_Pri);
		
		JLabel lblPri_1 = new JLabel("");
		lblPri_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion5_Pri.add(lblPri_1);
		
		JPanel pnSeccion6 = new JPanel();
		contentPane.add(pnSeccion6);
		pnSeccion6.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnSeccion6_Hilo = new JPanel();
		pnSeccion6.add(pnSeccion6_Hilo);
		pnSeccion6_Hilo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHilo2 = new JLabel("");
		lblHilo2.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion6_Hilo.add(lblHilo2);
		
		JPanel pnSeccion6_Pri = new JPanel();
		pnSeccion6.add(pnSeccion6_Pri);
		
		JLabel lblPri_2 = new JLabel("");
		lblPri_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion6_Pri.add(lblPri_2);
		
		JPanel pnSeccion7 = new JPanel();
		contentPane.add(pnSeccion7);
		pnSeccion7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnSeccion7_Hilo = new JPanel();
		pnSeccion7.add(pnSeccion7_Hilo);
		pnSeccion7_Hilo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHilo3 = new JLabel("");
		lblHilo3.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion7_Hilo.add(lblHilo3);
		
		JPanel pnSeccion7_Pri = new JPanel();
		pnSeccion7.add(pnSeccion7_Pri);
		
		JLabel lblPri_3 = new JLabel("");
		lblPri_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnSeccion7_Pri.add(lblPri_3);
		
		hilo1 = new HiloContador("Hilo1", lblHilo1, lblPri_1);
		hilo2 = new HiloContador("Hilo2", lblHilo2, lblPri_2);
		hilo3 = new HiloContador("Hilo3", lblHilo3, lblPri_3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnMenos_1) {
			hilo1.establecerPrioridadMinima();
		}
		
		if(e.getSource() == btnMenos_2) {
			hilo2.establecerPrioridadMinima();
		}
		
		if(e.getSource() == btnMenos_3) {
			hilo3.establecerPrioridadMinima();
		}
		
		if(e.getSource() == btnMas_1) {
			hilo1.establecerPrioridadMaxima();
		}

		if(e.getSource() == btnMas_2) {
			hilo2.establecerPrioridadMaxima();
		}

		if(e.getSource() == btnMas_3) {
			hilo3.establecerPrioridadMaxima();
		}
		
		if(e.getSource() == btnFinHilo_1) {
			hilo1.finalizar();
		}
		
		if(e.getSource() == btnFinHilo_2) {
			hilo2.finalizar();
		}

		if(e.getSource() == btnFinHilo_3) {
			hilo3.finalizar();
		}
		
		if(e.getSource() == btnFinalizarTodos) {
			hilo1.finalizar();
			hilo2.finalizar();
			hilo3.finalizar();
		}
	}
}
