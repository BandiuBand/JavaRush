package BandMath;

public class Matrix3x3 {
    private double[][] matrix = new double[3][3];
    private double det;
    private Marix2x2 M1;
    private Marix2x2 M2;
    private Marix2x2 M3;
    public double[] getSolutionFor(double[] parametrs)
    {
        return new Solution(parametrs[0],parametrs[1],parametrs[2]).getSolFromSolutionClass();
    }
    private double X1;
    private double X2;
    private double X3;
    private boolean hasSolution;

    public double[][] getMatrixArray() {
             return matrix;
    }
    public Matrix3x3(double[][] matrix) {
        this.matrix = matrix;
        this.det = det();
        if (det!=0)
            hasSolution = true;
    }
    public Matrix3x3(double a00, double a01, double a02, double a10, double a11, double a12, double a20, double a21, double a22) {
        matrix[0][0] = a00;
        matrix[0][1] = a01;
        matrix[1][0] = a10;
        matrix[1][1] = a11;
        matrix[0][2] = a02;
        matrix[1][2] = a12;
        matrix[2][2] = a22;
        matrix[2][0] = a20;
        matrix[2][1] = a21;
        det = det();
        if (det!=0)
            hasSolution = true;
    }
    class Solution
    {   double S1;
        double S2;
        double S3;
        double X1;
        double X2;
        double X3;
        protected double[] getSolFromSolutionClass()
        {
            solution();
            return new double[]{S1,S2,S3};
        }
        public Solution(double X1,double X2, double X3) {
            if (!hasSolution)
                throw new IllegalArgumentException("treba dopisat kogda net rechenia");
            this.X1=X1;
            this.X2=X2;
            this.X3=X3;
        }
        public void solution()
        {
            S1=solutionXI(0);
            S2=solutionXI(1);
            S3=solutionXI(2);
        }
        private double solutionXI (int I)
        {
            Matrix3x3 mat = new Matrix3x3(getM(I));
            double detX = mat.det;
            System.out.println(detX);
            return detX/det;
        }
        private double[][] getM(int index)
        {
            double[][] result = new double[3][3];
            double[][] inputM = getMatrixArray();
            double[] XM = new double[]{X1,X2,X3};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j==index)
                        result[i][j] = XM[i];
                    else
                    result[i][j] = inputM[i][j];
                }
            }
            return result;
        }
    }
    public double det()
    {
        M1 = new Marix2x2(matrix[1][1],matrix[1][2],matrix[2][1],matrix[2][2]);
        M2 = new Marix2x2(matrix[1][0],matrix[1][2],matrix[2][0],matrix[2][2]);
        M3 = new Marix2x2(matrix[1][0],matrix[1][1],matrix[2][0],matrix[2][1]);
        double minor1 = M1.det*matrix[0][0];
        double minor2 = M2.det*matrix[0][1];
        double minor3 = M3.det*matrix[0][2];
        return minor1-minor2+minor3;
    }
}
