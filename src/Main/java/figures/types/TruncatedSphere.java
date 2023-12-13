package Main.java.figures.types;

import Main.java.figures.auxiliary.Maths;
import Main.java.figures.auxiliary.Point;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class TruncatedSphere extends Figure {
    private static ArrayList<Object> coords;
    public static double lengthOf;

    public TruncatedSphere(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            Point center = (Point)coords.get(0);
            Point rad = (Point)coords.get(1);
            Point slice = (Point)coords.get(2);

            lengthOf = Maths.strangerLength(center, rad);
            if (lengthOf == Maths.strangerLength(center, slice)) {
                System.out.println("The figure is valid");
                return true;
            }
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public double areaOfFigure() {
        Point center = (Point)coords.get(0);
        Point slice = (Point)coords.get(2);
        Point underCenter = new Point(center.getCoordinateX(), slice.getCoordinateY(), center.getCoordinateZ());

        double high = Maths.strangerLength(underCenter, center) + lengthOf;
        double ar = 2 * PI * lengthOf * high;

        System.out.printf("The figure area is %.2f\n", ar);
        return ar;
    }
}
