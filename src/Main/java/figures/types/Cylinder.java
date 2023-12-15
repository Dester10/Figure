package Main.java.figures.types;

import Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import java.util.ArrayList;
import static java.lang.Math.PI;

public class Cylinder extends Figure {
    private static ArrayList<Object> coords;
    public Cylinder(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {

            Point rectangular = Maths.rectangular((Point)coords.get(0), (Point)coords.get(1), (Point)coords.get(2));
            if (rectangular != null && rectangular != (Point)coords.get(2)) {
                System.out.println("The figure is valid");
                return true;
            }
        }

        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double areaOfFigure() {
        double ar = 0;

        double rad1 = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(2));
        double rad2 = Maths.strangerLength((Point)coords.get(1), (Point)coords.get(2));

        if (rad1 < rad2) {
            ar = 2 * PI * rad1 * (Maths.strangerLength((Point) coords.get(0), (Point) coords.get(1)) + rad1);
        } else {
            ar = 2 * PI * rad2 * (Maths.strangerLength((Point)coords.get(0), (Point)coords.get(1)) + rad2);
        }
        System.out.printf("The figure area is %.2f\n", ar);

        return ar;
    }
}
