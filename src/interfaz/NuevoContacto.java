package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ioDatos.IoDatos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoContacto extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField textFieldNombre;
	private JTextField textFieldTelef;
	private JTextField textFieldGrupo;
	private JButton btnGuardar;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoContacto frame = new NuevoContacto();
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
	public NuevoContacto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("NUEVO CONTACTO");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 264, 40);
		contentPane.add(lblTitle);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNombre.addFocusListener(new TextFieldFocusListener());
		textFieldNombre.setBounds(75, 78, 130, 30);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText("NOMBRE");
		
		textFieldTelef = new JTextField();
		textFieldTelef.addFocusListener(new TextFieldTelefFocusListener());
		textFieldTelef.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTelef.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTelef.setColumns(10);
		textFieldTelef.setBounds(75, 119, 130, 30);
		contentPane.add(textFieldTelef);
		textFieldTelef.setText("TELÉFONO");
				
		textFieldGrupo = new JTextField();
		textFieldGrupo.addFocusListener(new TextFieldGrupoFocusListener());
		textFieldGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldGrupo.setColumns(10);
		textFieldGrupo.setBounds(75, 160, 130, 30);
		contentPane.add(textFieldGrupo);
		textFieldGrupo.setText("GRUPO");
		
		btnGuardar = new JButton("A\u00D1ADIR CONTACTO");
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setBounds(41, 201, 200, 40);
		contentPane.add(btnGuardar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 41, 46, 14);
		contentPane.add(lblFondo);
		lblFondo.setFocusable(true);
		lblFondo.requestFocus();
		
	}

	private class TextFieldFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			lblFondo.setFocusable(false);
			textFieldNombre.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (textFieldNombre.getText().equalsIgnoreCase("")) {
				textFieldNombre.setText("NOMBRE");
			}
			
			if (!(textFieldNombre.getText().equalsIgnoreCase(""))) {
				textFieldNombre.setText(textFieldNombre.getText());		
			}
		}
	}
	private class TextFieldTelefFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			textFieldTelef.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (textFieldTelef.getText().equalsIgnoreCase("")) {
				textFieldTelef.setText("TELÉFONO");
			}
			
			if (!(textFieldTelef.getText().equalsIgnoreCase(""))) {
				textFieldTelef.setText(textFieldTelef.getText());
			}
		}
	}
	private class TextFieldGrupoFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			textFieldGrupo.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (textFieldGrupo.getText().equalsIgnoreCase("")) {
				textFieldGrupo.setText("GRUPO");
			}
		
			if (!(textFieldGrupo.getText().equalsIgnoreCase(""))) {
				textFieldGrupo.setText(textFieldGrupo.getText());
			}
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			IoDatos.guardarContacto(textFieldNombre.getText(), Integer.parseInt(textFieldTelef.getText()), textFieldGrupo.getText());
			
			VentanaAgenda ag = new VentanaAgenda();
			ag.setVisible(true);
			dispose();
			JOptionPane.showMessageDialog(null, "Nuevo contacto creado");
			
		}
	}
}
