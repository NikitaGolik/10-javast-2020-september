package by.golik.jwdcourse.task04.service;
import by.golik.jwdcourse.task04.beans.JaggedArray;

/**
 * Class for sorting raws in jagged arrays
 */
public class SortJaggedByRaws {

    /**
     * sort arrays by sum of element of every raw
     * @param jaggedArray array for sort
     * @return new sort jagged array
     * @throws Exception
     */
    public JaggedArray sortArrayIncreaseSumOFElementsInRaw(JaggedArray jaggedArray) throws Exception {
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

                    /** swaps rows in corresponding tempArray */
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

    /**
     *  method for swap raws
     * @param matrix matrix of int numbers
     * @param row1 row for copy
     * @param row2 for set
     */
    public void swapRows(int[][] matrix, int row1, int row2) {
        int[] tmp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tmp;
    }
    /**
     * Search max element in row
     * @param matrix matrix of int numbers
     * @param row number of row for search
     */
    public int maxInRow(int[][] matrix, int row) {

        int max = Integer.MIN_VALUE;
        for (int col = 0; col < matrix[row].length; col++)
            if (matrix[row][col] > max)
                max = matrix[row][col];
        return max;
    }

    /**
     * Search min element in row
     * @param matrix matrix of int numbers
     * @param row number of row for search
     */
    public int minInRow(int[][] matrix, int row) {

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < matrix[row].length; col++)
            if (matrix[row][col] < min)
                min = matrix[row][col];
        return min;
    }

    /**
     * Sort rows of matrix
     * @param jaggedArray int number matrix
     * @param byMax : true - sort by max element, false - sort by min element
     * @param ascending : true - by ascending, false - by decrease
     */
    public JaggedArray sortRows(JaggedArray jaggedArray, boolean byMax, boolean ascending) throws Exception {
        int v = jaggedArray.getVerticalSize();
        int h = jaggedArray.getHorizontalSize();

        int[][] matrix = new int[v][h];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < v; j++) {
                matrix[i][j] = jaggedArray.getElement(i,j);
            }
        }
        int[] extremum = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++)
            extremum[row] = byMax ? maxInRow(matrix, row) : minInRow(matrix, row);
        for (int i = 0; i < matrix.length; i++)
            for (int j = i + 1; j < matrix.length; j++)
                if ((ascending && extremum[i] > extremum[j]) || (!ascending && extremum[i] < extremum[j])) {
                    swapRows(matrix, i, j);
                    int tmp = extremum[i];
                    extremum[i] = extremum[j];
                    extremum[j] = tmp;
                }
        return new JaggedArray(matrix);
    }
}
