package BandMath.Figures;

import java.awt.*;

public class Point {
        private Color color;

        private double X;
        private double Y;
        private double Z;

        public Point(double x, double y, double z) {
            X = x;
            Y = y;
            Z = z;
        }

        public Point(double x, double y) {
            X = x;
            Y = y;
            Z = 0;
        }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
            return X;
        }

        public double getY() {
            return Y;
        }

        public double getZ() {
            return Z;
        }
        public double[] getMatrix()
        {
            return new double[]{X,Y,Z};
        }
    }

