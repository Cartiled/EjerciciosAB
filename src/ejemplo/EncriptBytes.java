package ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EncriptBytes {
	public static void main (String[] args) {
		Scanner teclado = new Scanner(System.in);
		File fichero = new File("C://Trastero//FichBytes.dat");
		String pass = null;
		byte[] cad = null;;
		try {
			FileOutputStream fic = new FileOutputStream(fichero);
			System.out.println("Dime la contraseña correcta");
			pass = teclado.nextLine();
			cad = pass.getBytes();
			fic.write(cad);
			
			fic.close();
			System.out.println("Tu contraseña esta bien ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teclado.close();
	}
	
	
}
