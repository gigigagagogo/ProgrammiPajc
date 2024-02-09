package exec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Main {
	
	private static int port=1234;
	private static HashMap<Integer, PrintWriter> listClients = new HashMap<>();
	private static int counter=0;
	public static void main(String [] args) {
		
		 int id=0;
		
		try(ServerSocket server=new ServerSocket(port);){
			while(true) {
				Socket client = server.accept();
				System.out.printf("Benvenuto" + client.getInetAddress());
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				
				listClients.put(id, out);
				
				Thread clientThread= new Thread(() -> handleClient(id,client)); 
				clientThread.start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	private static void handleClient(int id,Socket client) {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
			String request;
			while((request=in.readLine())!=null) {
				handleInput(id,request);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleInput(int id,String request) {
		if(request.startsWith("@")) {
			sendToClient(id, request.substring(1).toUpperCase());
		}else if(request.startsWith("#")){
			sendToAll(id, request);
		}else if("!LIST".equals(request.toUpperCase())) {
			sendList(id);
		}
	}
	
	private static void sendToClient(int id,String request) {
		PrintWriter write=listClients.get(id);
		if(write!=null) {
			write.println(request);
		}
	}
	
	private static void sendList(int id) {
		PrintWriter write=listClients.get(id);
		if(write!=null) {
			write.println(listClients.keySet());
		}
	}
	
	private static void sendToAll(int id,String request) {
		for(HashMap.Entry<Integer, PrintWriter> lista : listClients.entrySet()) {
			int idClient=lista.getKey();
			PrintWriter write= lista.getValue();
			
			if(idClient!=id) {
				write.println(request);
			}
		}
	}
	
}
