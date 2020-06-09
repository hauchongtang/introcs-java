import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double coefficient = 1.0 / 16.0;
        double[][] weights = {{1.0 * coefficient, 2.0 * coefficient, 1.0 * coefficient}, 
                             {2.0 * coefficient, 4.0 * coefficient, 2.0 * coefficient}, 
                             {1.0 * coefficient, 2.0 * coefficient, 1.0 * coefficient}};
        
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {{0.0, -1.0, 0.0}, {-1.0, 5.0, -1.0}, {0.0, -1.0, 0.0}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = { { -1.0, -1.0, -1.0 }, { -1.0, 8.0, -1.0 }, { -1.0, -1.0, -1.0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {{-2.0, -1.0, 0.0}, {-1.0, 1.0, 1.0}, {0.0, 1.0, 2.0}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i ++) {
            weights[i][i] = 1.0 / 9.0;
        }
        return kernel(picture, weights);
    }

    private static int convert(double RGB) { // Handle Clamping cases
        return (int) Math.round(Math.max(0, Math.min(255, RGB)));
    }
    
    private static Picture kernel(Picture picture, double[][] weights) { // Do convolutions of kernel matrix and filters
        int weightSize = weights.length;
        int height = picture.height();
        int width = picture.width();
        Picture newPic = new Picture(width, height);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                double red = 0, green = 0, blue = 0;
                for (int i = 0; i < weightSize; i++) {
                    for (int j = 0; j < weightSize; j++) {
                        int findCol = (col + i - (weightSize / 2) + width) % width; // Wrapping
                        int findRow = (row + j - (weightSize / 2) + height) % height;
                        Color getSourcecolor = picture.get(findCol, findRow);
                        red += getSourcecolor.getRed() * weights[i][j];
                        green += getSourcecolor.getGreen() * weights[i][j];
                        blue += getSourcecolor.getBlue() * weights[i][j];
                    }
                }
                int r = convert(red);
                int g = convert(green);
                int b = convert(blue);
                Color rgb = new Color(r, g, b);
                newPic.set(col, row, rgb);
            }
        }
        return newPic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        gaussian(picture).save("gaussian.png");
        sharpen(picture).save("sharpen.png");
        laplacian(picture).save("laplacian.png");
        emboss(picture).save("emboss.png");
        motionBlur(picture).save("motionBlur.png");
    }
}