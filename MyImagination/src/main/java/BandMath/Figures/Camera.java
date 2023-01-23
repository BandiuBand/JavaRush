package BandMath.Figures;

public class Camera {
    private Point pozition = new Point(0,0,0);
    private int width = 1024;
    private int height = 768;
    private int focus = 3000;
    private double angleX = 90;
    private double angleY = 0;
    private double angleZ = 90;
    private Pixel[][] picture;
    private int[][] img;
    private LocalDecart localDecart;
    private Ray[][] rays;

    public Camera(Point pozition, int width, int height, int focus, double angleX, double angleY, double angleZ) {
        this.pozition = pozition;
        this.width = width;
        this.height = height;
        this.focus = focus;
        this.angleX = angleX;
        this.angleY = angleY;
        this.angleZ = angleZ;
        Vector X = new Vector(Math.cos(Math.toRadians(angleX)),0,0);
        Vector Y = new Vector(0,Math.cos(Math.toRadians(angleY)),0);
        Vector Z = new Vector(0,0,Math.cos(Math.toRadians(angleZ)));
        localDecart = new LocalDecart(pozition,X,Y,Z);
        picture = new Pixel[height][width];
        img = new int[height][width];
        rays = new Ray[height][width];
        makeRays();
    }
    private void makeRays()
    {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rays[i][j] = new Ray(pozition,new Point(j-width/2,i-height/2,focus));
            }
        }

    }
    public void makePicture(Triangle triangle)
    { Point cross;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((cross = triangle.fiendCrossP(rays[i][j]))!=null)
                {picture[i][j].color = cross.getColor().getRGB();
                    img[i][j] = picture[i][j].color;}
            }
        }
    }
    public int[][] getPicture()
    {
        return img;
    }


}
