package server;
import java.net.*;
import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String []asgs) {
		
		int port=1234;
		File file=new File("log.txt");
		System.out.println("In attesa di un server.....");
		
		try(
			ServerSocket server=new ServerSocket(port);
			Socket client=server.accept();
			PrintWriter out= new PrintWriter(client.getOutputStream(),true);
			BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		){
			System.out.printf("Server info: %s:%d\n ",server.getInetAddress(), server.getLocalPort() );
			System.out.printf("Client info: %s:%d\n ",client.getInetAddress(), client.getPort() );
			out.println("\n\nBenvenuto\n\n");
			String request;
			
			while((request = in.readLine())!= null) {
				writeOnFile(file,request);
				System.out.printf("request: %s\n", request);
				if("@QUIT".equals(request.toUpperCase())) {
					out.print("Torna presto");
					break;
				}
				out.println(request.toUpperCase());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void writeOnFile(File file,String command) throws IOException{
		BufferedWriter out=new BufferedWriter(new FileWriter(file,true));
		StringBuffer st = new StringBuffer();
		st.append("<" + new Date() + "> : <" + command +">" );
		out.append(st.toString());
	}
	
}
