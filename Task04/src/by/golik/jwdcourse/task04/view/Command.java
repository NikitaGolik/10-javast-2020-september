package by.golik.jwdcourse.task04.view;
import java.io.FileNotFoundException;

/**
 * 
 */
public class Command {

    public void printMenu() throws FileNotFoundException {

        System.out.println("Выбери способ заполения массива:");
        System.out.println("1 - ввод с консоли");
        System.out.println("2 - заполнение из файла");
        System.out.println("3 - заполнение случайными числами");
        System.out.println("4 - для выхода");
    }

    public void printSortMenu() {
        System.out.println("Выбери действие с элементами массива:");
        System.out.println("1 - Сортировка - пузырек");
        System.out.println("2 - Сортировка - выбором");
        System.out.println("3 - Сортировка - вставкой");
        System.out.println("4 - Найти Минимальное значение в массиве целых чисел");
        System.out.println("5 - Найти Максимальное значение в массиве целых чисел");
        System.out.println("6 - Найти Заданное пользователем целое число");
        System.out.println("7 - Найти Заданное пользователем целое число используя бинарный поиск");
        System.out.println("8 - Получить все числа Фибоначчи в массиве");
        System.out.println("9 - Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр в массиве");
        System.out.println("10 - Получить все простые числа");
        System.out.println("11 - Перейти к операциям с Рваным массивом");
        System.out.println("12 - для выхода");
    }
    public void printMenuForJaggedArrays() {
        System.out.println("Выбери способ заполнения рваного массива:");
        System.out.println("1 - ввод с консоли:");
        System.out.println("2 - заполнение из файла:");
        System.out.println("3 - заполнение случайными числами:");
        System.out.println("4 - для выхода");
    }
    public void printMenuForActionsWithJaggedArrays() {
        System.out.println("1 - проверка является ли массив квадратной матрицей");
        System.out.println("2 - сложение двух рваных массивов");
        System.out.println("3 - вычитание массивов");
        System.out.println("4 - умножение на константу всех элементов массива");
        System.out.println("5 - транспонирование матрицы");
        System.out.println("6 - для выхода");
    }

}

