package it.unibs.pajc;
import java.util.stream.*;
public class LabCompStreamApp {
	public static void main(String [] args) {
		IntStream
			.range(0, 20)
			/*
			.filter((a) -> (a%2)==0)
			.map((a) -> (int) Math.pow(a, 2))
			.map((a) -> (a>100) ? 100 : a)
			*/
			.mapToObj(x -> String.format("%c_%02d", 'a'  + x ,x))			
			.filter(s -> {
				char ch=s.charAt(0);
				return (ch >= 'e' && ch<= 'o') ? true : false;
			})
			.map(s -> s.substring(s.length()-2))
			.mapToInt(Integer::parseInt)
			.forEach(System.out::println);
		
		
		
	}
}
