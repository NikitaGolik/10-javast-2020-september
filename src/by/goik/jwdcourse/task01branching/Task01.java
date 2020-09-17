package by.goik.jwdcourse.task01branching;

/*
 ���� ��� ����� �(�1, �1) � �(�2, �2). ��������� ��������, ������������, 
 ������� �� ����� ��������� ����� � ������ ���������. x y.
 */

public class Task01 {
	public static void main(String[] args) {
		
		// creating  point A
		PointA pointA = new PointA(9, 2); 
        double lengthA = pointA.getDistanceFromPoint1();
        
        //creating point B
        PointB pointB = new PointB(4, 9);
        double lengthB = pointB.getDistanceFromPoint2();

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
