package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Protocol implements Runnable {

	PrintWriter out;
	BufferedReader in;
	Socket client;
	
	public Protocol(Socket client) {
		this.client=client;
	}
	
	@Override
	public void run() {
		try {
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out.println("Benvenuto\n\n");
			String request;
			while((request = in.readLine()) != null) {
				System.out.printf("Request:%s\n", request);
				if("@quit".equals(request)) {
					out.print("ciao!");
					break;
				}
				out.printf(request.toUpperCase());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
				if(out!=null) {
					out.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
