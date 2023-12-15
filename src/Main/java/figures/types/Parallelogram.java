package Main.java.figures.types;

import  Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import Main.java.figures.consts.Consts;
import java.util.ArrayList;
import java.util.Stack;

public class Parallelogram extends Polygon {
    private static ArrayList<Object> coords;
    private static final Stack<Object> coordsIdStack = new Stack<>();
    private static int indexOfLefterX = 0;

    public Parallelogram(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 4) {
            whichIsLefterAndHigher();

            Point theMain = (Point)coords.get(indexOfLefterX);
            Point theSecond = (Point)coordsIdStack.pop();
            Point theThird = (Point)coordsIdStack.pop();
            Point theFourth = (Point)coordsIdStack.pop();

            double length2 = Maths.strangerLength(theMain, theSecond);
            double length4 = Maths.strangerLength(theMain, theThird);
            double length3 = Maths.strangerLength(theMain, theFourth);

            double length23 = Maths.strangerLength(theSecond, theThird);
            double length43 = Maths.strangerLength(theFourth, theThird);
            double length24 = Maths.strangerLength(theSecond, theFourth);

            if (length24 >= length3 || length23 != length4 || length2 != length43 || length3 < length2 || length3 < length23 || length3 < length43 || length3 < length4) {
                System.out.println("The figure is invalid");
                return false;
            }
        }

        return super.checkOfValid();
    }

    @Override
    public void whichIsLefterAndHigher() {
        int indexOfHigherY = 0;
        int lefterX = Consts.DEVIL_MAX;
        int higherY;

        for (int t = 0; t < coords.size(); ++t) {
            Point point = (Point)coords.get(t);
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
                Point point = (Point)coordsForHigher.get(t);
                if (point.getCoordinateY() > higherY && t != indexOfLefterX) {
                    higherY = point.getCoordinateY();
                    indexOfHigherY = t;
                    xOfHigherY = point.getCoordinateX();
                }
            }

            for (int m = 0; m < coordsForHigher.size(); ++m) {
                Point point2 = (Point)coordsForHigher.get(m);
                if (point2.getCoordinateY() == higherY && xOfHigherY < point2.getCoordinateX()) {
                    higherY = point2.getCoordinateY();
                    indexOfHigherY = m;
                    xOfHigherY = point2.getCoordinateX();
                }
            }

            coordsIdStack.push(coordsForHigher.get(indexOfHigherY));
            coordsForHigher.remove(indexOfHigherY);
        }
    }
}
