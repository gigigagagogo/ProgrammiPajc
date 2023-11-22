package it.unibs.pajc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		int port=1234;
		System.out.println("In attesa di un client....");

		try(
			ServerSocket server = new ServerSocket(port);
		){
			while(true) {
				Socket client = server.accept();
				System.out.printf("Client connesso: %s:%d", client.getInetAddress(),client.getLocalPort());
				
				Protocol p= new Protocol(client);
				
				Thread threadTask = new Thread(p);
				threadTask.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}

}
