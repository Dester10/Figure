package Main.java.figures;

import Main.java.figures.auxiliary.Point;
import Main.java.figures.types.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String figure = "";
    public static void main(String[] args) {
        boolean check1 = true;
        boolean check2 = true;
        String[] fig = new String[]{"FIGURE", "CIRCLE", "SQUARE", "RECTANGLE", "PARALLELOGRAM", "TRIANGLE", "POLYGON", "SPHERE", "TRUNCATED_SPHERE", "CYLINDER", "CONE", "END"};
        while (check2) {
            for (int t = 0; t < fig.length; ++t) {
                if (figure.equals(fig[t])) {
                    check1 = false;
                }
            }

            if (check1) {
                System.out.println("Please, use only \"FIGURE\", \"CIRCLE\", \"SQUARE\", \"RECTANGLE\", \"PARALLELOGRAM\", \"TRIANGLE\", \"POLYGON\", \"SPHERE\", \"TRUNCATED_SPHERE\", \"CYLINDER\", \"CONE\", \"END\"");
                figure = scanner.nextLine();
            }

            if (!check1) {
                ArrayList<Object> points = pointes();
                Figure figurka = figureMaker(points);
                if (figurka.checkOfValid()) {
                    figurka.areaOfFigure();
                    figurka.perimetr();
                    check2 = false;
                } else {
                    figure = scanner.nextLine();
                    check1 = true;
                }
            }
        }
    }

    public static ArrayList<Object> pointes() {
        ArrayList<Object> coords = new ArrayList<Object>();
        boolean check = true;
        String getting = "";
        Pattern pXY = Pattern.compile("(0|(-?)[1-9]+[0-9]*) (0|(-?)[1-9]+[0-9]*)");
        Pattern pXYZ = Pattern.compile("(0|(-?)[1-9]+[0-9]*) (0|(-?)[1-9]+[0-9]*){2}");
        while (check) {
            getting = scanner.nextLine();
            Matcher mXY = pXY.matcher(getting);
            Matcher mXYZ = pXYZ.matcher(getting);
            if (mXY.matches()) {
                String[] splited = getting.split(" ");
                Point point = new Point(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), 0);
                coords.add(point);
            } else if (mXYZ.matches()) {
                String[] splited = getting.split(" ");
                Point point = new Point(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
                coords.add(point);
            } else if (getting.equals("STOP_INPUT")) {
                check = false;
            } else {
                System.out.println("Please, retype. \nIf you end, write \"STOP_INPUT\"");
            }
        }
        return coords;
    }

    public static Figure figureMaker(ArrayList<Object> points) {
        Figure figureMade = null;
        switch (figure) {
            case "FIGURE" -> figureMade = new Figure(points);
            case "CIRCLE" -> figureMade = new Circle(points);
            case "SQUARE" -> figureMade = new Square(points);
            case "RECTANGLE" -> figureMade = new Rectangle(points);
            case "PARALLELOGRAM" -> figureMade = new Parallelogram(points);
            case "TRIANGLE" -> figureMade = new Triangle(points);
            case "POLYGON" -> figureMade = new Polygon(points);
            case "SPHERE" -> figureMade = new Sphere(points);
            case "TRUNCATED_SPHERE" -> figureMade = new TruncatedSphere(points);
            case "CYLINDER" -> figureMade = new Cylinder(points);
            case "CONE" -> figureMade = new Cone(points);
            default -> {
                System.out.println("Please, retype the name of your figure. \nRemember, you can write \"FIGURE\", \"CIRCLE\", \"SQUARE\", \"RECTANGLE\", \"PARALLELOGRAM\", \"TRIANGLE\", \"POLYGON\", \"SPHERE\", \"TRUNCATED_SPHERE\", \"CYLINDER\", \"CONE\"");
                figure = scanner.next();
            }
        }
        return figureMade;
    }
}
