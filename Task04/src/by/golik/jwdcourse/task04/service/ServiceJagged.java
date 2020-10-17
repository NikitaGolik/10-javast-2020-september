package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.JaggedArray;

/**
 * Class with actions with jagged arrays
 */
public class ServiceJagged {

    /**
     * check if jaggedArray is square
     * @param jaggedArray - array for check
     */
    public void matrixSquare(JaggedArray jaggedArray) {

        int row = jaggedArray.getVerticalSize();
        int col = jaggedArray.getHorizontalSize();
        if (row == col) {
            System.out.println("Матрица является квадратной");
        } else System.out.println("Матрица не является квадратной");
    }

    /**
     * addition two jagged arrays
     * @param jaggedArray1 first jagged array
     * @param jaggedArray2 second jagged array
     * @return new jagged array
     * @throws Exception
     */
    public JaggedArray additionJagged(JaggedArray jaggedArray1, JaggedArray jaggedArray2) throws Exception {
        int v1 = jaggedArray1.getVerticalSize();
        int h1 = jaggedArray1.getHorizontalSize();
        int v2 = jaggedArray2.getVerticalSize();
        int h2 = jaggedArray2.getHorizontalSize();

        if (h1 != h2 || v1 != v2) {
            throw new Exception();
        }
        int[][] result = new int[v1][h2];
        try {
            for (int i = 0; i < v1; i++) {
                for (int j = 0; j < h1; j++) {
                    int value = jaggedArray1.getElement(i, j) + jaggedArray2.getElement(i, j);
                    result[i][j] = value;
                }
            }
        } catch (Exception e) {

        }
        return new JaggedArray(result);
    }

    /**
     * subtraction two jagged arrays
     * @param jaggedArray1 first jagged array
     * @param jaggedArray2 second jagged array
     * @return new jagged array
     * @throws Exception
     */
    public JaggedArray subtractionJagged(JaggedArray jaggedArray1, JaggedArray jaggedArray2) throws Exception {
        int v1 = jaggedArray1.getVerticalSize();
        int h1 = jaggedArray1.getHorizontalSize();
        int v2 = jaggedArray2.getVerticalSize();
        int h2 = jaggedArray2.getHorizontalSize();

        if (h1 != h2 || v1 != v2) {
            throw new Exception();
        }
        int[][] result = new int[v1][h2];
        try {
            for (int i = 0; i < v1; i++) {
                for (int j = 0; j < h1; j++) {
                    int value = jaggedArray1.getElement(i, j) - jaggedArray2.getElement(i, j);
                    result[i][j] = value;
                }
            }
        } catch (Exception e) {

        }
        return new JaggedArray(result);
    }

    /**
     * method for multiply jagged array on constant
     * @param jaggedArray - array for multiply
     * @param constant - int number
     * @return new jagged array
     * @throws Exception
     */
    public JaggedArray multiplyOnConstantJagged(JaggedArray jaggedArray, int constant) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        int[][] result = new int[v][h];
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = jaggedArray.getElement(i, j) * constant;
                    result[j][i] = value;
                }
            }
        } catch (Exception e) {

        }
        return new JaggedArray(result);
    }

    /**
     * this method transposes getting array
     * @param jaggedArray getting array
     * @return new array
     * @throws Exception
     */
    public JaggedArray transpose(JaggedArray jaggedArray) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();


            int[][] result = new int[v][h];
            try {
                for (int i = 0; i < v; i++) {
                    for (int j = 0; j < v; j++) {
                        result[j][i] = jaggedArray.getElement(i, j);
                    }
                }
            } catch (Exception e) {

            }
         return new JaggedArray(result);
    }
}

