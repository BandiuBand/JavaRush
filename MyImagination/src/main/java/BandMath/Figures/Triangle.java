package BandMath.Figures;

import BandMath.CollideWithRay;

import java.awt.*;

public class Triangle implements CollideWithRay {
        private Color color = Color.BLACK;

        private Point A;
        private Point B;
        private Point C;
        private Plane plane;

        public Triangle(double xA, double yA, double zA,double xB, double yB, double zB,double xC, double yC, double zC) {
            A = new Point(xA,yA,zA);
            B = new Point(xB,yB,zB);
            C = new Point(xC,yC,zC);
        }
        public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
            A = new Point(xA,yA,0);
            B = new Point(xB,yB,0);
            C = new Point(xC,yC,0);
        }

        public Point getA() {
            return A;
        }
        public Point getB() {
            return B;
        }
        public Point getC() {
            return C;
        }
        public double getX(Point p)
        {
            return p.getX();
        }
        public double getY(Point p)
        {
            return p.getY();
        }
        public double getZ(Point p)
        {
            return p.getZ();
        }

        public boolean isInside(double X, double Y)

        {
            Point P = new Point(X,Y);
            Vector vectorAP = vecMultiplic(new Vector(A,B),new Vector(A,P));
            Vector vectorBP = vecMultiplic(new Vector(B,C),new Vector(B,P));
            Vector vectorCP = vecMultiplic(new Vector(C,A),new Vector(C,P));
            byte is_AP = vectorAP.getZ()>=0?(byte)1:(vectorAP.getZ()<0?(byte)2:(byte)0);
            byte is_BP = vectorBP.getZ()>=0?(byte)1:(vectorBP.getZ()<0?(byte)2:(byte)0);
            byte is_CP = vectorCP.getZ()>=0?(byte)1:(vectorCP.getZ()<0?(byte)2:(byte)0);
            if (is_AP==is_CP&&is_CP==is_BP)
                return true;
            if (((is_AP==is_CP&&is_BP==0) || (is_BP==is_CP&&is_AP==0) || (is_AP==is_BP&&is_CP==0))||
                    ((is_AP == 0 && is_BP == 0)||(is_CP == 0 && is_BP == 0)||(is_AP == 0 && is_CP == 0)))
                return true;
            return  false;

        }
    public boolean isInside(Point point)

    {
        Point P = point;
        double resA = Vector.mixedProduct(this.plane.getNormal(),new Vector(point,A),new Vector(point,B));
        double resB = Vector.mixedProduct(this.plane.getNormal(),new Vector(point,A),new Vector(point,C));
        double resC = Vector.mixedProduct(this.plane.getNormal(),new Vector(point,B),new Vector(point,C));
        byte is_AP = resA>=0?(byte)1:(resA<0?(byte)2:(byte)0);
        byte is_BP = resB>=0?(byte)1:(resB<0?(byte)2:(byte)0);
        byte is_CP = resC>=0?(byte)1:(resC<0?(byte)2:(byte)0);
        if (is_AP==is_CP&&is_CP==is_BP)
            return true;
        if (((is_AP==is_CP&&is_BP==0) || (is_BP==is_CP&&is_AP==0) || (is_AP==is_BP&&is_CP==0))||
                ((is_AP == 0 && is_BP == 0)||(is_CP == 0 && is_BP == 0)||(is_AP == 0 && is_CP == 0)))
            return true;
        return  false;

    }

        public Vector vecMultiplic(Vector a,Vector b)
        {
            double X = a.getY()*b.getZ() - a.getZ()*b.getY();
            double Y = a.getZ()*b.getX() - a.getX()*b.getZ();
            double Z = a.getX()*b.getY() - a.getY()*b.getX();
            return new Vector(X,Y,Z);
        }
        public double[][] getMatrix3x3()
        {
            double[][] m = new double[3][3];
            m[0] = A.getMatrix();
            m[1] = B.getMatrix();
            m[2] = C.getMatrix();
            return m;
        }
        public Plane getPlane()
        {
            if (plane == null)
                plane = new Plane(A,B,C);
            return plane;
        }

    @Override
    public Point fiendCrossP(Ray ray) {
            try{
            Point res = this.getPlane().fiendCrossP(ray);
            res.setColor(this.color);
            if (this.isInside(res))
                return res;
            }
            catch (Exception e)
            {}
            return null;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
