package by.goik.jwdcourse.task01branching;

public class PointA {
	int x1;
    int y1;

    PointA (int x, int y) {
        x1 = x;
        y1 = y;
    }
    public double getDistanceFromPoint1() {
        return Math.sqrt(x1 * x1 + y1 * y1);
    }
}
