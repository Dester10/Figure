package Main.java.figures.types;

import java.util.ArrayList;
import java.util.Objects;

public class Figure {
    public Figure(ArrayList<Object> coords) {
    }
    public boolean checkOfValid() {
        System.out.println("The figure is figure");
        return true;
    }

    public double areaOfFigure() {
        System.out.println("The figure has no area");
        return 0;
    }

    public double perimetr() {
        System.out.println("The figure has no perimetr");
        return 0;
    }
}


