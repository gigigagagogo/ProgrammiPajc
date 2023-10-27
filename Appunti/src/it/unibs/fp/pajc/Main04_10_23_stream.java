package it.unibs.fp.pajc;

import java.util.Arrays;
import java.util.List;

public class Main04_10_23_stream {

	public static void main(String[] args) {

		List<String> list=Arrays.asList("a1","a2","b1","b2");
		//Quando ci imbattiamo in uno stream andiamo a capo cosi che noi possiamo intrepretarlo meglio 
		//Computational Stream prendono informazioni e li processano man mano che entrano negli 
		list
			.stream()
			.map((a)-> {
				System.out.printf("\nLOG: MAP: %s", a);
				return a.toUpperCase();
			})
			.filter((a) -> {
				System.out.printf("\n LOG: FLT: %s", a);
				return !a.startsWith("B");
			})
			.forEach((s) -> System.out.printf("\nOutput: %s", s));
		
	}

}
