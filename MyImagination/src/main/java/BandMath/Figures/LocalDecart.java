package BandMath.Figures;

public class LocalDecart {
    private Point position;
    private Vector OX;
    private Vector OY;
    private Vector OZ;

    public LocalDecart(Point position, Vector OX, Vector OY, Vector OZ) {
        this.position = position;
        this.OX = OX;
        this.OY = OY;
        this.OZ = OZ;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setOX(Vector OX) {
        this.OX = OX;
    }

    public void setOY(Vector OY) {
        this.OY = OY;
    }

    public void setOZ(Vector OZ) {
        this.OZ = OZ;
    }

    public Point getPosition() {
        return position;
    }

    public Vector getOX() {
        return OX;
    }

    public Vector getOY() {
        return OY;
    }

    public Vector getOZ() {
        return OZ;
    }
}
