package by.goik.jwdcourse.task01branching;

/*
 ���� ��� ����� �(�1, �1) � �(�2, �2). ��������� ��������, ������������, 
 ������� �� ����� ��������� ����� � ������ ���������. x y.
 */

public class Task01 {
	public static void main(String[] args) {
		
		// creating  point A
		Point pointA = new Point(9, -14); 
        double lengthA = pointA.getDistance();
        
        //creating point B
        Point pointB = new Point(4, 9);
        double lengthB = pointB.getDistance();

        System.out.println(lengthA);
        System.out.println(lengthB);

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
