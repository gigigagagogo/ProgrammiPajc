package it.unibs.fp.pajc.asciidump;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.util.ArrayList;

public class IOUtil {

	public static void dump(String fileName) {
		
		try(
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
			int i=0,c=0,m=1;
			byte bt[];
			bt=in.readAllBytes();
			for(Byte b: bt) {
				if(i%16==0) {
					System.out.printf("\n%04X ", i);
				}
				
				System.out.printf(" %02X", b);
				
				i++;
				c++;
				/*
				if(c>=(16)) {
					int n=16*m;
					for(int j=n; j<n*2;j++) {
						System.out.printf(" %2c", bt[j]);
					}
				}
				*/
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}

