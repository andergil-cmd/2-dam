package EjercicioFicherosBinarios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EjerBinario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEquipoVisitante;
	private JTextField tfEquipoLocal;
	private JTextField tfGolesLocal;
	private JTextField tfGolesVisitante;
	private JTextField tfLugar;
	private JTextField tfFecha;
	private JButton btnAñadir;
	private JButton btnCargar;
	private JButton btnGuardar;
	
	// Esta lista mantendrá los datos actuales que no han sido guardados todavía
	private ArrayList<String> listaNuevosResultados = new ArrayList<>();
	// Esta lista mantendrá el historial total visible en la tabla
	private ArrayList<String> listaResultadosHistoricos = new ArrayList<>();
	
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JScrollPane panelTabla;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjerBinario frame = new EjerBinario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EjerBinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setBounds(10, 29, 67, 14);
		contentPane.add(lblEquipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setBounds(10, 54, 82, 14);
		contentPane.add(lblEquipoVisitante);
		
		JLabel lblGolesLocal = new JLabel("Goles Local");
		lblGolesLocal.setBounds(10, 79, 58, 14);
		contentPane.add(lblGolesLocal);
		
		JLabel lblGolesVisitante = new JLabel("Goles Visitante");
		lblGolesVisitante.setBounds(10, 104, 76, 14);
		contentPane.add(lblGolesVisitante);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 129, 35, 14);
		contentPane.add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 154, 35, 14);
		contentPane.add(lblFecha);
		
		tfEquipoVisitante = new JTextField();
		tfEquipoVisitante.setBounds(102, 51, 150, 20);
		contentPane.add(tfEquipoVisitante);
		tfEquipoVisitante.setColumns(10);
		
		tfEquipoLocal = new JTextField();
		tfEquipoLocal.setColumns(10);
		tfEquipoLocal.setBounds(102, 26, 150, 20);
		contentPane.add(tfEquipoLocal);
		
		tfGolesLocal = new JTextField();
		tfGolesLocal.setColumns(10);
		tfGolesLocal.setBounds(102, 76, 150, 20);
		contentPane.add(tfGolesLocal);
		
		tfGolesVisitante = new JTextField();
		tfGolesVisitante.setColumns(10);
		tfGolesVisitante.setBounds(102, 101, 150, 20);
		contentPane.add(tfGolesVisitante);
		
		tfLugar = new JTextField();
		tfLugar.setColumns(10);
		tfLugar.setBounds(102, 126, 150, 20);
		contentPane.add(tfLugar);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(102, 151, 150, 20);
		contentPane.add(tfFecha);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(this);
		btnAñadir.setBounds(10, 204, 89, 23);
		contentPane.add(btnAñadir);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(this);
		btnCargar.setBounds(109, 204, 89, 23);
		contentPane.add(btnCargar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(208, 204, 89, 23);
		contentPane.add(btnGuardar);
		
		String[] columnas = { "Eq. Local", "Eq. Visitante", "G. Local", "G. Visitante", "Lugar", "Fecha"};
		modeloTabla = new DefaultTableModel(columnas, 0);
		
		tabla = new JTable(modeloTabla);
		panelTabla = new JScrollPane(tabla);
		panelTabla.setBounds(23, 254, 312, 202);
		contentPane.add(panelTabla);
	} 
	
	/**
	 * Metodo creado para validar que los datos sea 
	 * @return validado
	 */
	private boolean validarDatos() {
		boolean validado = true;
		
		if (tfEquipoLocal.getText().trim().isEmpty() || tfEquipoLocal.getText().length() > 20 ||
			tfEquipoVisitante.getText().trim().isEmpty() || tfEquipoVisitante.getText().length() > 20 ||
			tfLugar.getText().trim().isEmpty() || tfLugar.getText().length() > 20) {
			JOptionPane.showMessageDialog(this, "Equipos y Lugar deben tener entre 1 y 20 caracteres.");
			validado = false;
		}
		
		try {
			int gLocal = Integer.parseInt(tfGolesLocal.getText().trim());
			int gVisit = Integer.parseInt(tfGolesVisitante.getText().trim());
			if (gLocal < 0 || gLocal > 99 || gVisit < 0 || gVisit > 99) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Goles deben ser números de 1 o 2 dígitos.");
			validado = false;
		}
		
		if (!tfFecha.getText().trim().matches("\\d{2}/\\d{2}/\\d{2}")) {
			JOptionPane.showMessageDialog(this, "La fecha debe cumplir el formato dd/MM/yy.");
			validado = false;
		}
		
		return validado;
	}

	/**
	 * Metodo creado para vaciar los campos
	 */
	private void limpiarCampos() {
		tfEquipoLocal.setText("");
		tfEquipoVisitante.setText("");
		tfGolesLocal.setText("");
		tfGolesVisitante.setText("");
		tfLugar.setText("");
		tfFecha.setText("");
	}

	/**
	 * Metodo creado para añadir las columnas a la lista
	 */
	private void actualizarTablaDesdeArrayList() {
		modeloTabla.setRowCount(0);
		for (int i = 0; i < listaResultadosHistoricos.size(); i += 6) {
			if (i + 5 < listaResultadosHistoricos.size()) {
				String[] fila = {
					listaResultadosHistoricos.get(i),
					listaResultadosHistoricos.get(i + 1),
					listaResultadosHistoricos.get(i + 2),
					listaResultadosHistoricos.get(i + 3),
					listaResultadosHistoricos.get(i + 4),
					listaResultadosHistoricos.get(i + 5)
				};
				modeloTabla.addRow(fila);
			}
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		
		/**
		 * Añado los datos de los campos introducios al arrayList de los nuevos resultados y los añado tambien a
		 * un array que es el array del Historial para que no se pierdan
		 */
		if(evento.getSource() == btnAñadir) {
			if(validarDatos()) {
				// 1. Guardamos en la lista temporal de nuevos datos para el fichero
				listaNuevosResultados.add(tfEquipoLocal.getText().trim());
				listaNuevosResultados.add("\n");
				listaNuevosResultados.add(tfEquipoVisitante.getText().trim());
				listaNuevosResultados.add("\n");
				listaNuevosResultados.add(tfGolesLocal.getText().trim());
				listaNuevosResultados.add("\n");
				listaNuevosResultados.add(tfGolesVisitante.getText().trim());
				listaNuevosResultados.add("\n");
				listaNuevosResultados.add(tfLugar.getText().trim());		
				listaNuevosResultados.add("\n");
				listaNuevosResultados.add(tfFecha.getText().trim());
				
				// 2. También los añadimos al historial visual de la tabla
				listaResultadosHistoricos.add(tfEquipoLocal.getText().trim());
				listaNuevosResultados.add("\n");
				listaResultadosHistoricos.add(tfEquipoVisitante.getText().trim());
				listaNuevosResultados.add("\n");
				listaResultadosHistoricos.add(tfGolesLocal.getText().trim());
				listaNuevosResultados.add("\n");
				listaResultadosHistoricos.add(tfGolesVisitante.getText().trim());
				listaNuevosResultados.add("\n");
				listaResultadosHistoricos.add(tfLugar.getText().trim());
				listaNuevosResultados.add("\n");
				listaResultadosHistoricos.add(tfFecha.getText().trim());
				
				actualizarTablaDesdeArrayList();
				limpiarCampos();
			}
		}

		/**
		 * Cargo los datos del fichero en la tabla
		 * He usado DataInputStream para leer los datos mostrarlos en la tabla
		 */
		if(evento.getSource() == btnCargar) {
			File fichero = new File("src/ficheroBinario/Resultados.dat");
			if (!fichero.exists()) {
				JOptionPane.showMessageDialog(this, "No existe el fichero Resultados.dat todavía.");
				return;
			}
			
			listaResultadosHistoricos.clear();
			listaNuevosResultados.clear(); 
			
			try {
				DataInputStream lector_datos = new DataInputStream(new FileInputStream(fichero));
				while (lector_datos.available() > 0) {
					listaResultadosHistoricos.add(lector_datos.readUTF()); 
				}
				actualizarTablaDesdeArrayList();
				JOptionPane.showMessageDialog(this, "Datos cargados desde el fichero a la memoria.");
			} catch (IOException error) {
			
				System.out.println("Error al cargar archivo: " + error.getMessage());
			}
		}
		
		/**
		 * Guardo los datos de los campos ya introducidos en el fichero
		 * uso DataOutputStream para enviar los datos al fichero y ir escribiendo nuevos datos
		 */
		if(evento.getSource() == btnGuardar) {
			File fichero = new File("src/ficheroBinario/Resultados.dat");
			
			// Crear los directorios padres si no existen
			if (fichero.getParentFile() != null && !fichero.getParentFile().exists()) {
			    fichero.getParentFile().mkdirs(); 
			}
			
			try {
				DataOutputStream escritor_datos = new DataOutputStream(new FileOutputStream(fichero, true));
				
				for (int i = 0; i < listaNuevosResultados.size(); i++) {
					escritor_datos.writeUTF(listaNuevosResultados.get(i));
				}
				
				listaNuevosResultados.clear();
				escritor_datos.close();
				
				JOptionPane.showMessageDialog(this, "Nuevos datos añadidos con éxito al fichero Resultados.dat.");
			} catch (IOException error) {
				System.out.println("Error al guardar archivo: " + error.getMessage());
			}
		}
	}
}
