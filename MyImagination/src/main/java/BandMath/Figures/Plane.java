package BandMath.Figures;

import BandMath.CollideWithRay;
import BandMath.Matrix3x3;

public class Plane implements CollideWithRay {
    private double A;
    private double B;
    private double C;
    private double D;
    private Vector normal;

    public Plane(double a, double b, double c, double d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public Plane(Point A, Point B, Point C) {
        double[][] mat = new double[3][3];
        mat[0] = A.getMatrix();
        mat[1] = B.getMatrix();
        mat[2] = C.getMatrix();

        Matrix3x3 matrix = new Matrix3x3(mat);
        double[] result = matrix.getSolutionFor(new double[]{-1,-1,-1});
        this.A=result[0];
        this.B=result[1];
        this.C=result[2];
        this.D=-1;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double getC() {
        return C;
    }

    public double getD() {
        return D;
    }
    public Vector getNormal()
    {
        if (normal == null)
            normal = new Vector(A,B,C);
        return normal;
    }

    @Override
    public Point fiendCrossP(Ray ray) {
        Matrix3x3 matrix = new Matrix3x3(ray.getA1(), ray.getB1(), ray.getC1(), ray.getA2(), ray.getB2(), ray.getC2(), A,B,C);
        double[] res;
        try {
           res = matrix.getSolutionFor(new double[]{ray.getD1(),ray.getD2(),D});
        }
        catch (Exception e)
        {
            return null;
        }

        return new Point(res[0],res[1],res[2]);
    }
}
