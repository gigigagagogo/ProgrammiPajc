package corso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.invoke.CallSite;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerPro {

	private static HashMap<Integer, PrintWriter> listClient = new HashMap<>();
	private static int id=0;
	
	public static void main(String[] args) {
		
		int port=1234;
		
		try(ServerSocket server=new ServerSocket(port);){
			while(true) {
					Socket client = server.accept();
					PrintWriter out=new PrintWriter(client.getOutputStream(),true);
				
					System.out.printf("Benvenuto:%s\n", client.getInetAddress().getHostName());
					int clietId=id;
					listClient.put(clietId, out);
					id++;
					
					Thread th= new Thread(()->handleClient(client,clietId));
					th.start();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void handleClient(Socket client,int clientId) {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
			String request;
			while((request=in.readLine())!=null) {
				System.out.println(request);
				handleInput(request, clientId);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void handleInput(String message,int clientId) {
		if(message.startsWith("@")) {
			sendToClient(message.substring(1).toUpperCase(), clientId);
		}else if("!LIST".equals(message.toUpperCase())){
			sendList(clientId);
		}else if(message.startsWith("#")) {
			sendToAll(clientId, message);
		}
	}
	private static void sendToClient(String message,int clientId) {
		PrintWriter out = listClient.get(clientId);
		
		if(out!=null) {
			out.println(message);
		}
	}
	
	private static void sendList(int clientId) {
		PrintWriter out= listClient.get(clientId);
		if(out!=null) {
			out.println(listClient.keySet());
		}
	}
	private static void sendToAll(int sender,String message) {
		for(HashMap.Entry<Integer, PrintWriter> list: listClient.entrySet()) {
			PrintWriter out = list.getValue();
			int clientId=list.getKey();
			
			if(clientId!=sender) {
				out.println(message);
			}
		}
	}

}
