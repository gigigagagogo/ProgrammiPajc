package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TryServer {

	public static void main(String[] args) {
		int port=1234;
		System.out.println("In attesa di un client....");
		
		try(
			ServerSocket server= new ServerSocket(port);
			Socket client = server.accept();
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));		
		){
			System.out.printf("Client connesso: %s al server %s:%d",
					client.getInetAddress(),server.getInetAddress(),server.getLocalPort());
			out.print("\n\nBenvenuto\n\n");
			
			String request;
			
			while((request=in.readLine()) != null) {
				System.out.printf("\nrequest: %s\n", request);
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

