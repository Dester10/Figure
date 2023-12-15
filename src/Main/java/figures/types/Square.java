package Main.java.figures.types;

import Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import Main.java.figures.consts.Consts;
import java.util.ArrayList;

public class Square extends Polygon {
    private static ArrayList<Object> coords;
    private static double side;

    public Square(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 4) {
            double lengthMin = 0;
            double lengthMax = 0;

            for (int t = 0; t < coords.size() - 1; ++t) {
                Point p1 = (Point)coords.get(t);
                Point p2 = (Point)coords.get(t + 1);

                double rad = Maths.strangerLength(p1, p2);
                if (lengthMin == 0) {
                    lengthMin = rad;
                } else if (lengthMax == 0) {
                    lengthMax = rad;
                } else if (rad != lengthMin && rad != lengthMax) {
                    System.out.println("System is invalid");
                    return false;
                }
            }

            side = Math.min(lengthMin, lengthMax);
            return super.checkOfValid();
        }

        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double perimetr() {
        double per = side * Consts.FOUR;
        System.out.printf("The figure perimetr is %.2f\n", per);
        return per;
    }

    @Override
    public double areaOfFigure() {
        double ar = Math.pow(side, 2);
        System.out.printf("The figure area is %.2f\n", ar);
        return ar;
    }
}
