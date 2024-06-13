package util;

public class util {
    public static double dist(double x1, double y1, double x2, double y2) {
        double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        return d;
    }
}
