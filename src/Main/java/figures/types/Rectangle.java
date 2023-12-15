package Main.java.figures.types;

import Main.java.figures.auxiliary.Point;
import Main.java.figures.auxiliary.Maths;
import java.util.ArrayList;

public class Rectangle extends Figure {
    private static ArrayList<Object> coords;
    private static ArrayList<Object> theRightCoords = new ArrayList<>();
    private static Polygon pole;
    public Rectangle(ArrayList<Object> coords) {
        super(coords);
        this.coords = coords;
    }

    @Override
    public boolean checkOfValid() {
        if (coords != null && coords.size() == 4) {
            int indexMainPoint = 0;

            Point pMain = (Point)coords.get(0);
            Point pSec = (Point)coords.get(1);
            Point pThird = (Point)coords.get(2);

            Point rectangular = Maths.rectangular(pMain, pSec, pThird);
            if (rectangular != null) {
                theRightCoords.add(rectangular);
                for (int t = 0; t < coords.size(); ++t) {
                    if ((Point)coords.get(t) == rectangular) {
                        indexMainPoint = t;
                    }
                }

                ArrayList<Object> coords2 = new ArrayList<>();

                for (int t = 0; t < coords.size(); ++t) {
                    if (t != indexMainPoint) {
                        coords2.add((Point)coords.get(t));
                    }
                }

                rectangular = Maths.rectangular((Point)coords2.get(0), (Point)coords2.get(1), (Point)coords2.get(2));
                if (rectangular != null) {
                    theRightCoords.add(rectangular);
                    for (int t = 0; t < coords2.size(); ++t) {
                        if ((Point)coords.get(t) == rectangular) {
                            indexMainPoint = t;
                        }
                    }

                    for (int t = 0; t < coords2.size(); ++t) {
                        if (t != indexMainPoint) {
                            theRightCoords.add((Point)coords2.get(t));
                        }
                    }

                    pole = new Polygon(theRightCoords);
                    return pole.checkOfValid();
                }
            }
        }

        System.out.println("The figure is invalid");
        return false;
    }

    @Override
    public double areaOfFigure() {
        double a = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(2));
        double b = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(3));

        double ar = a * b;
        System.out.printf("The figure area is %.2f\n", ar);
        return ar;
    }

    @Override
    public double perimetr() {
        double a = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(2));
        double b = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(3));
        double c = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(2));
        double d = Maths.strangerLength((Point)coords.get(0), (Point)coords.get(3));

        double per = a + b + c + d;
        System.out.printf("The figure perimetr is %.2f\n", per);
        return per;
    }
}
