package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;
//WhatsappProtocol è collegato ad ogni client
public class WhatsappProtocol implements Runnable {
	//HashMap per controllare l'univocita del nome del client
	private static HashMap <String,WhatsappProtocol> clientMap = new HashMap<String, WhatsappProtocol>();
	private static HashMap<String, Consumer<WAPEvent>> commandMap = new HashMap<String, Consumer<WAPEvent>>();
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private String name=null;
	
	public WhatsappProtocol(Socket client) {
		this.client=client;
	}
	
	public void run() {
		try {
			out= new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	
			login();
			
			String request;
			
			while((request = in.readLine())!=null) {
				WAPEvent e=new WAPEvent(null, request);
				if(e.getCommand() != null) {
					
				}
				sendMsg(request.toUpperCase());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//Chiusura degli stream
		}
	}
	
	//Metodo per il "login" del client. Richiesta nome e controlli
	private void login() throws IOException {
		System.out.println("Client connesso... attesa nome utente...");
		out.println("Benvenuto sul server WAP PAJC");
		
		while(name == null) {
			out.println("Inserisci il tuo nome");
			name = in.readLine();
			
			if(name.length()<3) { 
				out.println("Errore!, il tuo nome deve avere almeno 3 caratteri");
				name=null;
			}
			//Controllo nella HashMap
			if(clientMap.containsKey(name)) {
				out.println("Errore!, utente gia esistente");
				name=null;
			}
			
		}
		
		//Sincoronizzazione risorsa condivisa
		synchronized (clientMap) {
			clientMap.put(name,this);
		}
		clientMap.put(name,this);
		sendMsg("Benvenuto\n");
	}
	//Compito: Vogliamo gestire manda messaggio a qualcuno, manda messaggio a qualcuno e visualizza utenti attivi 
	//Fare attraverso dei comandi
	
	//Metodo per la stampa (può essere omesso)
	public void sendMsg(String msg) {
		out.printf("[%s] %s",name,msg );
	}
	
}
