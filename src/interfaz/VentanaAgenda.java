package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgenda extends JFrame {

	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JTextField textFieldBusqueda;
	private JLabel lblBusqueda;
	private JButton btnBuscar;
	private JList list;
	private JLabel lblNombreCont;
	private JLabel lblTelefCont;
	private JLabel lblGrupo;
	private JTextField textFieldNombre;
	private JTextField textFieldTelef;
	private JTextField textField;
	private JButton btnNuevoContacto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenda frame = new VentanaAgenda();
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
	public VentanaAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenida = new JLabel("BIENVENIDO ");
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(10, 11, 414, 20);
		contentPane.add(lblBienvenida);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(40, 62, 86, 20);
		contentPane.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		lblBusqueda = new JLabel("Buscar:");
		lblBusqueda.setBounds(40, 37, 86, 14);
		contentPane.add(lblBusqueda);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(136, 61, 89, 23);
		contentPane.add(btnBuscar);
		
		list = new JList();
		list.setBounds(40, 95, 185, 155);
		contentPane.add(list);
		
		lblNombreCont = new JLabel("NOMBRE:");
		lblNombreCont.setBackground(Color.ORANGE);
		lblNombreCont.setBounds(248, 96, 52, 20);
		contentPane.add(lblNombreCont);
		
		lblTelefCont = new JLabel("TELEFONO:");
		lblTelefCont.setBounds(248, 127, 63, 14);
		contentPane.add(lblTelefCont);
		
		lblGrupo = new JLabel("GRUPO:");
		lblGrupo.setBounds(248, 152, 46, 14);
		contentPane.add(lblGrupo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(321, 93, 85, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelef = new JTextField();
		textFieldTelef.setEditable(false);
		textFieldTelef.setColumns(10);
		textFieldTelef.setBounds(321, 121, 86, 20);
		contentPane.add(textFieldTelef);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(321, 149, 85, 20);
		contentPane.add(textField);
		
		btnNuevoContacto = new JButton("NUEVO CONTACTO");
		btnNuevoContacto.addActionListener(new BtnNuevoContactoActionListener());
		btnNuevoContacto.setBounds(248, 177, 160, 31);
		contentPane.add(btnNuevoContacto);
	}
	private class BtnNuevoContactoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			NuevoContacto cont = new NuevoContacto();
			cont.setVisible(true);
			dispose();
		}
	}
}
