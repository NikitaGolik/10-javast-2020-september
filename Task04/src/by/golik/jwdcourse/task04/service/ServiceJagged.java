package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.JaggedArray;

/**
 *
 */
public class ServiceJagged {
    JaggedArraysCreator jaggedArraysCreator;


    /**
     * @param
     */
    public void matrixSquare(JaggedArray jaggedArray) {

        int row = jaggedArray.getVerticalSize();
        int col = jaggedArray.getHorizontalSize();
        if (row == col) {
            System.out.println("Матрица является квадратной");
        } else System.out.println("Матрица не является квадратной");
    }

    /**
     * @param
     * @param
     * @return
     */
    //todo
    public JaggedArray additionJagged(JaggedArray jaggedArray1, JaggedArray jaggedArray2) throws Exception {
        int v1 = jaggedArray1.getVerticalSize();
        int h1 = jaggedArray1.getHorizontalSize();
        int v2 = jaggedArray2.getVerticalSize();
        int h2 = jaggedArray2.getHorizontalSize();

        if (h1 != h2 || v1 != v2) {
            throw new Exception();
        }
        JaggedArray result = new JaggedArray(v1, h1);
        try {
            for (int i = 0; i < v1; i++) {
                for (int j = 0; j < h1; j++) {
                    int value = jaggedArray1.getElement(i,j) + jaggedArray2.getElement(i, j);
                        result.setElement(i, j, value);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * @param
     * @param
     * @return
     */
    //todo
    public JaggedArray subtractionJagged(JaggedArray jaggedArray1, JaggedArray jaggedArray2) throws Exception {
        int v1 = jaggedArray1.getVerticalSize();
        int h1 = jaggedArray1.getHorizontalSize();
        int v2 = jaggedArray2.getVerticalSize();
        int h2 = jaggedArray2.getHorizontalSize();

        if (h1 != h2 || v1 != v2) {
            throw new Exception();
        }
        JaggedArray result = new JaggedArray(v1, h2);
        try {
            for (int i = 0; i < v1; i++) {
                for (int j = 0; j < h1; j++) {
                    int value = jaggedArray1.getElement(i,j) - jaggedArray2.getElement(i, j);
                    result.setElement(i, j, value);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * @param
     * @param
     * @return
     */
    //todo
    public JaggedArray multiplyOnConstantJagged(JaggedArray jaggedArray, int constant) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        JaggedArray result = new JaggedArray(v, h);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = jaggedArray.getElement(i, j) * constant;
                    result.setElement(i, j, value);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * method transposes matrix
     */
//todo
    public JaggedArray transpose(JaggedArray jaggedArray) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        if (v == h) {
            jaggedArray = new JaggedArray(v, h);
            try {
                for (int i = 0; i < v; i++) {
                    for (int j = 0; j < v; j++) {
                        jaggedArray.setElement(i, j, v * i + j);
                    }
                }
            } catch (Exception e) {

                /**
                 * transpose matrix
                 */
                for (int i = 0; i < v; i++) {
                    for (int j = i + 1; j < v; j++) {
                        int temp = jaggedArray.getElement(i, j);
                        jaggedArray.setElement(i, j, jaggedArray.getElement(j, i));
                        jaggedArray.setElement(j, i, temp);
                    }
                }
            }

        } return jaggedArray;
    }
            /**
             *
             * @param jaggedArray
             * @return
             */
//            public int[][] sortJaggedArray ( int[][] jaggedArray){
//                Scanner in = new Scanner(System.in);
//                System.out.print("Введите количество строк: ");
//                int n = in.nextInt();
//                System.out.print("Введите количество столбцов: ");
//                int m = in.nextInt();
//                jaggedArray = new int[m][n];
//
//                System.out.println("Введите элеменнты массива, по порядку: ");
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < m; j++) {
//                        this.jaggedArray[i][j] = in.nextInt();
//                    }
//                }
//                System.out.println("Начальная Матрица : ");
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < m; j++) {
//                        System.out.print(this.jaggedArray[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                for (int i = 0; i < jaggedArray[i].length; i++) {
//                    for (int j = 0; j < jaggedArray[j].length; j++) {
//                        int sumPrev = 0;
//                        for (i = 0; i < jaggedArray[j].length; i++) {
//                            sumPrev += jaggedArray[i][j];
//                        }
//                        int sumCurrent = 0;
//                        for (i = 0; i < jaggedArray[j].length; i++) {
//                            sumCurrent += jaggedArray[i][j];
//                        }
//                        if (sumPrev > sumCurrent) {
//                            for (int k = 0; k < jaggedArray[j].length; k++) {
//                                int temp = jaggedArray[k][j];
//                                jaggedArray[k][j] = jaggedArray[k][j - 1];
//                                jaggedArray[k][j - 1] = temp;
//                            }
//                        }
//                    }
//                }
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < m; j++) {
//                        System.out.print(jaggedArray[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                return jaggedArray;
//            }

}

