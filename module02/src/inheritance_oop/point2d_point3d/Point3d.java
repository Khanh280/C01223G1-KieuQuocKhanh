package inheritance_oop.point2d_point3d;

public class Point3d extends Point2d {
    private float z;

    public Point3d() {
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] XYZ = new float[3];
        XYZ[0] = this.getX();
        XYZ[1] = this.getY();
        XYZ[2] = this.z;
        return XYZ;
    }

    public void setXYZ(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.z + ")";
    }
}
