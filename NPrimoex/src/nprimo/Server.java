package nprimo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {
	private static int id;
	private static HashMap<Integer, PrintWriter> listSocket = new HashMap<Integer,PrintWriter>();

	public static void main(String[] args) {

		int port=1234;
		System.out.println("In attesa del server");
		try(
				ServerSocket server = new ServerSocket(port); 
		){
			while(true) {
				int clientId=id;
				Socket client = server.accept();
				
				System.out.printf("Benvenuto: %s", client.getInetAddress());
				
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				 
				listSocket.put(clientId, out);
				id++;
				
				Thread clientThread = new Thread(() -> handleClient(clientId,client));
				clientThread.start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void handleClient(int idClient,Socket client) {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
			String request;
			
			while((request=in.readLine())!=null) {
				handleInput(idClient,request);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleInput(int idClient,String message) {
		if(message.startsWith("@")) {
			sendClient(idClient, message.substring(1).toUpperCase());
		}else if ("!LIST".equals(message.toUpperCase())) {
			sendList(idClient);
		}else if(message.startsWith("#")) {
			
		}
	}
	
	private static void sendClient(int idClient,String message) {
		PrintWriter out = listSocket.get(idClient);
		
		if(out!=null) {
			out.println(message);
		}
	}
	
	private static void sendList(int idClient) {
		PrintWriter out = listSocket.get(idClient);
		
		if(out!=null) {
			out.println(listSocket.keySet());
		}
	}
	
	private static void sendToAll(int sender,int message) {
		
		for(HashMap.Entry<Integer, PrintWriter> list:listSocket.entrySet()) {
			int id=list.getKey();
			PrintWriter out=list.getValue();
			
			if(id!=sender) {
				out.println(message);
			}
		}
		
	}
	
}
