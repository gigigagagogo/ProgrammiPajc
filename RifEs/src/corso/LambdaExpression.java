package corso;


interface Somma {
	public int sum(int a,int b);
}

public class LambdaExpression {
	public static void main(String [] args) {
		Somma task= (a,b) -> {
			int c=a+b;
			return c;
		};
		
		System.out.println(task.sum(2,3));
	}
	 
	
}
