public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2.0);
    }
    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double x0 = x - length / 2.0, x1 = x + length / 2.0;
        double y0 = y - length / 2.0, y1 = y + length / 2.0;
    // Note -> Top down execution. Draw inner squares first then outer square will cover on top.
        draw(n - 1, x0, y1, length / 2);
        draw(n - 1, x1, y1, length / 2);
        drawSquare(x, y, length);
        draw(n - 1, x0, y0, length / 2);
        draw(n - 1, x1, y0, length / 2);
    }
    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
    // Remember to divide length by 2 as StdDraw library accepts half length instead of full length
        draw(n, 0.5, 0.5, 0.5);
    }
}