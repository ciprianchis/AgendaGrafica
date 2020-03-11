package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NuevoUser extends JFrame {

	private JPanel contentPane;
	private JLabel lblAñadirUser;
	private JTextField textFieldUser;
	private JTextField textFieldContras;
	private JButton btnAñadir;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUser frame = new NuevoUser();
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
	public NuevoUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAñadirUser = new JLabel("NUEVO USUARIO");
		lblAñadirUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAñadirUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirUser.setBounds(10, 11, 244, 30);
		contentPane.add(lblAñadirUser);
		
		textFieldUser = new JTextField();
		textFieldUser.addFocusListener(new TextFieldUserFocusListener());
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUser.setBounds(57, 54, 150, 30);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldContras = new JTextField();
		textFieldContras.addFocusListener(new TextFieldContrasFocusListener());
		textFieldContras.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldContras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldContras.setBounds(57, 109, 150, 30);
		contentPane.add(textFieldContras);
		textFieldContras.setColumns(10);
		
		btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAñadir.setBounds(57, 165, 150, 30);
		contentPane.add(btnAñadir);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 11, 46, 14);
		contentPane.add(lblFondo);
		lblFondo.setFocusable(true);
		lblFondo.requestFocus();
	}

	private class TextFieldUserFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			lblFondo.setFocusable(false);
			textFieldUser.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
			Color gris =  Color.LIGHT_GRAY;
			Color black =  Color.black;
			if (textFieldUser.getText().equalsIgnoreCase("")) {
				textFieldContras.setText("USUARIO");
				textFieldUser.setCaretColor(gris);
			}
			if (!textFieldUser.getText().equalsIgnoreCase("")) {
				textFieldUser.setText(textFieldUser.getText());
				textFieldUser.setCaretColor(black);
			}
		}
	}
	private class TextFieldContrasFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
		}
	}
}
