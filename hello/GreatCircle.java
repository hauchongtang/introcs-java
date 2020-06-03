public class GreatCircle {
    public static void main(String[] args) {
        double x1, x2, y1, y2, r, distance;
        x1 = Math.toRadians(Double.parseDouble(args[0]));
        y1 = Math.toRadians(Double.parseDouble(args[1]));
        x2 = Math.toRadians(Double.parseDouble(args[2]));
        y2 = Math.toRadians(Double.parseDouble(args[3]));
        r = 6371.0;
        distance = (2 * r) 
                    * 
                    Math.asin(
                              Math.sqrt(
                                        Math.pow(Math.sin((x2 - x1)/2), 2) 
                                        + (Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1)/2), 2))));
        
        

        System.out.println(distance + " kilometers");
    }
}
