package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApp {
	public static void main(String [] args) {
		//127.0.0.1
		String host="localhost";
		int port = 1234;
		
		try {
			//il client prova a connettersi a quell'host a quella porta
			Socket client = new Socket(host,port);
			System.out.println("Client connesso!");
			//Creo 2 thread per far eseguire i 2 metodi
			ExecutorService exec = Executors.newFixedThreadPool(2);
			exec.submit(() -> clientToServer(client));
			exec.submit(() -> serverToClient(client));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	protected static void clientToServer(Socket client) {
		try {
			//Il PrintWriter lo aggancio all'outputStream del nostro client
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			
			String strIn;
			while((strIn = stdin.readLine())!=null){
				out.println(strIn);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected static void serverToClient(Socket client) {
		try {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String request;
			while((request= stdin.readLine())!=null) {
				System.out.printf("MSG dal server:%s\n", request);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
