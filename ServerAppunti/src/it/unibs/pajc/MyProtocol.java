package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyProtocol implements Runnable {

	private PrintWriter out;
	private BufferedReader in;
	private Socket client;

	// In questo caso potremmo passare anche nel costruttore gli stream. Pero non è
	// una bella cosa dato che non per forza vogliamo
	// solo scrivere in formato di testo. Quindi piuttosto gli passiamo il client e
	// poi il nostro protocollo sarà a gestire
	public MyProtocol(Socket client) {
		this.client = client;
	}

	@Override
	// Dobbiamo far conoscere alla classe gli stream di comunicazione per far
	// comunicare client e server

	public void run() {
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out.println("Benvenuto!\n\n");

			String request;

			while ((request = in.readLine()) != null) {
				System.out.printf("request: %s\n", request);
				if ("@QUIT".equals(request.toUpperCase())) {
					out.print("Torna presto");
					break;
				}
				out.println(request.toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
