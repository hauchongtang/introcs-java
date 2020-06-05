public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] > a[j])) counter ++;
            }
        }
        return counter;
    }

    public static int[] generate(int n, long k) {

        // Don't mind these special cases
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] += i;
        }    

        if (n == 1) {

                int[] empty = { 1 };

                return empty;
            }
        if (k == 0) return arr;
        int inversions = 0;
        int i = 0;

        while (inversions < k && i < n) {
            int j = i - 1;
            while (j >= 0 && arr[j] < arr[j + 1] && inversions < k) {
                int helper = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = helper;
                inversions++;
                j--;
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] result = generate(n, k);
        for (int i = 0; i < result.length; i++) {
            StdOut.print(result[i] + " ");
        }
    }
    
}