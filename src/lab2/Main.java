package lab2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fruit> fl = new ArrayList<Fruit>();
		System.out.println("Fruit List (ordered by name)");
		Fruit s1 = new Fruit(101, "Apple", 1000);
		fl.add(s1);
		Fruit s2 = new Fruit(102, "Orange", 1500);
		fl.add(s2);
		fl.add(new Fruit(103, "Banana", 2000));
		fl.add(new Fruit(104, "water melon", 3000));
		fl.add(new Fruit(105, "melon", 4000));
		fl.add(new Fruit(106, "pineapple", 2500));
		fl.add(new Fruit(107, "banana2", 2800));
		fl.add(new Fruit(108, "orange2", 7600));
		fl.add(new Fruit(109, "appple2", 5300));
		fl.add(new Fruit(110, "gold kiwi", 5400));
		
		
		Collections.sort(fl, new FruitComparator());
		for(Fruit s : fl) {
			System.out.println(s.toString());
		}
		System.out.println("Fruit List (reverse ordered  by name)");
		
		Collections.sort(fl, new FruitComparatordesc());
		for(int i=0 ; i<fl.size() ; i++) {
			System.out.println(fl.get(i).toString());
		}
	}

}
