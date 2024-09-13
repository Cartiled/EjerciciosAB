package ejemplo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ViewHexMap {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C://Trastero//FichBytes.dat");
		FileInputStream fic = new FileInputStream(fichero);
		int i ;
		try {
			while((i = fic.read())!=-1) 
				System.out.print((char)i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fic.close();
	}
}
