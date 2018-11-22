import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {

		Person personOne = new Person("Bob", 20);
		Person personTwo = new Person("Bob", 25);
		Person personThree = new Person("Boa", 20);
		Person personFour = new Person("Bob", 20);
		System.out.println("1 to 2: " + personOne.compareTo(personTwo)); // -1
		System.out.println("1 to 3: " + personOne.compareTo(personThree)); // 1
		System.out.println("2 to 3: " + personTwo.compareTo(personThree)); // 1
		System.out.println("1 to 4: " + personOne.compareTo(personFour)); // 0

		Student stud1 = new Student("Bob", 20, "student");
		Student stud2 = new Student("Boa", 20, "student");
		Student stud3 = new Student("Boa", 19, "student");
		System.out.println("s1 to 1: " + stud1.compareTo(personOne)); // -1
		System.out.println("s1 to s2: " + stud1.compareTo(stud2)); // 1
		System.out.println("s1 to s3: " + stud1.compareTo(stud3)); // 1

		Teacher tea1 = new Teacher("Bob", 20, "student");
		Teacher tea2 = new Teacher("Boa", 20, "teacher");
		Teacher tea3 = new Teacher("Boa", 19, "teacher");
		System.out.println("t1 to s1: " + tea1.compareTo(stud1)); // -1;
		System.out.println("t1 to 1: " + tea1.compareTo(personOne)); // -1;
		System.out.println("t1 to t2: " + tea1.compareTo(tea2)); // 1
		System.out.println("t1 to t3: " + tea1.compareTo(tea3)); // 1

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(personOne);
		list.add(personTwo);
		list.add(personThree);
		list.add(personFour);
		/*
		 * list.add(stud1); list.add(stud2); list.add(stud3); list.add(tea1);
		 * list.add(tea2); list.add(tea3);
		 */

		int min;
		for (int y = 0; y < list.size(); y++) {
			min = y;
			for (int x = y; x < list.size(); x++) {
				if (list.get(x).compareTo(list.get(min)) < 0) {
					min = x;
				}
			}
			Person temp = new Person(list.get(y).getName(), list.get(y).getAge());
			list.set(y, list.get(min));
			list.set(min, temp);
		}

		for (int x = 0; x < list.size(); x++) { // prints list
			if (list.get(x) instanceof Student) {
				System.out.print("Student ");
			} else if (list.get(x) instanceof Teacher) {
				System.out.print("Teacher ");
			}
			System.out.println(list.get(x).getName() + " is " + list.get(x).getAge() + " years old");
		}
	}
}