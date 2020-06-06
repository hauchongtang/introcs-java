import java.io.File;

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxRepeats = 0;
        // substr(0, 3) substr(1, 4) substr(2, 5) ... 
        for (int i = 0; i <= dna.length() - 3; i++) {
            int j = 0;
            int count = 0;
            while(i + j <= dna.length() - 3 && (dna.substring(i + j, i + j + 3)).equals("CAG")) {
                j += 3;
                count++;
            }
            maxRepeats = Math.max(maxRepeats, count);
        }
        return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
    // removed.
    public static String removeWhitespace(String s) {
        return s.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of
    // repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if ((maxRepeats >= 0 && maxRepeats <= 9) || maxRepeats > 180)
            return "not human";
        else if (maxRepeats >= 10 && maxRepeats <= 35)
            return "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39)
            return "high risk";
        else 
            return "Huntington’s";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String s = args[0];
        File file = new File(s);
        In b = new In("./" + file);
        s = b.readAll();
        int d = maxRepeats(removeWhitespace(s));
        StdOut.println("max repeats = " + d);
        StdOut.println(diagnose(d));
    }

}