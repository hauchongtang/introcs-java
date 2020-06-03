public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(args[i + 1]);
        }
        int csum = 0;
        for (int i = 0; i < n; i++) {
            csum += seq[i];
            //System.out.print(csum + " ");
        }
        for (int i = 0; i < m; i++) {
            int random = (int) (csum * Math.random());
            int sum = 0;
            int uniqueJ = -1;
            for (int j = 0; j < n && sum <= random; j++) {
                sum += seq[j];
                uniqueJ = j + 1;
            }
            System.out.print(uniqueJ + " ");
        }
    }
}
