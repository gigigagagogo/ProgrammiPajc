package fin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerBase {

	public static void main(String[] args) {
		
		int port=1234;
		File file = new File("log.txt");
		try(
				ServerSocket server = new ServerSocket(port);
				Socket client= server.accept();
				PrintWriter out= new PrintWriter(client.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		){
			System.out.printf("Benvenuto: %s\n",client.getInetAddress().getHostName());
			String request;
			while((request = in.readLine())!=null) {
				System.out.println(request);
				if(request.startsWith("@")) {					
					out.println(request.substring(1).toUpperCase());
				}
				writeOnFile(file, request);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeOnFile(File file,String message) {
		try(PrintWriter out = new PrintWriter(new FileWriter(file));){
			StringBuffer desc=new StringBuffer();
			desc.append("<" + new Date() + "> " + message);
			out.println(desc.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
