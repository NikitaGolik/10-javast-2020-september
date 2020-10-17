package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.Array;
import by.golik.jwdcourse.task04.beans.JaggedArray;

import java.util.ArrayList;

/**
 *
 */
public class ServiceJagged {

    /**
     *
     * @param jaggedArray
     */
    public void matrixSquare(JaggedArray jaggedArray) {

        int row = jaggedArray.getVerticalSize();
        int col = jaggedArray.getHorizontalSize();
        if (row == col) {
            System.out.println("Матрица является квадратной");
        } else System.out.println("Матрица не является квадратной");
    }

    /**
     *
     * @param jaggedArray1
     * @param jaggedArray2
     * @return
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
     *
     * @param jaggedArray1
     * @param jaggedArray2
     * @return
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
     *
     * @param jaggedArray
     * @param constant
     * @return
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
                    ;
                    result[j][i] = value;
                }
            }
        } catch (Exception e) {

        }
        return new JaggedArray(result);
    }

    /**
     *
     * @param jaggedArray
     * @return
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

    /**
     *
     * @param jaggedArray
     * @return
     * @throws Exception
     */
    public JaggedArray SortArrayIncreaseSumOFElementsInRaw(JaggedArray jaggedArray) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        int[][] sumResult = new int[v][h];

            for (int i = 0; i < sumResult.length; i++) {
                for(int j = 0; j < v; j++) {
                    sumResult[i][j] = jaggedArray.getElement(i,j);
                }
            }


        for(int i = 0; i < sumResult.length; i++) {                                 //Перебираем массив
            for (int j = 0; j < sumResult[i].length; j++) {                         //Перебираем массив
                for (int k = 0; k < sumResult[i].length; k++) {                     //Перебираем строку
                    for (int z = sumResult[i].length - 1; z > k; z--) {             //Перебираем строку
                        if (sumResult[i][k] < sumResult[i][z]) {                    //Создаем условие
                            int a = sumResult[i][k];                                //Сортируем по убыванию
                             sumResult[i][k] = sumResult[i][z];                     //Сортируем по убыванию
                            sumResult[i][z] = a;                                    //Сортируем по убыванию
                        }
                    }
                }
            }
        }

        for(int i1 = 0; i1 < sumResult.length; i1++){
            for(int j = 0;j < sumResult[i1].length; j++){
                System.out.print(sumResult[i1][j] + "  ");
            }
            System.out.println();
        }
        int [][] tempArray = new int [sumResult.length][sumResult[0].length];

        /** Copies sumResult into tempArray */
        for (int i = 0; i < sumResult.length; i++) {
            for (int j = 0; j < sumResult[i].length; j++) {
                tempArray[i][j] = sumResult[i][j];
            }
        }

        /** Creates rowSum array to store sum of each row */
        int [] rowSums = new int [tempArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[0].length; j++) {
                rowSums[i] += tempArray[i][j];
            }
        }

        /** Modified Bubble Sort of rowSum array (highest to lowest values) */
        int temp;
        int i = 0;
        for(int j = rowSums.length; j > 0; j--){
            boolean isSwap = false;
            for (i = 1; i < j; i++) {
                if(rowSums[i-1] < rowSums[i]) {
                    temp = rowSums[i-1];
                    rowSums[i-1] = rowSums[i];
                    rowSums[i] = temp;
                    isSwap = true;

                    /** swaps rows in corresponding tempArray2 */
                    int [] temp2 = tempArray[i-1];
                    tempArray[i-1] = tempArray[i];
                    tempArray[i] = temp2;
                }
            }

            if(!isSwap){
                break;
            }
        }
        /** Prints sorted array  **/
        System.out.println("Sorted array: ");
        for (i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                System.out.print("$"+ tempArray[i][j] + " ");
            }
            System.out.println();
        }

        return new JaggedArray(sumResult);
    }
    public JaggedArray SortArrayIncreaseMaxElementsInRaw() {
        

    }
}

