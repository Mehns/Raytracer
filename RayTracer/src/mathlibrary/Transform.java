package mathlibrary;

import java.util.Objects;

/**
 *
 * @author Lena
 */
public class Transform {

    /**
     * transform
     */
    public final Mat4x4 m;

    /**
     * inverse
     */
    public final Mat4x4 i;

    /**
     * public constructor constructs a Transform and initializes attribute m
     * with identity matrix
     */
    public Transform() {
        this.m = new Mat4x4(1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);

        this.i = new Mat4x4(1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    /**
     * Constructor
     * private constructor constructs a Transform
     * @param m 4x4 matrix
     * @param i inverse of m
     */
    private Transform(final Mat4x4 m, final Mat4x4 i) {
        this.m = m;
        this.i = i;
    }

    /**
     * appends a translation by the given x, y, and z values to this transform
     * @param x value for the translation
     * @param y value for the translation
     * @param z value for the translation
     * @return new Transformation
     */
    public Transform translate(final double x, final double y, final double z) {
        Mat4x4 tm = new Mat4x4(1.0, 0.0, 0.0, x,
                               0.0, 1.0, 0.0, y,
                               0.0, 0.0, 1.0, z,
                               0.0, 0.0, 0.0, 1.0);
        Mat4x4 ti = new Mat4x4(1.0, 0.0, 0.0, -x,
                               0.0, 1.0, 0.0, -y,
                               0.0, 0.0, 1.0, -z,
                               0.0, 0.0, 0.0, 1.0);
        return new Transform(m.mul(tm), ti.mul(i));
    }

    /**
     * appends a scale transformation by given x, y, and z values to this transform
     * @param x scale factor for the x axis
     * @param y scale factor for the y axis
     * @param z scale factor for the z axis
     * @return a new transform
     */
    public Transform scale(final double x, final double y, final double z) {
        Mat4x4 tm = new Mat4x4(x, 0.0, 0.0, 0.0,
                               0.0, y, 0.0, 0.0,
                               0.0, 0.0, z, 0.0,
                               0.0, 0.0, 0.0, 1.0);
        Mat4x4 ti = new Mat4x4(1.0 / x, 0.0, 0.0, 0.0,
                               0.0, 1.0 / y, 0.0, 0.0,
                               0.0, 0.0, 1.0 / z, 0.0,
                               0.0, 0.0, 0.0, 1.0);
        return new Transform(m.mul(tm), ti.mul(i));
    }

    /**
     * appends a rotation around the X axis to the transform
     * @param angle of rotation
     * @return new transform
     */
    public Transform rotateX(final double angle) {
        Mat4x4 tm = new Mat4x4(1.0, 0.0, 0.0, 0.0,
                               0.0, Math.cos(angle), -Math.sin(angle), 0.0,
                               0.0, Math.sin(angle), Math.cos(angle), 0.0,
                               0.0, 0.0, 0.0, 1.0);
        Mat4x4 ti = new Mat4x4(1.0, 0.0, 0.0, 0.0,
                               0.0, Math.cos(angle), Math.sin(angle), 0.0,
                               0.0, -Math.sin(angle), Math.cos(angle), 0.0,
                               0.0, 0.0, 0.0, 1.0);
        return new Transform(m.mul(tm), ti.mul(i));
    }

    /**
     * appends a rotation around the Y axis to the transform
     * @param angle of rotation
     * @return new transform
     */
    public Transform rotateY(final double angle) {
        Mat4x4 tm = new Mat4x4(Math.cos(angle), 0.0, Math.sin(angle), 0.0,
                               0.0, 1.0, 0.0, 0.0,
                               -Math.sin(angle), 0.0, Math.cos(angle), 0.0,
                               0.0, 0.0, 0.0, 1.0);
        Mat4x4 ti = new Mat4x4(Math.cos(angle), 0.0, -Math.sin(angle), 0.0,
                               0.0, 1.0, 0.0, 0.0,
                               Math.sin(angle), 0.0, Math.cos(angle), 0.0,
                               0.0, 0.0, 0.0, 1.0);
        return new Transform(m.mul(tm), ti.mul(i));
    }

    /**
     * appends a rotation around the Z axis to the transform
     * @param angle of rotation
     * @return new transform
     */
    public Transform rotateZ(final double angle) {
        Mat4x4 tm = new Mat4x4(Math.cos(angle), -Math.sin(angle), 0.0, 0.0,
                               Math.sin(angle), Math.cos(angle), 0.0, 0.0,
                               0.0, 0.0, 1.0, 0.0,
                               0.0, 0.0, 0.0, 1.0);
        Mat4x4 ti = new Mat4x4(Math.cos(angle), Math.sin(angle), 0.0, 0.0,
                               -Math.sin(angle), Math.cos(angle), 0.0, 0.0,
                               0.0, 0.0, 1.0, 0.0,
                               0.0, 0.0, 0.0, 1.0);
        return new Transform(m.mul(tm), ti.mul(i));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.m);
        hash = 29 * hash + Objects.hashCode(this.i);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transform other = (Transform) obj;
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        if (!Objects.equals(this.i, other.i)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transform{" + "m=" + m + ", i=" + i + '}';
    }
    
}
