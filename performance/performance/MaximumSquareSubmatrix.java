public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {

        int n = a.length;
        int[] dp = new int[n + 1];
        int maxLength = 0;
        int prevInt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (a[i - 1][j - 1] == 1) {
                    dp[j] = Math.min(Math.min(dp[j - 1], prevInt), dp[j]) + 1;
                    maxLength = Math.max(dp[j], maxLength);
                } else {
                    dp[j] = 0;
                }
                prevInt = temp;
            }
        }

        // To calculate area --> maxLength * maxLength
        return maxLength;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(final String[] args) {

        int n = 0;
        // Only take first integer from square.txt
        if (!StdIn.isEmpty()) n = StdIn.readInt();

        // Initialize a
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}