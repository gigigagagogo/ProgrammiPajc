package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerPro {

	private static HashMap<Integer, PrintWriter> listSocket = new HashMap<>();
	private static int globalClientId;
	
	public static void main(String[] args) {
		int port=1234;
		System.out.println("In attesa di un client....");
		
		try(ServerSocket server = new ServerSocket(port);){
			while(true) {
				Socket client = server.accept();
				int id=globalClientId++;
				System.out.printf("Client connesso:%s\n", client.getInetAddress());
				PrintWriter out=new PrintWriter(client.getOutputStream(),true);
				listSocket.put(id, out);
				Thread clientThread = new Thread(() -> handleClient(id, client));
                clientThread.start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleClient(int clientId, Socket client){
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
			String request;
			
			while((request = in.readLine())!=null) {
				handleInput(clientId,request);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleInput(int id, String request) {
		if(request.startsWith("@")) {
			sendToClient(id, request.substring(1).toUpperCase());
		}
		if("!LIST".equals(request.toUpperCase())) {
			sendList(id);
		}
		if(request.startsWith("#")) {
			sendToList(id,request.substring(1));
		}
	}
	
	private static void sendToClient(int clientId,String message) {
		PrintWriter out = listSocket.get(clientId);
		if(out!=null) {
			out.println("Message:" +message);
			out.flush();
		}
	}
	
	private static void sendList(int id) {
		PrintWriter write= listSocket.get(id);
		if(write != null) {
			write.println("Lista:" + listSocket.keySet());
		}
	}
	
	private static void sendToList(int sender,String message) {
		for(HashMap.Entry<Integer, PrintWriter> entry : listSocket.entrySet()) {
			int id=entry.getKey();
			PrintWriter writer=entry.getValue();
		
			if(id != sender) {
				writer.println("Messaggio: " + message);
			}
		}
		
			
	}
	
}
