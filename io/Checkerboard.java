public class Checkerboard {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		StdDraw.setScale(0, n);
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				if ((row + column) % 2 == 0) {
					StdDraw.setPenColor(StdDraw.BLUE);
				}
				else StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
				StdDraw.filledSquare(row + 0.5, column + 0.5, 0.5);
			}
		}
	}
}