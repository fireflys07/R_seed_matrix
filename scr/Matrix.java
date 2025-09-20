
public class Matrix {
    public static void main(String[] args) {
        long[] w = new long[11];
        for (int i=0;i<w.length;i++){
            w[i] = 6 + i;
            //System.out.println(i+". "+w[i]);
        }
        float[] x = new float[12];
        for (int j = 0; j<x.length; j++){
            x[j] = (float) (-13 + Math.random()*25);
            //System.out.println(j+". "+x[j]);
        }
        double[][] matrix = new double[11][12];
        for (int i = 0; i < 11; i++)
            for (int j = 0; j < 12; j++) {
                double valX = x[j];

                if (w[i] == 15) {
                    matrix[i][j] = Math.exp
                            (Math.cbrt(Math.pow(0.25 / valX, 5)));

                } else if (w[i] >= 9 && w[i] <= 13) {
                    matrix[i][j] = Math.pow(
                            (1.0 / 4.0) * (Math.asin(1.0 / Math.pow(Math.E, Math.abs(valX))) + 3.0 / 4.0), 3);

                }
                else {
                    double numerator = (1.0 / 4.0 - (Math.atan(1.0 / Math.abs(valX)) / 3.0) / 4.0);
                    double denominator = Math.pow(Math.log(Math.pow(Math.E, Math.E)),
                            Math.atan(Math.cos(Math.tan(Math.sin(valX)))));
                    matrix[i][j] = (1.0 / 3.0) * (numerator / denominator);
                }
            }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.printf("%.3f\t| ", matrix[i][j]);
            }
        }
    }
}
