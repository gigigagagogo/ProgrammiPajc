package it.unibs.pajc;

import java.util.ArrayList;

//Si occupa di fare il parsing dei messaggi in input
//Conosce chi è il mittente dell'evento qual'è il comando che ho ricevuto e i parametri del comando

public class WAPEvent {
	//Variabile per conoscere il mittente della request
	WhatsappProtocol sender;
	String command;
	//Credo che conterra il messaggio che avra "allegato" il comando
	ArrayList<String> parameters=new ArrayList<String>();
	
	public WAPEvent(WhatsappProtocol sender, String msg) {
		this.sender=sender;
		//Fare il parsing del messaggio 
		if(msg.startsWith("@")) {
			
			String [] tokens = msg.split("@");
			//???
			command=tokens[1];
			for(int i=1; i<tokens.length;i++) {
				parameters.add(tokens[i]);
			}
		}else {
			//Aggiungiamo tutto il messaggio alla variabile parameters dato che riconosciamo che non si tratta di un comando
			command=null;
			parameters.add(msg);
		}
	}
	
	public String getCommand() {
		return command;
	}
	
}
