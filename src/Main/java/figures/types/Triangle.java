package Main.java.figures.types;

import Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import java.util.ArrayList;

public class Triangle extends Figure {
    private static ArrayList<Object> coords;
    public Triangle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    public boolean checkOfValid() {
        if (coords != null && coords.size() == 3) {
            System.out.println("The figure is valid");
            return true;
        }

        System.out.println("The figure is invalid");
        return false;
    }

    public double perimetr() {
        Point vector1 = Maths.vectorMaker((Point)coords.get(1), (Point)coords.get(0));
        Point vector2 = Maths.vectorMaker((Point)coords.get(1), (Point)coords.get(2));

        double per = Maths.vectorMulty(vector1, vector2);
        System.out.printf("The figure perimetr is %.2f\n", per);
        return per;
    }

    public double areaOfFigure() {
        double ar = 0;
        for (int t = 0; t < coords.size() - 1; ++t) {
            ar += Maths.strangerLength((Point)coords.get(t), (Point)coords.get(t + 1));
        }
        System.out.printf("The figure area is %.2f\n", ar);

        return ar;
    }
}
