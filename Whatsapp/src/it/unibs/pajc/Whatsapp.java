package it.unibs.pajc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//Gestione del server
public class Whatsapp {
	public static void main(String []args) {
		int port=1234;
		System.out.println("Avvio del server....\n");
		try(
			ServerSocket server = new ServerSocket(port);
		){
			System.out.println("Server avviato");
			while(true) {
				
				System.out.println();
				Socket client = server.accept();
				
				WhatsappProtocol p = new WhatsappProtocol(client);
				Thread t = new Thread(p);
				
				t.start();
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
