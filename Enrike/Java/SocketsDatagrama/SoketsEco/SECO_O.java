import java.net.*;
import java.io.*;

public class SECO_O{
	public static void main(String[] args){
		try{
			DatagramSocket s = new DatagramSocket(1234);
			System.out.println("Servidor de datagrams iniciado, esperando datagramas...");

			for( ; ; ){
				DatagramPacket p = new DatagramPacket(new byte[1040], 1040);
				s.receive(p);
				System.out.println("Datagrama recibido desde: " + p.getAddress() + ": " + p.getPort());
				
				ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(p.getData()));
				Datos d1 = (Datos) ois.readObject();
				
				ois.close();
			}//for

		}catch(Exception e){
			e.printStackTrace();
		}//catch
	}//main
}//class

/*
	s.receive(p);
	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(p.getData()));
	ByteArrayInputStream(p.getData());
	int x = dis.readInt();
	float y = dis.readFloat();
	long z = dis.readLong();
*/