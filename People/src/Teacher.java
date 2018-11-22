public class Teacher extends Person {
	private String job;

	public Teacher(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}

	public int compareTo(Object stud) {
		if (!(stud instanceof Teacher)) {
			return -1;
		}

		return super.compareTo(stud);

		/*
		 * if (getAge()>pers2.getAge()){ return 1; } else if (getAge()<pers2.getAge()){
		 * return -1; } else if (getName().compareTo(pers2.getName())>0){ return 1; }
		 * else if (getName().compareTo(pers2.getName())<0){ return -1; } return 0;
		 */
	}
}