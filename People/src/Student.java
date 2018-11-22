public class Student extends Person {
	private String job;

	public Student(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}

	public int compareTo(Object stud) {
		if (stud instanceof Teacher) {
			return 1;
		} else if (!(stud instanceof Student)) {
			return -1;
		}
		Person pers2 = (Person) stud;
		if (super.getAge() > pers2.getAge()) {
			return 1;
		} else if (super.getAge() < pers2.getAge()) {
			return -1;
		} else if (super.getName().compareTo(pers2.getName()) > 0) {
			return 1;
		} else if (super.getName().compareTo(pers2.getName()) < 0) {
			return -1;
		}
		return 0;
	}
}