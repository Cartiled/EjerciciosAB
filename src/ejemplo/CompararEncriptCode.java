package ejemplo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.Scanner;

public class CompararEncriptCode {
	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		String linea = null;
		File fichero = new File("C://Trastero//FichBytes.dat");
		
		
		System.out.println("Dame la contraseña correcta");
		String pass = teclado.nextLine();
		String passParaPasar = getMd5(pass);
		
		BufferedReader fic = new BufferedReader(new FileReader(fichero));
		while ((linea = fic.readLine())!=null) {
			if (linea.equals(passParaPasar)) {
				System.out.println("Bienvenida!!!");
			}else {
				System.out.println("La contraseña es incorrecta");
				FileWriter filewriter = new FileWriter("C://Trastero//miapp.log");
				filewriter.write("La contraseña es incorrecta!" + "\n" + "a las " + LocalTime.now() + "." + "Contraseña intentada:" + pass);
				filewriter.close();
			}
			
		}
		
		fic.close();
		teclado.close();
		
	}

	public static String getMd5(String password) {
		String hashtext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger num = new BigInteger(1, messageDigest);
			hashtext = num.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;

	}
}
