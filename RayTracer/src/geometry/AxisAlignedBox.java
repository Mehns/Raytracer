package geometry;

import color.Color;
import java.util.ArrayList;
import java.util.Objects;
import material.Material;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 * This class represents an axis-aligned-box (AAB).
 *
 * @author Lena
 */
public class AxisAlignedBox extends Geometry {

    /**
     * left bottom far corner
     */
    public final Point3 lbf;

    /**
     * right upper near corner
     */
    public final Point3 run;

    /**
     * list for all 6 side planes of AAB
     */
    public ArrayList<Plane> planeList = new ArrayList<>();

    /**
     * left front plane of AAB
     */
    Plane leftFront;

    /**
     * left back plane of AAB
     */
    Plane leftBack;

    /**
     * bottom plane of AAB
     */
    Plane bottom;

    /**
     * right front plane of AAB
     */
    Plane rightFront;

    /**
     * right back plane of AAB
     */
    Plane rightBack;

    /**
     * top plane of AAB
     */
    Plane top;

    /**
     * constrcts an axis-aligned-box (AAB) with color: 
     * initializes all 6 sides of AAB as planes with color
     * @param lbf left bottom far corner of AAB
     * @param run right upper near corner
     * @param color of AAB
     */
    public AxisAlignedBox(Point3 lbf, Point3 run, Color color) {
        super(color);
        this.lbf = lbf;
        this.run = run;

        leftFront = new Plane(run, new Normal3(0, 0, 1), color);
        rightBack = new Plane(lbf, new Normal3(0, 0, -1), color);

        rightFront = new Plane(run, new Normal3(1, 0, 0), color);
        leftBack = new Plane(lbf, new Normal3(-1, 0, 0), color);

        top = new Plane(run, new Normal3(0, 1, 0), color);
        bottom = new Plane(lbf, new Normal3(0, -1, 0), color);

        planeList.add(leftFront);
        planeList.add(rightBack);

        planeList.add(rightFront);
        planeList.add(leftBack);

        planeList.add(top);
        planeList.add(bottom);
    }

    /**
     * constrcts an axis-aligned-box (AAB) with material
     *
     * @param lbf left bottom far corner of AAB
     * @param run right upper near corner
     * @param material of AAB
     */
    public AxisAlignedBox(Point3 lbf, Point3 run, Material material) {
        super(material);
        this.lbf = lbf;
        this.run = run;

        leftFront = new Plane(run, new Normal3(0, 0, 1), material);
        rightBack = new Plane(lbf, new Normal3(0, 0, -1), material);

        rightFront = new Plane(run, new Normal3(1, 0, 0), material);
        leftBack = new Plane(lbf, new Normal3(-1, 0, 0), material);

        top = new Plane(run, new Normal3(0, 1, 0), material);
        bottom = new Plane(lbf, new Normal3(0, -1, 0), material);

        planeList.add(leftFront);
        planeList.add(rightBack);

        planeList.add(rightFront);
        planeList.add(leftBack);

        planeList.add(top);
        planeList.add(bottom);
    }

    @Override
    public Hit hit(Ray r) {

        ArrayList<Hit> hits = new ArrayList<>();

        // add all hits from visible planes to hits
        for (Plane plane : planeList) {
            if (r.o.sub(plane.a).dot(plane.n) > 0.0) {
                hits.add(plane.hit(r));
            }
        }

        // search for real hits in hits: if hit is on AAB
        ArrayList<Hit> realHits = new ArrayList<>();
        for (Hit h : hits) {
            if (h != null) {
                Point3 p = r.at(h.t);
                if (h.geo == leftFront || h.geo == rightBack) {
                    if ((lbf.x <= p.x && p.x <= run.x) && (lbf.y <= p.y && p.y <= run.y)) {
                        realHits.add(h);
                    }
                } else if (h.geo == leftBack || h.geo == rightFront) {
                    if ((lbf.y <= p.y && p.y <= run.y) && (lbf.z <= p.z && p.z <= run.z)) {
                        realHits.add(h);
                    }
                } else if (h.geo == top || h.geo == bottom) {
                    if ((lbf.x <= p.x && p.x <= run.x) && (lbf.z <= p.z && p.z <= run.z)) {
                        realHits.add(h);
                    }
                }
            }
        }

        // search smalles hit
        Hit finalHit = null;
        for (Hit hit : realHits) {
            if (finalHit == null || hit.t < finalHit.t) {
                finalHit = hit;
            }
        }

        return finalHit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.lbf);
        hash = 89 * hash + Objects.hashCode(this.run);
        hash = 89 * hash + Objects.hashCode(this.planeList);
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
        final AxisAlignedBox other = (AxisAlignedBox) obj;
        if (!Objects.equals(this.lbf, other.lbf)) {
            return false;
        }
        if (!Objects.equals(this.run, other.run)) {
            return false;
        }
        if (!Objects.equals(this.planeList, other.planeList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AxisAlignedBox{" + "lbf=" + lbf + ", run=" + run + ", planeList=" + planeList + ", leftFront=" + leftFront + ", leftBack=" + leftBack + ", bottom=" + bottom + ", rightFront=" + rightFront + ", rightBack=" + rightBack + ", top=" + top + '}';
    }
    
}
