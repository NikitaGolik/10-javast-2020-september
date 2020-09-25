package by.goik.jwdcourse.task01branching;

public class Point {
	int x;
    int y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }
}
