public class Person implements Comparable {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int compareTo(Object pers) {
		Person pers2 = (Person) pers;
		if (age > pers2.getAge()) {
			return 1;
		} else if (age < pers2.getAge()) {
			return -1;
		} else if (name.compareTo(pers2.getName()) > 0) {
			return 1;
		} else if (name.compareTo(pers2.getName()) < 0) {
			return -1;
		}
		return 0;
	}
}