package by.golik.jwdcourse.task04.service.jaggedarrays;

/**
 *
 */
public class Service {

    /**
     * Matrix multiplication method.
     * @param m Multiplicand
     * @param n Multiplier
     * @return Product
     */
    public int[][] multiplyByMatrix(int[][]m, int[][] n) {
        int m1ColLength = m[0].length; // m columns length
        int m2RowLength = n.length;    // n rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m.length;    // m result rows length
        int mRColLength = n[0].length; // m result columns length
        int[][] mResult = new int[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m
            for(int j = 0; j < mRColLength; j++) {     // columns from n
                for(int k = 0; k < m1ColLength; k++) { // columns from m
                    mResult[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return mResult;
    }
    public void transpose() {
        int n = 3;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n*i + j;
            }
        }
        // часть 2 - выводит на экран начальную матрицу
        System.out.println("Начальная матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        // часть 3 - транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // часть 4 - выводит на экран транспонированную матрицу
        System.out.println();
        System.out.println("Новая матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
    }
    
}
