package it.unibs.pajc;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppBimondo {

	public static void main(String[] args) {
		ArrayList<Shape2D> list = new ArrayList<>();
		//HashMap<Class, Integer> contaOggetti = new HashMap<>();
		
		list.add(new Diamond(3, 2));
		list.add(new Rectangle(3, 2));
		list.add(new Rectangle(7, 9));
		list.add(new Rectangle(3, 2));
		list.add(new Diamond(3, 2));
		list.add(new Square(13));
		list.add(new Square(42));
		list.add(new Diamond(3, 2));
		list.add(new Diamond(3, 2));
		
		list.sort((a,b) -> {
			//Sistemare questo codice con meno codice per mercoledi
			double d=a.area()- b.area();
			return d>0 ? 1:d<0 ? -1:0;
		});
		
		for(Shape2D s:list) {
			System.out.printf("\n%s \t - area = %f", s.getClass().getSimpleName(),s.area());
		}
		
		
		int areaTotale = 0;
		/*
		for(Shape2D s: list) {
			
			Class<?> key = s.getClass();
			if(contaOggetti.containsKey(key)) {
				int count = contaOggetti.get(key);
				contaOggetti.put(key, count + 1);
			} else {
				contaOggetti.put(key, 1);
			}	
		}
		
		for(Map.Entry<Class, Integer> kv: contaOggetti.entrySet()) {
			System.out.printf("%s: %d\n", 
					kv.getKey().getSimpleName(),
					kv.getValue());
		}
		*/
	}

}
