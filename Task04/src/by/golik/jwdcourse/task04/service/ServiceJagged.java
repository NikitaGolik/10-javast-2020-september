package by.golik.jwdcourse.task04.service;
import java.util.Scanner;

/**
 *
 */
public class ServiceJagged {
    private int row;
    private int col;
    private int[][] jaggedArray;

    public ServiceJagged(int[][] jaggedArray) {
        this.jaggedArray = jaggedArray;
    }

    /**
     *
     * @param matrix
     */
    public void matrixSquare(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of Rows Matrix: ");
        row = scanner.nextInt();
        System.out.println("Enter count of Columns Matrix: ");
        col = scanner.nextInt();
        if (row == col) {
            System.out.println("Матрица является квадратной");
        }
        else System.out.println("Матрица не является квадратной");
    }

    /**
     * @param matrix1
     * @param matrix2
     * @return
     */
    public int[][] additionJagged(int[][] matrix1, int[][] matrix2) {
        int n;
        int m;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите количество строк: ");
            n = in.nextInt();
            System.out.print("Введите количество столбцов: ");
            m = in.nextInt();
            matrix1 = new int[n][m];
            System.out.println("Введите элеменнты 1 массива, по порядку: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix1[i][j] = in.nextInt();
                }
            }
            matrix2 = new int[n][m];
            System.out.println("Введите элеменнты 2 массива, по порядку: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix2[i][j] = in.nextInt();
                }
            }
        }
        System.out.println("Матрица 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Матрица 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Сумма матриц: ");
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                finalMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(finalMatrix[i][j] + " ");

            }
            System.out.println();
        }
        return finalMatrix;

    }

    /**
     * @param matrix1
     * @param matrix2
     * @return
     */
    public int[][] subtractionJagged(int[][] matrix1, int[][] matrix2) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        System.out.print("Введите количество столбцов: ");
        int m = in.nextInt();
        matrix1 = new int[n][m];
        System.out.println("Введите элеменнты 1 массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = in.nextInt();
            }
        }
        matrix2 = new int[n][m];
        System.out.println("Введите элеменнты 2 массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = in.nextInt();
            }
        }
        System.out.println("Матрица 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Матрица 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Разница матриц: ");
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                finalMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(finalMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return finalMatrix;
    }

    /**
     * @param jaggedArray
     * @param constant
     * @return
     */
    public int[][] multiplyOnConstantJagged(int[][] jaggedArray, int constant) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        System.out.print("Введите количество столбцов: ");
        int m = in.nextInt();
        System.out.println("Введите значение константы ");
        constant = in.nextInt();
        jaggedArray = new int[n][m];
        System.out.println("Введите элеменнты массива, по порядку: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                jaggedArray[i][j] = in.nextInt();
            }
        }
        System.out.println("Начальная Матрица : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
            int[][] finalMatrix = new int[n][m];
            System.out.println("Полученная матрица: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    finalMatrix[i][j] = jaggedArray[i][j] * constant;
                    System.out.print(finalMatrix[i][j] + " ");
                }
                System.out.println();
            }
        return finalMatrix;
    }

        /**
         * method transposes matrix
         */

        public void transpose () {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите количество строк и столбцов: ");

            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = n * i + j;
                }
            }
            /**
             * view matrix
             */
            System.out.println("Начальная матрица");
            System.out.println("------");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", a[i][j]);
                }
                System.out.println();
            }

            /**
             * transpose matrix
             */
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }

            /**
             * view new matrix
             */
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

    /**
     *
     * @param jaggedArray
     * @return
     */
    public int[][] sortJaggedArray(int[][] jaggedArray) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите количество строк: ");
            int n = in.nextInt();
            System.out.print("Введите количество столбцов: ");
            int m = in.nextInt();
            jaggedArray = new int[m][n];

            System.out.println("Введите элеменнты массива, по порядку: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    this.jaggedArray[i][j] = in.nextInt();
                }
            }
            System.out.println("Начальная Матрица : ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(this.jaggedArray[i][j] + " ");
                }
                System.out.println();
            }
            for(int i = 0; i < jaggedArray[i].length; i ++) {
                for (int j = 0; j < jaggedArray[j].length; j++) {
                    int sumPrev = 0;
                    for(i = 0; i < jaggedArray[j].length; i++) {
                        sumPrev += jaggedArray[i][j];
                    }
                    int sumCurrent = 0;
                    for(i = 0; i < jaggedArray[j].length; i++) {
                        sumCurrent += jaggedArray[i][j];
                    }
                    if (sumPrev > sumCurrent) {
                        for (int k = 0; k < jaggedArray[j].length; k++) {
                            int temp = jaggedArray[k][j];
                            jaggedArray[k][j] = jaggedArray[k][j-1];
                            jaggedArray[k][j-1] = temp;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(jaggedArray[i][j] + " ");
                }
                System.out.println();
            }
            return jaggedArray;
        }
}
