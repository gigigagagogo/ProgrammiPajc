package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TryServer {

	final static int port=1234;
	
	public static void main(String[] args) throws IOException{
		System.out.println("In attesa di un client....");
		/*
		try(
			ServerSocket server= new ServerSocket(port);
			Socket client = server.accept();
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));		
		){
			System.out.printf("Client connesso: %s al server %s:%d",
					client.getInetAddress(),server.getInetAddress(),server.getLocalPort());
			out.print("\n\nBenvenuto\n\n");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		ServerSocket server = new ServerSocket(port);
		try{
			Socket client= null;
			while(true) {
				System.out.printf("Si e' appena connesso il client: %s al server %s:%d", 
						client.getLocalAddress(),server.getInetAddress(),server.getLocalPort());
				
				client= server.accept();
				/*
				Runnable task = () -> {
						PrintWriter out = new PrintWriter(client.getOutputStream(),true);
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					
				};
				*/
				Thread t = new Thread();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}

