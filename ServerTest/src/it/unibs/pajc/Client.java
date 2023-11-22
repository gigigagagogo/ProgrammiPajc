package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		String host = "localhost";
		int port = 1234;

		try{
			Socket client = new Socket(host,port);
			
			ExecutorService exec = Executors.newFixedThreadPool(2);
			exec.submit(() -> clientToServer(client));
			exec.submit(() -> serverToClient(client));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static void clientToServer(Socket client) {
		
		try {
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
			String request;
			while((request = in.readLine())!=null) {
				out.println(request);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected static void serverToClient(Socket client) {
		try {
			BufferedReader inServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String iMsg;
			while((iMsg = inServer.readLine())!=null) {
				System.out.printf("\nMessaggio dal Server:%s\n", iMsg);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
