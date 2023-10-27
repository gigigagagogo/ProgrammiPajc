package it.unibs.fp.pajc.LambdaTest;

public class Main {
	
	public static void ripeti(int n, Runnable azione) {
		for(int i=0;i<n; i++) {
			//Print info oggetto(posizione in memoria) + classe oggetto
			//System.out.println(azione + "   " + azione.getClass());
			/*
			if(i%2==0) {
				azione.run(i);

			}

			*/
			
			azione.run();
			
		}
	}
	
	public static void ripeti(int n, RunnableConParamentri azione) {
		for(int i=0;i<n; i++) {
			azione.run(i);
			
		}
	}
	
	public static void interi(int n) {
		for(int i=0;i<n;i++) {
			System.out.printf("%d\n", i);
		}
	}
	
	public static void main(String[] args) {
		
		/*
			//Ogni volta creo l'istanza e il compilatore crea anche la classe relativa 
			Runnable run = new Runnable() {
				public void run() {
					System.out.println("Ciao");
				}
			};
			
			//Runnable run2= () -> {System.out.println("Ciao");};  
			
			ripeti(5,() -> System.out.println("Ciao"));


		
		//La @ indica dove è allocato in memoria
		//System.out.println(run + "     " + run.getClass());
			
		}
		*/
		
		//interi(5);
		
		ripeti(10, (a) -> { if(a%2==0){
			System.out.printf("%d", a);
				}
			}
		);
		
		
		
		ripeti(10, (a) -> {
			for(int i=0;i<a;i++) {
				System.out.printf("%d ", a);
				System.out.println();
			}
		});
		
		ripeti(5, () -> {System.out.println("Ciao! ");});
	}

}
