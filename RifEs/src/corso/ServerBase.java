package corso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerBase {
	public static void main(String [] args) {
		int port=1234;
		File file = new File("log.txt");
		try(
				ServerSocket server = new ServerSocket(port);
				Socket client= server.accept();
				PrintWriter out=new PrintWriter(client.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		){
			String request;
			
			while((request=in.readLine())!=null) {
				System.out.println(request);
				if(request.startsWith("@")) {
					out.println(request.substring(1).toUpperCase());
				}
				writeOnFile(request, file);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeOnFile(String message,File file) {
		try(BufferedWriter out= new BufferedWriter(new FileWriter(file,true));){
			StringBuffer disc=new StringBuffer();
			disc.append("<" + new Date() + ">" + ": " + message+ "\n");
			out.append(disc.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
