package fin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerPro {

	private static int id=0;
	private static HashMap<Integer, PrintWriter> listClient = new HashMap<>();
	public static void main(String[] args) {

		int port=1234;
		
		try(
				ServerSocket server = new ServerSocket(port);
		){
			while(true) {
				Socket client = server.accept();
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				
				int currentNumber=id;
				listClient.put(currentNumber, out);
				id++;
				Thread th = new Thread(() ->handleClient(client,currentNumber));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void handleClient(Socket client,int currentId) {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
			String request;
			while((request=in.readLine())!=null) {
				handleInput(request, currentId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void handleInput(String message,int currentId) {
		if(message.startsWith("@")) {
			sendToClient(currentId,message.substring(1).toUpperCase());
		}else if("!LIST".equals(message.toUpperCase())) {
			sendList(currentId);
		}else if(message.startsWith("#")) {
			sendToAll(currentId, message);
		}
	}
	
	public static void sendToClient(int currentId,String message) {
		PrintWriter out= listClient.get(currentId);
		
		if(out!=null) {
			out.println(message);
		}
	}
	
	public static void sendList(int currentId) {
		PrintWriter out = listClient.get(currentId);
		
		if(out!=null) {
			out.print(listClient.keySet());
		}
	}

	public static void sendToAll(int sender,String message) {
		for(HashMap.Entry<Integer, PrintWriter> list : listClient.entrySet()) {
			PrintWriter out= list.getValue();
			int id= list.getKey();
			
			if(sender!=id) {
				out.println(message);
			}
		}
	}
	
}
