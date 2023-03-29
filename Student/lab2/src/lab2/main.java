package lab2;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> al = new ArrayList<Student>();
		System.out.println("Student List (ordered by name)");
		Student s1 = new Student(101, "KIm", 23);
		al.add(s1);
		Student s2 = new Student(102, "Choi", 21);
		al.add(s2);
		Student s3 = new Student(103, "Park", 25);
		al.add(s3);
		Student s4 = new Student(104, "Na", 27);
		al.add(s4);
		Student s5 = new Student(105, "Lee", 20);
		al.add(s5);
		Student s6 = new Student(106, "Jeong", 22);
		al.add(s6);
		Student s7 = new Student(107, "Kim", 26);
		al.add(s7);
		Student s8 = new Student(108, "Park", 28);
		al.add(s8);
		Student s9 = new Student(109, "Choi", 29);
		al.add(s9);
		Student s10 = new Student(110, "Lee", 19);
		al.add(s10);
		
		Collections.sort(al);;
		for(Student s : al) {
			System.out.println(s.toString());
		}
		System.out.println("Student List (reverse ordered by name)");
		
		Collections.sort(al, Collections.reverseOrder());
		for(int i=0 ; i<al.size() ; i++) {
			System.out.println(al.get(i).toString());
		}
	}

}
