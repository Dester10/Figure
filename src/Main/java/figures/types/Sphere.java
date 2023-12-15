package Main.java.figures.types;

import Main.java.figures.auxiliary.Maths;
import Main.java.figures.consts.Consts;
import java.util.ArrayList;
import static java.lang.Math.PI;

public class Sphere extends Figure {
    private static ArrayList<Object> coords;
    private static double lengthOf;

    public Sphere(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 2) {
            System.out.println("The figure is valid");
            lengthOf = Maths.strangerLength(coords);
            return true;
        }

        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double areaOfFigure() {
        double ar = Consts.FOUR * PI * Math.pow(lengthOf, 2);
        System.out.printf("The figure area is %.2f\n", ar);
        return ar;
    }
}
