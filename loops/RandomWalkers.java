public class RandomWalkers {
    public static void main(String[] args) {
        int r, trials, x, y, counter;
        r = Integer.parseInt(args[0]);
        trials = Integer.parseInt(args[1]);
        counter = -1;
        x = 0;
        y = 0;
        double total = 0.0;
        double average = 0.0;
        for (int i = 0; i <= trials; i++) {
            while (Math.abs(x) + Math.abs(y) < r) {
            double random = Math.random();
            if (random < 0.25) y++; // North
            else if (random < 0.5) y--; // South
            else if (random < 0.75) x++; // East
            else x--; // West           
            counter++;
            }
            total = total + counter;
            average = total / trials;
        }
        System.out.println("average number of steps = " + average);
    }
}
