import java.util.ArrayList;

public class References {

	public void ArrayListReferences() {
		ArrayList<Integer> riya = new ArrayList<Integer>();
		ArrayList<Integer> izzy = new ArrayList<Integer>();
		ArrayList<Integer> neha = new ArrayList<Integer>();
		ArrayList<Integer> rinzCycle = new ArrayList<Integer>();

		for (int i = 1; i < 5; i++) {
			riya.add(i);
			izzy.add(2 * i);
			neha.add(i * 3);
			rinzCycle.add(i * 4);
		}

		System.out.println("Riya: " + riya);
		System.out.println("Izzy: " + izzy);
		System.out.println("Neha: " + neha);
		System.out.println("RinzCycle: " + rinzCycle);

		System.out.println();
		System.out.println("TRANSFORM");

		izzy = riya;
		neha = riya;
		rinzCycle = riya; // ALL POINTING TO SAME OBJECT. WHAT HAPPENS TO RIYA HAPPENS TO US ALL!!!!!

		System.out.println("Riya: " + riya);
		System.out.println("Izzy: " + izzy);
		System.out.println("Neha: " + neha);
		System.out.println("RinzCycle: " + rinzCycle);

		System.out.println();
		System.out.println("PROOF");

		riya.remove(0);

		System.out.println("Riya: " + riya);
		System.out.println("Izzy: " + izzy);
		System.out.println("Neha: " + neha);
		System.out.println("RinzCycle: " + rinzCycle);
	}

	public void StringReferences() {
		String s1 = "word";
		String s2 = "word";
		String s3 = "abc";
		String s4 = new String("word"); // you don't need to say new

		System.out.println(s2.equals(s1)); // must use .equals method when using strings
		System.out.println(s4.equals(s1));
		System.out.println(s2 == s1); // only works with strings declared without new
		System.out.println(s4 == s1); // will return false

		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf("rd")); // will return first index in which one sees given pattern

		System.out.println(s3.compareTo(s2)); // returns # based on# values of each letter
		System.out.println(s2.compareTo(s3));
		System.out.println(s3.compareTo("abd")); // ex: returns -1 becasue a+b+c=1+2+3=6...a+b+d=1+2+4=7...6-7=-1
		System.out.println(s2.compareTo(s2)); // returns 0 beacuse the same

		String abcs = "abcdefgh";
		System.out.println(abcs.substring(1, 5)); // prints from index 1-5 INCLUSIVE THEN EXCLUSIVE...prints index 1, 2,
													// 3, 4=bcde
		System.out.println(abcs.substring(1, abcs.length())); // not out of bounds
		System.out.println(abcs.substring(1)); // automatically prints from index 1 to the end
	}

	public static void main(String[] args) {

		References ref = new References();
		ref.ArrayListReferences();

		ref.StringReferences();
	}
}