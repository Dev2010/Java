public class SquareArray {

	public int[][] fillSquareArray(int len) {
		int counter = 1;
		int[][] arr = new int[len][len];
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				arr[x][y] = counter;
				counter++;
			}
		}
		return arr;
	}

	public void outputArray(int[][] arr) {
		for (int[] x : arr) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	public int rowSum(int[] arr) {
		int sum = 0;
		for (int x = 0; x < arr.length; x++) {
			sum += arr[x];
		}
		return sum;
	}

	public int[] sums(int[][] arr) {
		int[] sums = new int[arr.length];
		for (int x = 0; x < arr.length; x++) {
			sums[x] = rowSum(arr[x]);
		}
		return sums;
	}

	public void outputRowSums(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println();
	}

	public int[][] flipRows(int[][] arr) {
		for (int x = 1; x < arr.length; x += 2) {
			for (int y = 0; y < arr[0].length / 2; y++) {
				int temp = arr[x][y];
				arr[x][y] = arr[x][arr[0].length - y - 1];
				arr[x][arr[0].length - y - 1] = temp;
			}
		}
		return arr;
	}

	public int[][] flipCols(int[][] arr) {
		for (int x = 1; x < arr[0].length; x += 2) {
			for (int y = 0; y < arr.length / 2; y++) {
				int temp = arr[y][x];
				arr[y][x] = arr[arr.length - y - 1][x];
				arr[arr.length - y - 1][x] = temp;
			}
		}
		return arr;
	}
}