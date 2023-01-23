package BandMath.Figures;


import BandMath.Matrix3x3;

public class Vector extends Point
{

    public Vector(Point begin, Point end) {
        super(end.getX()- begin.getX(), end.getY()- begin.getY(), end.getZ()- begin.getZ());
    }
    public static Vector normirovkaVect(Vector vector)
    {   double k = vector.getX()/3+ vector.getY()/3+ vector.getZ()/3;
        return new Vector(vector.getX()/k, vector.getY()/k, vector.getZ()/k );
    }
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }
    public static Vector vecMultiplication(Vector a,Vector b)
    {
        double X = a.getY()*b.getZ() - a.getZ()*b.getY();
        double Y = a.getZ()*b.getX() - a.getX()*b.getZ();
        double Z = a.getX()*b.getY() - a.getY()*b.getX();
        return new Vector(X,Y,Z);
    }
    public Vector vecMultiplication(Vector vector)
    {
        return vecMultiplication(this,vector);
    }
    public double scalarMultication (Vector vector)
    {
        return vector.getX()*this.getX()+vector.getY()*this.getY()+ vector.getZ()*this.getZ();
    }
    public static double mixedProduct(Vector vector1,Vector vector2,Vector vector3)
    {
        return new Matrix3x3(vector1.getX(),vector1.getY(),vector1.getZ(),
                vector2.getX(),vector2.getY(),vector2.getZ(),
                vector3.getX(),vector3.getY(),vector3.getZ()).det();
    }
    public boolean isPerpendicular (Vector vector)
    {
        if (Math.abs(this.scalarMultication(vector))<0.00000000000000000001)
            return true;
        return false;
    }
}
