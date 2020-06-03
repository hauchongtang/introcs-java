public class ShannonEntropy {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		double entropy = 0.0;
		int[] freq = new int[m + 1];
		int n = 0;
		while(!StdIn.isEmpty()) {
			int value = StdIn.readInt();
			freq[value]++;
			n++;
		}
		for (int i = 1; i <= m; i++) {
			double p = (double) freq[i] / n;
			if (freq[i] > 0) {
				entropy -= p * (Math.log(p) / Math.log(2));
			}
		}
		StdOut.printf("%.4f\n" ,entropy);
	}
}