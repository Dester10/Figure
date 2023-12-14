package Main.java.figures.auxiliary;

import java.util.ArrayList;
import java.lang.*;

public class Maths {
    public static double strangerLength(ArrayList<Object> coords) {
        Point point1 = (Point) coords.get(1);
        Point point2 = (Point) coords.get(0);
        double x = Math.pow(point1.getCoordinateX() - point2.getCoordinateX(), 2);
        double y = Math.pow(point1.getCoordinateY() - point2.getCoordinateY(), 2);
        double z = Math.pow(point1.getCoordinateZ() - point2.getCoordinateZ(), 2);

        return Math.sqrt(x + y + z);
    }

    public static double strangerLength(Point point1, Point point2) {
        double x = Math.pow(point1.getCoordinateX() - point2.getCoordinateX(), 2);
        double y = Math.pow(point1.getCoordinateY() - point2.getCoordinateY(), 2);
        double z = Math.pow(point1.getCoordinateZ() - point2.getCoordinateZ(), 2);

        return Math.sqrt(x + y + z);
    }

    public static double vectorMulty(Point vector1, Point vector2) {
        double i = Math.pow(vector1.getCoordinateY() * vector2.getCoordinateZ() - vector1.getCoordinateZ() * vector2.getCoordinateY(), 2);
        double j = Math.pow(vector1.getCoordinateX() * vector2.getCoordinateZ() - vector1.getCoordinateZ() * vector2.getCoordinateX(), 2);
        double k = Math.pow(vector1.getCoordinateX() * vector2.getCoordinateY() - vector1.getCoordinateY() * vector2.getCoordinateX(), 2);

        double result = Math.abs(Math.sqrt(i + j + k));
        return result;
    }

    public static Point vectorMarker(Point point1, Point point2) {
        Point vector = new Point(point1.getCoordinateX() - point2.getCoordinateX(), point1.getCoordinateY() - point2.getCoordinateY(), point1.getCoordinateZ() - point2.getCoordinateZ());

        return vector;
    }

    public static Point rectangular(Point pMain, Point pSec, Point pThird) {
        double mainSec = Math.pow(Maths.strangerLength(pMain, pSec), 2);
        double mainThird = Math.pow(Maths.strangerLength(pMain, pThird), 2);
        double secThird = Math.pow(Maths.strangerLength(pSec, pThird), 2);

        if (Math.sqrt(mainSec) == Math.sqrt(mainThird + secThird)) {
            return pThird;
        } else if (Math.sqrt(mainThird) == Math.sqrt(mainSec + secThird)) {
            return pSec;
        } else if (Math.sqrt(secThird) == Math.sqrt(mainSec + mainThird)) {
            return pMain;
        }
        return null;
    }

}
