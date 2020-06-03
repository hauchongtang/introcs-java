public class ActivationFunction {
    
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        String r = "NaN";
        double d = Double.parseDouble(r);
        double result;
        if (Double.isNaN(x)) return d;
        else if (x < 0.0) return result = 0.0;
        else if (x == 0.0) return result = 0.5;
        else return result = 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        String r = "NaN";
        double d = Double.parseDouble(r);
        double result;
        if (Double.isNaN(x)) return d;
        else return result = (1 / (1 + Math.exp(-x)));
    }

    // Returns the hypobolic tangent of x.
    public static double tanh(double x) {
        String r = "NaN";
        double d = Double.parseDouble(r);
        double result;
        if (Double.isNaN(x)) return d;
        else if (x >= 20.0) return result = 1.0;
        else if (x <= -20.0) return result = -1.0;
        else return result = (((Math.exp(x)) - (Math.exp(-x))) 
                / ((Math.exp(x)) + (Math.exp(-x))));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        String r = "NaN";
        double d = Double.parseDouble(r);
        double result;
        if (Double.isNaN(x)) return d;
        else if (x == Double.POSITIVE_INFINITY) return result = 1.0;
        else if (x == Double.NEGATIVE_INFINITY) return result = -1.0;
        else return result = (x / (1 + Math.abs(x)));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        String r = "NaN";
        double d = Double.parseDouble(r);
        double result;
        if (Double.isNaN(x)) return d;
        else if (x <= -2.0) return result = -1;
        else if (x > -2.0 && x < 0.0) {
            return result = (x + (x * x / 4.0));
        }
        else if (x >= 0.0 && x < 2.0) {
            return result = (x - (x * x / 4.0));
        }
        else return result = 1.0;
    }

    // Takes a double command-line argument x and prints each activation 
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ")" + " = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ")" + " = " + sigmoid(x));
        StdOut.println("tanh(" + x + ")" + " = " + tanh(x));
        StdOut.println("softsign(" + x + ")" + " = " + softsign(x));
        StdOut.println("sqnl(" + x + ")" + " = " + sqnl(x));
    }
}