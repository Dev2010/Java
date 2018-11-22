public class Runner {
	public static void main(String[] args) {
		SquareArray SQ = new SquareArray();

		int[][] arr = SQ.fillSquareArray(4);
		System.out.println("ARRAY");
		SQ.outputArray(arr);
		System.out.println();

		System.out.println("SUMS");
		SQ.outputRowSums(SQ.sums(arr));
		System.out.println();

		System.out.println("FLIPPED ROWS");
		SQ.outputArray(SQ.flipRows(arr));
		System.out.println();

		arr = SQ.fillSquareArray(4);
		System.out.println("FLIPPED COLS");
		SQ.outputArray(SQ.flipCols(arr));
		System.out.println();
	}
}
