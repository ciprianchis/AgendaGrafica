package ioDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import interfaz.VentanaAgenda;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import sun.security.util.DisabledAlgorithmConstraints;

public class IoDatos {

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
	
	public static void guardarUsuario() {
		File usuarios = new File("usuarios.txt");
		
		PrintWriter pw = null;
		FileWriter fw = null;
		
		if (!usuarios.exists()) {
			try {
				usuarios.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
