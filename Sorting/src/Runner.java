import java.util.ArrayList;

public class Runner {// 3extends mar13SortsP{
	public static void main(String[] args) {
		Sorter s = new Sorter();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int x = 0; x < 20; x++) { // fills list
			list.add((int) (Math.random() * 200) + 1);
		}

		System.out.println("SELECTION");
		System.out.println(s.selectionSort(list));

		for (int x = list.size() - 1; x >= 0; x--) { // cleans list
			list.remove(x);
		}

		for (int x = 0; x < 20; x++) { // fills list
			list.add((int) (Math.random() * 200) + 1);
		}

		System.out.println("INSERTION");
		System.out.println(s.insertionSort(list));

		System.out.println("BINARY");
		System.out.println(s.binarySort(list, 2));

		for (int x = list.size() - 1; x >= 0; x--) { // cleans list
			list.remove(x);
		}

		for (int x = 0; x < 20; x++) { // fills list
			list.add((int) (Math.random() * 200) + 1);
		}

		System.out.println("MERGE");
		System.out.println(s.mergeSort(list));

	}
}