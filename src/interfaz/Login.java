package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import recursos.Contacto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lbltITLE;
	private JLabel lblLogin;
	private JTextField textFieldUser;
	private JPasswordField passwordFieldPass;
	private JButton btnEntrar;
	private JLabel lblFondo;
	private ArrayList<Contacto> vContactos;
	private JButton btnNuevoUsuaroi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltITLE = new JLabel("AGENDA");
		lbltITLE.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbltITLE.setBounds(10, 11, 414, 30);
		contentPane.add(lbltITLE);

		lbltITLE.setAlignmentX(CENTER_ALIGNMENT);
		
		lblLogin = new JLabel("Log In:");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLogin.setBounds(34, 38, 380, 30);
		contentPane.add(lblLogin);
		
		lblLogin.setAlignmentX(CENTER_ALIGNMENT);
		
		textFieldUser = new JTextField();
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUser.addFocusListener(new TextFieldUserFocusListener());
		textFieldUser.setBounds(61, 70, 140, 30);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldUser.setText("USUARIO");
		textFieldUser.setAlignmentX(Component.CENTER_ALIGNMENT);
		Color gris =  Color.LIGHT_GRAY;
		textFieldUser.setCaretColor(gris);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.addFocusListener(new PasswordFieldPassFocusListener());
		passwordFieldPass.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldPass.setBounds(211, 70, 140, 30);
		contentPane.add(passwordFieldPass);
		passwordFieldPass.setText("contrase\u00F1a");
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnEntrar.setBounds(58, 111, 293, 30);
		contentPane.add(btnEntrar);
		
		lblFondo = new JLabel("");
		lblFondo.setBackground(new Color(255, 222, 173));
		lblFondo.setBounds(0, 0, 414, 182);
		contentPane.add(lblFondo);
		lblFondo.setFocusable(true);
		
		btnNuevoUsuaroi = new JButton("A\u00D1ADIR USUARIO");
		btnNuevoUsuaroi.addActionListener(new BtnNuevoUsuaroiActionListener());
		btnNuevoUsuaroi.setBounds(58, 148, 293, 23);
		contentPane.add(btnNuevoUsuaroi);
		lblFondo.requestFocus();
		
	}
	private class TextFieldUserFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			textFieldUser.setText("");
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			lblFondo.setFocusable(false);
			Color gris =  Color.LIGHT_GRAY;
			Color black =  Color.black;
			
			if (textFieldUser.getText().equalsIgnoreCase("")) {
				textFieldUser.setText("USUARIO");
				textFieldUser.setCaretColor(gris);
			}
			
			if (!(textFieldUser.getText().equalsIgnoreCase(""))) {
				textFieldUser.setText(textFieldUser.getText());
				textFieldUser.setCaretColor(black);				
			}

			
		}
	}
	private class PasswordFieldPassFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			passwordFieldPass.setText("");
				
		}
		@Override
		public void focusLost(FocusEvent e) {
			if (passwordFieldPass.getPassword().toString().equalsIgnoreCase("")) {
				passwordFieldPass.setText("contraseña");
			}

		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if (ioDatos.IoDatos.comprobarUser(textFieldUser.getText(), passwordFieldPass.getPassword().toString())==true) {
				VentanaAgenda a = new VentanaAgenda();
				a.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA DESCONOCIDOS");
			}
		}
	}
	private class BtnNuevoUsuaroiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NuevoUser ven = new NuevoUser();
			ven.setVisible(true);
			dispose();
		}
	}
}
