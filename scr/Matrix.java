public class Matrix {
    public static void main(String[] args) {
        long[] w = buildW();
        float[] x = buildX();
       

        double[][] w1 = new double[w.length][x.length];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < x.length; j++) {
                w1[i][j] = computeValue(w[i], x[j]);
            }
        }

        printMatrix(w1);
    }

    public static long[] buildW() {
        long[] w = new long[11];
        for (int i = 0; i < w.length; i++) w[i] = 6 + i;
        return w;

    }

    public static float[] buildX() {
        float[] x = new float[12];
        for (int j = 0; j < x.length; j++) {
            x[j] = (float) (-13.0 + Math.random() * 25.0);
        }
        return x;
    }

    public static double computeValue(long wi, float xj) {
        double xv = xj;
        // Ветка 1 если w1[i]=  15
        // e^(cuberoot((0.25/x)^2))
        if (wi == 15) {
            double base = Math.pow(0.25 / xv, 2.0);
            return Math.exp(Math.cbrt(base));
        }
        // Ветка 2 если w1[i] {9,10,11,12,13}
        // Формула ((1/4) / (arcsin(1/e^{|x|}) + 3/4))^3
        if (wi >= 9 && wi <= 13) {
            double denom = Math.asin(1.0 / Math.exp(Math.abs(xv))) + 0.75;
            double frac = 0.25 / denom;
            return Math.pow(frac, 3.0);
        }
        // Ветка 3 для всех прочих значений

        // a = ( ((1/3) / ( 1/4 - ( arctan(1/e^{|x|}) / 3 ) / 4 )) ^ ( ln(e^x) ) ) * arctan( cos( tan( sin(x) ) ) )
        // Замечание: ln(e^x) = x (используем как степень)
        double center = 0.25 - (Math.atan(1.0 / Math.exp(Math.abs(xv))) / 3.0) / 4.0;
        double base = (1.0 / 3.0) / center;
        double pow = Math.log(Math.exp(xv)); // = xv
        double left = Math.pow(base, pow);
        double right = Math.atan(Math.cos(Math.tan(Math.sin(xv))));
        return left * right;
    }

    public static void printMatrix(double[][] w1) {
        for (int i = 0; i < w1.length; i++) {
            for (int j = 0; j < w1[i].length; j++) {
                System.out.printf("|%8.3f",w1[i][j]);
            }
            System.out.println("|");
        }
    }
}
