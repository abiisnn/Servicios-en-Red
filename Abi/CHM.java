// 29 de Enero 2019
// Socket bloqueante, CLIENTE

// ES mejor importar clase por clase
import java.net.*;
import java.io.*;
public class CHM {
	public static void main(String[] args) {
		try {
			// Asocio un flujo de lectura
			// InputStreamreader es como un puente, así puedo leer parrafos 
			// Convierte un flujo orientado a byte a caracter
			BufferedReader br = new BufferedReader(new InputStreamReader());
			System.out.print("\n Escribe la direccion del servidor:");
			String host = br.readLine(); // Para pruebas se usa "127.0.0.1"
			int pto = 9999; // Se puede usar el rango de 1024-65535
			Socket cl = new Socket(hots, pto);
			System.out.println("Conexion establecida ... recibiendo datos");

			// Un solo flujo de lectura
			// Obtengo un flujo de lectura orientado a byte, y lo convierto a orientado a caracter
			// Fin de flujo orientado a byte -1
			// Fin de flujo de caracter null
			BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getInputStream()));
			String msj = br2.readLine();
			System.out.println("\n Mensaje Recibido: " + msj);
			br2.close();
			cl.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
