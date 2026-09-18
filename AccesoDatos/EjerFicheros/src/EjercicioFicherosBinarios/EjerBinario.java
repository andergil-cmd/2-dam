package EjercicioFicherosBinarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
	
	private ArrayList<String> listaResultados = new ArrayList<>();
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JScrollPane panelTabla;


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		tabla.setBounds(23, 254, 312, 202);
		contentPane.add(tabla);
		
		panelTabla = new JScrollPane();
		panelTabla.setBounds(23, 254, 312, 202);
		contentPane.add(panelTabla);
		
		 

	}
	
	public void añadirFicheroBinario() {
		File fichero = new File("src/ficheroBinario/Resultados.dat");
		FileOutputStream escritorFichero = null;
		
		String[] columnas = { "Equipo local", "Equipo visitante", "Goles locales", "Goles visitantes", "Lugar", "Fecha"};
		
		String[][] datos = new String[listaResultados.size()][6];
		
		try {
			 escritorFichero = new FileOutputStream(fichero, true);
			 
			 escritorFichero.write(tfEquipoLocal.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 escritorFichero.write(tfEquipoVisitante.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 escritorFichero.write(tfGolesLocal.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 escritorFichero.write(tfGolesVisitante.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 escritorFichero.write(tfLugar.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 escritorFichero.write(tfFecha.getText().getBytes());
			 escritorFichero.write(System.lineSeparator().getBytes());
			 
			 escritorFichero.close();		 
			 
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}
		
		
	}
	
	public void añadir_Fichero_a_Array(){
		String rutaFichero = "src/ficheroBinario/Resultados.dat";
		listaResultados.clear();
		FileInputStream input = null;
		BufferedReader lector = null;
		
		try {
			input = new FileInputStream(rutaFichero);
			
			lector = new BufferedReader(new InputStreamReader(input));
			
			String linea;
			
			while((linea = lector.readLine())!= null) {
				listaResultados.add(linea);
			}
			
			 System.out.println("Datos cargados correctamente en el ArrayList.");
	         System.out.println("Contenido: " + listaResultados);

			
		}catch(IOException error) {
            System.out.println("Ocurrió un error al leer el archivo: " + error.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource()== btnAñadir) {
			
			añadirFicheroBinario();
						
			String[] columnas = { "Equipo local", "Equipo visitante", "Goles locales", "Goles visitantes", "Lugar", "Fecha"};
			
			String[][] datos = new String[listaResultados.size()][6];
			
			for (int i = 0; i < listaResultados.size(); i++) {
				String resultados = listaResultados.get(i);

				String[] lineas = resultados.split("\n");

				for (int j = 0; j < lineas.length; j++) {
					if (lineas[j].startsWith("Equipo local")) {
						datos[i][0] = lineas[j].substring(7);
					} else if (lineas[j].startsWith("Equipo visitante")) {
						datos[i][1] = lineas[j].substring(6);
					} else if (lineas[j].startsWith("Goles locales")) {
						datos[i][2] = lineas[j].substring(6);
					} else if (lineas[j].startsWith("Goles visitante")) {
						datos[i][3] = lineas[j].substring(4);
					} else if (lineas[j].startsWith("Lugar")) {
						datos[i][4] = lineas[j].substring(8);
					} else if (lineas[j].startsWith("Fecha")) {
						datos[i][5] = lineas[j].substring(11);
					}
				}
			}
			
			tabla = new JTable();
			
			modeloTabla.addColumn(datos, columnas);
			
			panelTabla = new JScrollPane(tabla);
			

		}
		
		if(evento.getSource() == btnCargar) {
			añadir_Fichero_a_Array();

		}
		
		if(evento.getSource() == btnGuardar) {
			
		}
		
	}
}
