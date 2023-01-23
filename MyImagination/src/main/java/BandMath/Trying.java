package BandMath;

import java.util.Arrays;

public class Trying {
    public static void main(String[] args) {
       Matrix3x3 matrix3x3 = new Matrix3x3(2,3,1,3,-1,2,1,4,-1);
        double[] sol = matrix3x3.getSolutionFor(new double[]{1,1,2});
        System.out.println(Arrays.toString(sol));
        Marix2x2 m = new Marix2x2(4,7,6,2);
        System.out.println(m.det);

    }
}
