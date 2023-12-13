package Main.java.figures.types;

import java.util.ArrayList;
import Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import Main.java.figures.consts.Consts;
import java.util.Stack;

public class Polygon extends Figure {
    private static ArrayList<Object> coords;
    private static Stack<Object> coordsIdStack = new Stack<>();
    private static Stack<Object> coordsIdStack2 = new Stack<>();
    private static int indexOfLefterX = 0;
    private static Point mainPoint;

    public Polygon(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() > 2) {
            whichIsLefterAndHigher();

            mainPoint = (Point) coords.get(indexOfLefterX);
            Point theSecond = (Point) coords.get(0);
            Point theThird = (Point) coords.get(1);

            Point mainVector = new Point(theSecond.getCoordinateX() - mainPoint.getCoordinateX(), theSecond.getCoordinateY() - mainPoint.getCoordinateY(), theSecond.getCoordinateZ() - mainPoint.getCoordinateZ());
            Point secondMainVector = new Point(theThird.getCoordinateX() - mainPoint.getCoordinateX(), theThird.getCoordinateY() - mainPoint.getCoordinateY(), theThird.getCoordinateZ() - mainPoint.getCoordinateZ());
            for (int t = 2; t < coords.size(); ++t) {
                if (t != indexOfLefterX) {
                    Point otherPoint = (Point) coords.get(t);
                    Point otherVector = Maths.vectorMarker(otherPoint, mainPoint);

                    int rez1 = mainVector.getCoordinateX() * secondMainVector.getCoordinateY() * otherVector.getCoordinateZ() + mainVector.getCoordinateY() * secondMainVector.getCoordinateZ() * otherVector.getCoordinateX() + mainVector.getCoordinateZ() * secondMainVector.getCoordinateX() * otherVector.getCoordinateY();
                    int rez2 = mainVector.getCoordinateZ() * secondMainVector.getCoordinateY() * otherVector.getCoordinateX() + mainVector.getCoordinateY() * secondMainVector.getCoordinateX() * otherVector.getCoordinateZ() + mainVector.getCoordinateX() * secondMainVector.getCoordinateZ() * otherVector.getCoordinateY();

                    if (rez1 + rez2 != 0) {
                        System.out.println("The figure is invalid");
                        return false;
                    }
                }
            }
            System.out.println("The figure is valid");
            return true;
        }
        System.out.println("The figure is invalid");
        return false;
    }

    public void whichIsLefterAndHigher() {
        int indexOfHigherY = 0;
        int lefterX = Consts.DEVIL_MAX;
        int higherY;

        for (int t = 0; t < coords.size(); ++t) {
            Point point = (Point) coords.get(t);
            if (point.getCoordinateX() < lefterX) {
                lefterX = point.getCoordinateX();
                indexOfLefterX = t;
            }
        }

        ArrayList<Object> coordsForHigher = new ArrayList<>(coords);
        while (coordsIdStack.size() != coords.size() - 1) {
            int xOfHigherY = Consts.DEVIL_MAX;
            higherY = -Consts.DEVIL_MAX;
            for (int t = 0; t < coordsForHigher.size() - 1; ++t) {
                Point point = (Point) coordsForHigher.get(t);
                if (point.getCoordinateY() > higherY && t != indexOfLefterX) {
                    higherY = point.getCoordinateY();
                    indexOfHigherY = t;
                    xOfHigherY = point.getCoordinateX();
                }
            }
            for (int m = 0; m < coordsForHigher.size(); ++m) {
                Point point2 = (Point) coordsForHigher.get(m);
                if (point2.getCoordinateY() == higherY && xOfHigherY < point2.getCoordinateX()) {
                    higherY = point2.getCoordinateY();
                    indexOfHigherY = m;
                    xOfHigherY = point2.getCoordinateX();
                }
            }

            coordsIdStack.push(coordsForHigher.get(indexOfHigherY));
            coordsIdStack2.push(coordsForHigher.get(indexOfHigherY));
            coordsForHigher.remove(indexOfHigherY);
        }
    }

    @Override
    public double perimetr() {
        Point special1 = (Point) coordsIdStack.peek();
        double per = Maths.strangerLength(special1, mainPoint);
        Point special2 = new Point(0, 0, 0);

        for (int t = 0; t < coordsIdStack.size(); ++t) {
            special1 = (Point) coordsIdStack.pop();
            special2 = (Point) coordsIdStack.peek();
            per += Maths.strangerLength(special1, special2);
        }

        per += Maths.strangerLength(mainPoint, special2);
        System.out.printf("The figure perimetr is %.2f\n", per);
        return per;
    }

    @Override
    public double areaOfFigure() {
        double ar = 0;
        Point special;

        for (int t = 0; t < coords.size() - 2; ++t) {
            special = (Point)coordsIdStack2.pop();
            Point vector1 = Maths.vectorMarker(special, mainPoint);
            special = (Point)coordsIdStack2.peek();
            Point vector2 = Maths.vectorMarker(special, mainPoint);

            ar += Maths.vectorMulty(vector1, vector2) / 2.00;
        }
        System.out.printf("The figure area is %.2f\n", ar);
        return ar;
    }

}

