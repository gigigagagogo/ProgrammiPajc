package fin;

import java.util.Arrays;
import java.util.List;

interface Somma{
	public int sum(int a,int b);
}

public class Stream {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(1,2,3,4,5);
		
		int c=list.stream().mapToInt(n -> n).sum();
		System.out.println(c);
		Somma somma= (a,b) -> a+b;

		System.out.println(somma.sum(2, 3));
	}

	
	
}
