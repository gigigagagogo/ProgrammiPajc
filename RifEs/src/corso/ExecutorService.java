package corso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExecutorService {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(1,2,3,4,5);
		
		int c=lista
			.stream()
			.mapToInt(a -> a*a)
			.filter((a) -> a%2==0)
			.sum();
			
		System.out.println(c);
	}

}
