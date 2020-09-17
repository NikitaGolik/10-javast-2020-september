package by.goik.jwdcourse.task01branching;

public class PointB {
	int x2;
    int y2;

    PointB (int x, int y) {
        x2 = x;
        y2 = y;
    }
    public double getDistanceFromPoint2() {
        return Math.sqrt(x2 * x2 + y2 * y2);
    }
}
