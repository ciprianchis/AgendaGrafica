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

public class VentanaAgenda extends JFrame {

	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JTextField textFieldBusqueda;
	private JLabel lblBusqueda;
	private JButton btnBuscar;

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
	}
}
