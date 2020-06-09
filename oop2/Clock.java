public class Clock {

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format
    // HH:MM.
    public Clock(String s) {
        if (!s.matches("[0-9][0-9]:[0-9][0-9]"))
            throw new IllegalArgumentException("Use format HH:MM");
        hours = Integer.parseInt(s.substring(0, 2));
        minutes = Integer.parseInt(s.substring(3, 5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        int h = this.hours, m = this.minutes, hr = that.hours, min = that.minutes;
        if (h < hr)
            return true;
        if (h > hr)
            return false;
        return (m < min);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes += 1;
        if (minutes > 59) {
            minutes = 0;
            hours += 1;
        }
        if (hours == 24) hours = 0;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta cannot be negative!");
        int hToc = delta / 60;
        int mToc = delta % 60;
        hours += hToc;
        minutes += mToc;
        if (minutes > 59) {
            minutes = 0;
            hours += 1;
        }
        if (hours == 24) hours = 0;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock start = new Clock(args[0]);
        Clock end = new Clock(args[1]);
        for (Clock x = start; x.isEarlierThan(end); x.tic()) {
            StdOut.println(x);
        }
        for (Clock x = start; x.isEarlierThan(end); x.toc(126)) {
            StdOut.println(x);
        }
    }
}