package BandMath;

public class Marix2x2 {
    protected double a00;
    protected double a01;
    protected double a10;
    protected double a11;
    protected double det;

    public Marix2x2(double a00, double a01, double a10, double a11) {
        this.a00 = a00;
        this.a01 = a01;
        this.a10 = a10;
        this.a11 = a11;
        this.det = det();
    }

    public Marix2x2(double[][] matrix) {
        if (matrix == null || matrix.length!=2 || matrix[0].length!=2)
            throw new IllegalArgumentException(matrix.toString());
        this.a00 = matrix[0][0];
        this.a01 = matrix[0][1];
        this.a10 = matrix[1][0];
        this.a11 = matrix[1][1];
        this.det = det();
    }
    private double det ()
    {
        return (a00*a11)-(a01*a10);
    }
    public void setMatrix(double[][] matrix)
    {
        if (matrix == null || matrix.length!=2 || matrix[0].length!=2)
            throw new IllegalArgumentException(matrix.toString());
        this.a00 = matrix[0][0];
        this.a01 = matrix[0][1];
        this.a10 = matrix[1][0];
        this.a11 = matrix[1][1];
        this.det = det();
    }
}
