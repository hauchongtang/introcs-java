public class RevesPuzzle {

    private static void reves(int n, String from, String tempone, String temptwo, String to) {
        if (n == 0) return;
        int k = (int)(n + Math.round(1.0 - Math.sqrt(2 * n + 1)));

        reves(k, from, to, tempone, temptwo);
        hanoi(k, n - k, from, tempone, to);
        reves(k, temptwo, from, tempone, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (k == 0) return;
        hanoi(n, k - 1, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n, k - 1, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}