package Main.java.figures.types;

import java.util.ArrayList;
import Main.java.figures.auxiliary.Maths;
import static java.lang.Math.PI;
public class Circle extends Figure {
    private static ArrayList<Object> coords;
    public static double lengthOf;

    public Circle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 2) {
            System.out.println("The figure is valid!");
            lengthOf = Maths.strangerLength(coords);
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double perimetr() {
        double per = lengthOf * PI * 2;
        System.out.printf("The figure perimetr is %.2f\n", per);

        return per;
    }

    @Override
    public double areaOfFigure() {
        double ar = PI * Math.pow(lengthOf, 2);
        System.out.printf("The figure area is %.2f\n", ar);

        return ar;
    }

}
