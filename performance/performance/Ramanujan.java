public class Ramanujan {

    // Is n a Ramanujan number?
    // n = a^3 + b^3 = c^3 + d^3 where a,b,c,d are unqiue
    public static boolean isRamanujan(long n) {
        // n --> n^(1/3)
        long nThird = (long) Math.ceil(Math.cbrt(n));
        long i = 1;
        long sum;
        int counter = 0 ;
        while (i < nThird) {
            sum = (i * i * i) + (nThird * nThird * nThird);
            if (sum > n) nThird += -1; 
            else if (sum < n) i += 1;
            else {
                counter++;
                i += 1;
            }
        }
        return (counter >= 2);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}