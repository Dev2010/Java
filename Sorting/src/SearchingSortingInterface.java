import java.util.ArrayList;

public interface SearchingSortingInterface {
	public ArrayList<Integer> selectionSort(ArrayList<Integer> list);

	public ArrayList<Integer> insertionSort(ArrayList<Integer> list);

	public boolean binarySort(ArrayList<Integer> list, int tar);

	public ArrayList<Integer> mergeSort(ArrayList<Integer> list);

	public boolean linearSort(ArrayList<Integer> list, int tar);
}
