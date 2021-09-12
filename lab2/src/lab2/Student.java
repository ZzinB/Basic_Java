package lab2;

public class Student implements Comparable<Student>{
	int no;
	String name;
	int age;
	
	public Student(int no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}
	/*public int getNo(){
		return no;
	}
		public void setNo(int no) {}
	public String getName() {
		return name;
	}
	public void setName(String name) {}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {}
*/
	@Override
	public String toString() {
		String s = "Student [no = "+no+", name = "+name+", "+age+"]";
		return s;
	}
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
	
}
