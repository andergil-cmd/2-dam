package EjercicioFicheroTextoPlano;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AñadirMensaje extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtFecha;
    private JComboBox<String> comboMes;
    private JComboBox<String> comboDia;
    private JComboBox<String> comboHora;
    private JComboBox<String> comboMinuto;

    private JTextField txtDe;
    private JTextField txtPara;
    private JTextField txtAsunto;
    private JTextArea txtContenido;

    private JButton btnOK;
    private JButton btnCancelar;


    private ArrayList<String> listaMensajes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirMensaje frame = new AñadirMensaje(new ArrayList<String>());
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
	public AñadirMensaje(ArrayList<String> listaMensajes) {
		
        this.listaMensajes = listaMensajes;

        setTitle("Añadir Mensaje");
        setBounds(100, 100, 366, 403);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 25, 45, 20);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(55, 20, 55, 30);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		comboMes = new JComboBox<String>();
		comboMes.setBounds(142, 20, 142, 30);

		comboMes.addItem("Selecciona mes");
		comboMes.addItem("Enero");
		comboMes.addItem("Febrero");
		comboMes.addItem("Marzo");
		comboMes.addItem("Abril");
		comboMes.addItem("Mayo");
		comboMes.addItem("Junio");
		comboMes.addItem("Julio");
		comboMes.addItem("Agosto");
		comboMes.addItem("Septiembre");
		comboMes.addItem("Octubre");
		comboMes.addItem("Noviembre");
		comboMes.addItem("Diciembre");
		
		

		contentPane.add(comboMes);

		comboDia = new JComboBox<String>();
		comboDia.setBounds(290, 20, 57, 30);
		comboDia.addItem("Selecciona día");

		for (int i = 1; i <= 31; i++) {

			if (i < 10) {
				comboDia.addItem("0" + i);
			} else {
				comboDia.addItem("" + i);
			}
		}

		contentPane.add(comboDia);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 75, 45, 20);
		contentPane.add(lblHora);

		comboHora = new JComboBox<String>();
		comboHora.setBounds(55, 70, 57, 30);

		comboHora.addItem("Selecciona");

		for (int i = 0; i <= 23; i++) {

			if (i < 10) {
				comboHora.addItem("0" + i);
			} else {
				comboHora.addItem("" + i);
			}
		}

		contentPane.add(comboHora);


		// -------------------------
		// :
		// -------------------------

		JLabel lblDosPuntos = new JLabel(":");
		lblDosPuntos.setBounds(120, 75, 10, 20);
		contentPane.add(lblDosPuntos);

		comboMinuto = new JComboBox<String>();
		comboMinuto.setBounds(142, 70, 57, 30);

		comboMinuto.addItem("Selecciona");

		for (int i = 0; i <= 59; i++) {

			if (i < 10) {
				comboMinuto.addItem("0" + i);
			} else {
				comboMinuto.addItem("" + i);
			}
		}

		contentPane.add(comboMinuto);

		JLabel lblDe = new JLabel("De");
		lblDe.setBounds(10, 120, 45, 20);
		contentPane.add(lblDe);

		txtDe = new JTextField();
		txtDe.setBounds(108, 115, 240, 30);
		contentPane.add(txtDe);
		txtDe.setColumns(10);

		JLabel lblPara = new JLabel("Para");
		lblPara.setBounds(10, 152, 45, 20);
		contentPane.add(lblPara);

		txtPara = new JTextField();
		txtPara.setBounds(108, 147, 240, 30);
		contentPane.add(txtPara);
		txtPara.setColumns(10);

		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(10, 182, 60, 20);
		contentPane.add(lblAsunto);

		txtAsunto = new JTextField();
		txtAsunto.setBounds(108, 178, 240, 30);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);

		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 222, 80, 20);
		contentPane.add(lblContenido);

		txtContenido = new JTextArea();
		txtContenido.setBounds(120, 218, 228, 55);
		contentPane.add(txtContenido);

		btnOK = new JButton("OK");
		btnOK.setBounds(215, 300, 65, 30);
		btnOK.addActionListener(this);
		contentPane.add(btnOK);

		btnCancelar = new JButton("Cancel");
		btnCancelar.setBounds(285, 300, 70, 30);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		
	    if (evento.getSource() == btnOK) {

	        if (txtFecha.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "La fecha es obligatoria");
	            txtFecha.requestFocus();
	        }

	        else if (comboMes.getSelectedIndex() == 0) {
	            JOptionPane.showMessageDialog(this, "El mes es obligatorio");
	            comboMes.requestFocus();
	        }

	        else if (comboDia.getSelectedIndex() == 0) {
	            JOptionPane.showMessageDialog(this, "El día es obligatorio");
	            comboDia.requestFocus();
	        }

	        else if (comboHora.getSelectedIndex() == 0) {
	            JOptionPane.showMessageDialog(this, "La hora es obligatoria");
	            comboHora.requestFocus();
	        }

	        else if (comboMinuto.getSelectedIndex() == 0) {
	            JOptionPane.showMessageDialog(this, "Los minutos son obligatorios");
	            comboMinuto.requestFocus();
	        }

	        else if (txtDe.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El campo De es obligatorio");
	            txtDe.requestFocus();
	        }

	        else if (txtPara.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El campo Para es obligatorio");
	            txtPara.requestFocus();
	        }

	        else if (txtAsunto.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El asunto es obligatorio");
	            txtAsunto.requestFocus();
	        }

	        else if (txtContenido.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El contenido es obligatorio");
	            txtContenido.requestFocus();
	        }
	        	else {

	        	    String mes = "";

	        	    if (comboMes.getSelectedItem().equals("Enero")) {
	        	        mes = "01";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Febrero")) {
	        	        mes = "02";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Marzo")) {
	        	        mes = "03";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Abril")) {
	        	        mes = "04";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Mayo")) {
	        	        mes = "05";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Junio")) {
	        	        mes = "06";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Julio")) {
	        	        mes = "07";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Agosto")) {
	        	        mes = "08";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Septiembre")) {
	        	        mes = "09";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Octubre")) {
	        	        mes = "10";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Noviembre")) {
	        	        mes = "11";
	        	    }
	        	    else if (comboMes.getSelectedItem().equals("Diciembre")) {
	        	        mes = "12";
	        	    }


	            // Creamos el mensaje para añadir
	        	    
	        	    String mensaje = "";


	        	    mensaje += "fecha: " + txtFecha.getText() + "-"
	        	            + mes + "-"
	        	            + comboDia.getSelectedItem() + "\n";

	        	    mensaje += "hora: " + comboHora.getSelectedItem() + ":"
	        	            + comboMinuto.getSelectedItem() + "\n";

	        	    mensaje += "para: " + txtPara.getText() + "\n";

	        	    mensaje += "de: " + txtDe.getText() + "\n";

	        	    mensaje += "asunto: " + txtAsunto.getText() + "\n";

	        	    mensaje += "contenido: " + txtContenido.getText() + "\n";

	        	    listaMensajes.add(mensaje);
	        	    JOptionPane.showMessageDialog(this, "El mensaje se ha añadido correctamente");
	        	    dispose();
	        }
	    }

	    else if (evento.getSource() == btnCancelar) {
	        dispose();
	    }
	}

}
