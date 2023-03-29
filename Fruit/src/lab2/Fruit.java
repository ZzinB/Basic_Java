package lab2;

import java.util.Comparator;

public class Fruit {
	int no;
	String name;
	int price;


	public Fruit(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price	= price;
	}
public String toString() {
	String s = "Student [no = "+no+", name = "+name+", "+price+"]";
	return s;
	}

}
class FruitComparator implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.name.compareTo(o2.name);
	}
}

class FruitComparatordesc implements Comparator<Fruit>{
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o2.name.compareTo(o1.name);
	}
}

