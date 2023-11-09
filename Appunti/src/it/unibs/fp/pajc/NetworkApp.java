package it.unibs.fp.pajc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkApp {

	public static void main(String[] args) throws Exception {
		//Ci permette di specificare l'url del servizio
		URL url=new URL("https://www.google.com");
		//Mi permette di accedere a una risorsa remota come se fosse una risorsa locale
        BufferedReader in= new BufferedReader(new InputStreamReader(url.openStream())); 
        
        String line;
        
        while((line = in.readLine())!= null) {
        	System.out.println(line);
        }
        
        in.close();
        
	}
	
}


