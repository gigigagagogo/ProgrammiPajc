package it.unibs.pajc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//Classe per la gestione del server che permette la connessione a piu client
public class ServerMt {

	
	public static void main(String[] args) {
		int port=1234;
		System.out.println("In attesa di un client.....");
		//Puo esistere un solo servizio per una porta, quindi ci puo essere solo un server su 1234
		//Creazione del server messa detro le () cosi che venga automaticamente chiuso, altrimenti avremmo
		//dovuto fare un finnaly e chiuderlo
		try(
			//Creazione del server
			ServerSocket server = new ServerSocket(port);
			
		){
			//Ciclo infinito che permette la comunicaziq+oni dei client con il server
			while(true) {
				Socket client= server.accept();
				System.out.printf("Client connesso: %s%d\n", client.getInetAddress(),client.getPort());
				//Creazione dell'oggetto MyProtocol per la comunicazione
				MyProtocol p = new MyProtocol(client);

				Thread clientThread= new Thread(p);
				
				clientThread.start();
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
