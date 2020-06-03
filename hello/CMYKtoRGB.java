public class CMYKtoRGB {
    public static void main(String[] args) {
        double c, m, y, k, w, r, g, blue;
        c = Double.parseDouble(args[0]);
        m = Double.parseDouble(args[1]);
        y = Double.parseDouble(args[2]);
        k = Double.parseDouble(args[3]);
        w = 1 - k;
        r = 255 * w * (1 - c);
        g = 255 * w * (1 - m);
        blue = 255 * w * (1 - y);
        System.out.println("red = " + Math.round(r));
        System.out.println("green = " + Math.round(g));
        System.out.println("blue = " + Math.round(blue));
    }
}
