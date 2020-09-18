package by.goik.jwdcourse.task01branching;

/*
 Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, определяющий,
 которая из точек находится ближе к началу координат x y.
 */

public class Task01 {
	public static void main(String[] args) {
		
		// creating  point A and Point B
		Point pointA = new Point(9, -14);
        Point pointB = new Point(4, 9);
        
        // calculating distances
        double lengthB = pointB.getDistance();
        double lengthA = pointA.getDistance();

        System.out.println("Distance from Point A: " + lengthA);
        System.out.println("Distance from Point B: " + lengthB);

        if (lengthA < lengthB) {
            System.out.println("Point A closer to the origin.");
        }
        else if (lengthA == lengthB) {
            System.out.println("Distances to the origin are equal.");
        }
        else {
            System.out.println("Point B closer to the origin.");
        }
	}
}
