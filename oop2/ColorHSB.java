public class ColorHSB {

    private final int hue;
    private final int sat;
    private final int bright;
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        sat = s;
        bright = b;
        if (hue < 0 || hue > 359) throw new IllegalArgumentException("hue out of bounds as hue < 0 or > 359");
        if (sat < 0 || sat > 100) throw new IllegalArgumentException("sat out of bounds as sat < 0 or > 100");
        if (bright < 0 || bright > 100) throw new IllegalArgumentException("bright out of bounds as bright < 0 or > 100");
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    // A color in HSB format is a shade of gray if either its saturation or
    // brightness component is 0% (or both)
    public boolean isGrayscale() {
        if (sat == 0 && bright == 0) return true;
        else if (sat == 0 || bright == 0) return true;
        else return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("argument cannot be null");
        int h1 = this.hue, h2 = that.hue, s1 = this.sat, s2 = that.sat, b1 = this.bright, b2 = that.bright;
        return Math.min((h1 - h2) * (h1 - h2), (360 - Math.abs(h1 - h2)) * (360 - Math.abs(h1 - h2))) + (s1 - s2) * (s1 - s2) + (b1 - b2) * (b1 - b2);
        
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h0 = Integer.parseInt(args[0]);
        int s0 = Integer.parseInt(args[1]);
        int b0 = Integer.parseInt(args[2]);
        ColorHSB color0 = new ColorHSB(h0, s0, b0);

        String closestName = null;
        ColorHSB closestColor = null;
        int closestDistance = Integer.MAX_VALUE;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();
            ColorHSB color = new ColorHSB(hue, saturation, brightness);

            int distance = color0.distanceSquaredTo(color);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestColor = color;
                closestName = name;
            }
        }
        StdOut.println(closestName + " " + closestColor);
    }

}