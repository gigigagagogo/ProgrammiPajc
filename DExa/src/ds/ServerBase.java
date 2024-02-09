package ds;

import java.net.*;
import java.util.Date;

import java.io.*;

public class ServerBase {

	public static void main(String[] args) {
		int port=1234;
		File file = new File("C:\\Users\\barar\\Desktop\\ProgrammiPajc\\DExa\\src\\ds\\log.txt"); 
		System.out.println("In attesa di un client.....");
		try(
				ServerSocket server = new ServerSocket(port);
				Socket client=server.accept();
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		){
			System.out.printf("Benvenuto:%s",client.getLocalAddress());
			
			String request;
			
			while((request=in.readLine())!=null) {
				writeOnFile(file, request);
				out.println(request.toUpperCase());
			}
				
		}catch (IOException e) {
			 
			e.printStackTrace();
		}
		
	}
	
	public static void writeOnFile(File file, String text)throws IOException {
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
			StringBuffer desc= new StringBuffer();
			desc.append("<" + new Date() + ">" + " " + text);
			pw.print(desc.toString());
		}
		
		
	}

}
