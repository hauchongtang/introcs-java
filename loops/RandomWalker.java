public class RandomWalker {
    public static void main(String[] args) {
        int r, counter, x, y;
        r = Integer.parseInt(args[0]);
        x = 0;
        y = 0;
        counter = -1;
        
        while (Math.abs(x) + Math.abs(y) <= r) {
            System.out.println("(" + x + ',' + ' ' + y + ")");
            double random = Math.random();
            if (random < 0.25) y++; // North
            else if (random < 0.5) y--; // South
            else if (random < 0.75) x++; // East
            else x--; // West           
            counter++;
        }
        System.out.println("steps = " + counter);
    }
}
