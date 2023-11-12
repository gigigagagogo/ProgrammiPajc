package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class TryServer {
	static final int port=1234;
	
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("In attesa di un client....");
		ServerSocket server = new ServerSocket(port);
	
		while(true) {
			Socket client=null;
			try {
				
				client=server.accept();
				System.out.printf("Si e' appena connesso:%s", client);
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void creazioneClient(ServerSocket server) {
		Runnable task = () -> {
			try {
				Socket client = server.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	

}

