package ioDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import interfaz.VentanaAgenda;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import recursos.Contacto;
import recursos.Usuario;
import sun.security.util.DisabledAlgorithmConstraints;

public class IoDatos {

	public static void guardarContacto(String nombre, int telefono, String grupo) {
		File contacto = new File("contacto.dat");

		ArrayList<Contacto> vContactos = new ArrayList();
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
		Iterator<Contacto> it = vContactos.iterator();

		if (!contacto.exists()) {
			try {
				contacto.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fo = new FileOutputStream(contacto);
			escribir = new ObjectOutputStream(fo);

			Contacto cont = new Contacto(nombre, telefono, grupo);

			while (true) {
				vContactos.add(cont);
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean comprobarUser(String user, String passwrd) {
		boolean correcto = false;

		File usuarios = new File("usuarios.txt");
		Scanner leer = null;

		if (!usuarios.exists()) {
			try {
				usuarios.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			leer = new Scanner(usuarios);

			while (leer.hasNextLine()) {
				String[] linea = leer.nextLine().split("-");
				if (linea[0].equalsIgnoreCase(user) && linea[1].equalsIgnoreCase(passwrd)) {
					correcto = true;
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return correcto;
	}

	public static void guardarUsuario(String usuario, String contraseña) {
		File usuarios = new File("usuarios.txt");

		ArrayList<Usuario> vUsuarios = new ArrayList<Usuario>();

		if (!usuarios.exists()) {
			try {
				usuarios.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Usuario usua = new Usuario(usuario, contraseña);

		for (int i = 0; i < vUsuarios.size(); i++) {
			vUsuarios.add(usua);
			break;
		}

	}

}
