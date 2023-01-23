package BandMath.Figures;

public class Ray {
    private double A1;
    private double A2;
    private double B1;
    private double B2;
    private double C1;
    private double C2;
    private double D1;
    private double D2;

    private Vector vector;

    public Ray(Plane plane1, Plane plane2) {
        A1 =  plane1.getA();
        A2 =  plane2.getA();
        B1 =  plane1.getB();
        B2 =  plane2.getB();
        C1 =  plane1.getC();
        C2 =  plane2.getC();
        D1 =  plane1.getD();
        D2 =  plane2.getD();
    }

    public Ray(Point pointA,Point pointB) {
        this.vector = Vector.normirovkaVect(new Vector(pointA,pointB));
        A1 =  1/vector.getX();
        A2 =  0;
        B1 = -1/vector.getY();
        B2 =  1/vector.getY();
        C1 =  0;
        C2 = -1/vector.getZ();
        D1 = (pointA.getY()/vector.getY())-(pointA.getX()/vector.getX());
        D2 = (pointA.getZ()/vector.getZ())-(pointA.getY()/vector.getY());
    }
    public Ray(Vector vector, Point point)
    {
        this.vector = Vector.normirovkaVect(vector);
        A1 =  1/vector.getX();
        A2 =  0;
        B1 = -1/vector.getY();
        B2 =  1/vector.getY();
        C1 =  0;
        C2 = -1/vector.getZ();
        D1 = (point.getY()/vector.getY())-(point.getX()/vector.getX());
        D2 = (point.getZ()/vector.getZ())-(point.getY()/vector.getY());
    }
    public Plane getPlane1()
    {return new Plane(A1,B1,C1,D1);}
    public Plane getPlane2()
    {return new Plane(A2,B2,C2,D2);}
    public Vector getVector()
    {
        return vector;
    }

    public double getA1() {
        return A1;
    }

    public double getA2() {
        return A2;
    }

    public double getB1() {
        return B1;
    }

    public double getB2() {
        return B2;
    }

    public double getC1() {
        return C1;
    }

    public double getC2() {
        return C2;
    }

    public double getD1() {
        return D1;
    }

    public double getD2() {
        return D2;
    }
}
