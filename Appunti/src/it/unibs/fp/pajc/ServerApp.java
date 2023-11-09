package it.unibs.fp.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
// Server che risponde a un solo client 
public class ServerApp {

	public static void main(String[] args) {
		System.out.println("In attesa di un client.....");
		//Puo esistere un solo servizio per una porta, quindi ci puo essere solo un server su 1234
		int port = 1234;
		
		try(
			ServerSocket server = new ServerSocket(port);
			//Pone il server in uno stato d'attesa aspettando che un client voglia comunicare con lui
			//accept restituisce a suo volta un socket 
			Socket client= server.accept();
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
		){
			
			System.out.printf("Server info: %s:%d\n ",server.getInetAddress(), server.getLocalPort() );
			System.out.printf("Client info: %s:%d\n ",client.getInetAddress(), client.getPort() );
			out.println("\n\nBenvenuto\n\n");
			String request;
			
			while((request = in.readLine())!= null) {
				System.out.printf("request: %s\n", request);
				if("@QUIT".equals(request.toUpperCase())) {
					out.print("Torna presto");
					break;
				}
				out.println(request.toUpperCase());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
