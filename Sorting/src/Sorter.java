
/*The following methods must exist:

? selectionSort � receives an ArrayList of Integer returns an ArrayList of Integer

? insertionSort � receives an ArrayList of Integer returns an ArrayList of Integer

? mergeSort � receives an ArrayList of Integer returns an ArrayList of Integer

? binarySearch � receives an ArrayList of Integer and a single Integer to search for in the list and
*//*
	returns a boolean
	
	? linearSearch � receives an ArrayList of Integer and a single Integer to search for in the list and
	
	returns a boolean
	
	Selection sort and insertion sort must show the ArrayList after each step during the sorting process.
	
	Binary search must show the values of high, low, and mid during the sorting process.
	
	Example:
	
	Selection Sort:
	
	1,7,2,9,0
	
	0,7,2,9,1
	
	0,1,2,9,7
	
	0,1,2,9,7
	
	0,1,2,7,9
	
	Create a Sorter class that implements the SearchingSortingInterface interface that you just wrote:
	*/
import java.util.ArrayList;

public class Sorter implements SearchingSortingInterface {
	public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {

		for (int y = 0; y < list.size(); y++) {
			int min = y;
			for (int x = y; x < list.size(); x++) {
				if (list.get(x) < list.get(min)) {
					min = x;
				}
			}
			list.add(y, list.get(min));
			list.remove(min + 1);
			System.out.println(list);
		}
		return (list);
	}

	public ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
		for (int x = 0; x < list.size() - 1; x++) {
			if (list.get(x) > list.get(x + 1)) {
				int y = x;
				do {
					int temp = list.get(y);
					list.set(y, list.get(y + 1));
					list.set(y + 1, temp);
					y--;
					System.out.println(list);
				} while ((y >= 0) && (list.get(y) > list.get(y + 1)));
			}
		}
		return list;

	}

	public boolean binarySort(ArrayList<Integer> list, int tar) {
		int low = 0;
		int high = list.size() - 1;
		int med = (low + high) / 2;
		do {
			if (tar > list.get(med)) {
				low = med + 1;
				med = (low + high) / 2;
			} else if (tar < list.get(med)) {
				high = med - 1;
				med = (low + high) / 2;
			} else
				return true;
		} while (low <= high);
		return false;
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		MergeSort m = new MergeSort();
		m.sort(list, 0, list.size() - 1);

		// for (int x=list.size()-1;x>=0;x-=2){
		// list.remove(x);
		// 3}

		return list;
	}

	public boolean linearSort(ArrayList<Integer> list, int tar) {
		for (int x = 0; x < list.size(); x++) {
			if (tar == list.get(x)) {
				return true;
			}
		}
		return false;
	}

}
