
public class MultiDimensionalArray {

	public void FillArrayIncrementRow() {

	}

	public void FillArrayIncrementColumn() {

	}
	
	public void Summation() {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 0, 2, 4, 6, 8 }, { 1, 3, 5, 7, 9 }, };

		int[] row = new int[arr.length];
		int[] col = new int[arr[0].length];
		int[] arry;

		for (int x = 0; x < arr.length; x++) {
			arry = arr[x];
			for (int y = 0; y < arr[0].length; y++) {
				if (arry[y] % 2 == 0) {
					row[x] += arry[y];
					col[y] += arry[y];
				}
			}
		}

		System.out.print("ROW SUM: ");
		for (int x = 0; x < row.length; x++) {
			System.out.print(row[x] + ", ");
		}

		System.out.println();

		System.out.print("COLUMN SUM: ");
		for (int x = 0; x < col.length; x++) {
			System.out.print(col[x] + ", ");
		}
	}

	public static void main(String[] args) { // ye. game
		MultiDimensionalArray multiarray = new MultiDimensionalArray();
		multiarray.Summation();

	}
}
