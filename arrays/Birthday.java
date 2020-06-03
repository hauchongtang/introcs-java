public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); //number of days
        int trials = Integer.parseInt(args[1]);
        boolean[] birthdays = new boolean[n];
        int[] times = new int[n + 2]; //number of times i people entered the room
        int r;
        int csum = 0;

        for (int t = 1; t <= trials; t++) {

            for (int k = 0; k < n; k++) { //reset birthday
                birthdays[k] = false;
            }

            for (int i = 1; i <= n; i++) { //number of times

                r = (int) (Math.random() * (n - 1)); //random birthday

                if (birthdays[r] == false) {
                    birthdays[r] = true;
                    continue;
                } else if (birthdays[r] == true) {
                    times[i]++; //number of times i people entered the room + 1
                    break;
                }

            }

        }
        int j = 1;
        //System.out.println(times[2]); to check.

        while (((double) csum / trials) < 0.5) {
            csum += times[j];
            System.out.print(j + "\t" + times[j] + "\t" + ((double) csum / trials));
            j++;
            System.out.println("");
        }
    }
}
