public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] ampArr = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            ampArr[i] = a[i] * alpha;
        }
        return ampArr;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] reverseArr = new double[a.length];
        int j = 0;
        for (int i = a.length - 1 ; i >= 0; i--) { // reverse a[]
            reverseArr[j++] = a[i];
        }
        return reverseArr;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int totalSize = a.length + b.length;
        double[] conArr = new double[totalSize];
        for (int i = 0; i < totalSize; i++) { // combine a[] & b[] together
            if (i < a.length) {
                conArr[i] = a[i];
            }
            else conArr[i] = b[i - a.length];
        }
        return conArr;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int lengthMaxarr = Math.max(a.length, b.length);
        int lengthMinarr = Math.min(a.length, b.length);
        double[] sum = new double[lengthMaxarr];
        double[] unpadded = new double[lengthMinarr];
        double[] padded = new double[lengthMaxarr];
        if (Math.abs(a.length - b.length) > 0) { // pad shorter array with zeros
            for (int i = 0; i < lengthMinarr; i++) {
                if (a.length > b.length) unpadded[i] = b[i];
                else if (b.length > a.length) unpadded[i] = a[i];
                padded[i] = unpadded[i];
            }
            for (int i = lengthMinarr; i < lengthMaxarr; i++) {
                padded[i] = 0.0;
            }
        }
        for (int i = 0; i < sum.length; i++) {
            if (a.length > b.length) sum[i] = a[i] + padded[i];
            else if (b.length > a.length) sum[i] = padded[i] + b[i];
            else sum[i] = a[i] + b[i];
        }
        return sum;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] arrSpeed = new double[(int) (a.length / alpha)];
        for (int i = 0; i < arrSpeed.length; i++) {
            arrSpeed[i] = a[(int) alpha * i];
        }
        return arrSpeed;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {

        // read wav files as double[] array
        double[] beatbox = StdAudio.read("beatbox.wav"); 
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        
        // modify wav arrays
        double[] ampBeatbox = amplify(beatbox, 3.0); 
        double[] reverseChimes = reverse(chimes);
        double[] mixCowdialup = mix(cow, dialup);
        double[] speedBuzzer = changeSpeed(buzzer, 2.0);
        
        // Merge all arrays!
        double[] mergeAll = merge(merge(ampBeatbox, speedBuzzer), merge(mixCowdialup, reverseChimes));

        // Save in .wav format
        StdAudio.save("gibberishAudio.wav", mergeAll);
        StdAudio.play("gibberishAudio.wav");
    }
}