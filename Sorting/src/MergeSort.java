import java.util.ArrayList;

public class MergeSort {

	public void sort(ArrayList<Integer> array, int lo, int n) {
		// low,middle, and high are index(positional) values for the list
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		sort(array, low, middle);
		sort(array, middle + 1, high);
		int endLow = middle;
		int startHigh = middle + 1;
		while ((lo <= endLow) && (startHigh <= high)) {
			if (array.get(low) < array.get(startHigh)) {
				low++;
			} else {
				int temp = array.get(startHigh);
				for (int k = startHigh - 1; k >= low; k--) {
					array.set(k + 1, array.get(k));
				}
				array.set(low, temp);
				low++;
				endLow++;
				startHigh++;
			}
		}
	}

}