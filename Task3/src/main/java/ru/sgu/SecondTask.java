package main.java.ru.sgu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class SecondTask {
    public static void main(String[] args) {
        new SecondTask().run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите целочисленные значения:");
            String input = scanner.nextLine();
            int[] array = parseInputToArray(input);

            int secondLargest = findSecondLargest(array);
            int thirdSmallest = findThirdSmallest(array);
            System.out.println("Второе наибольшее число: " + secondLargest);
            System.out.println("Третье наименьшее число: " + thirdSmallest);

        } catch (NumberFormatException e) {
            System.err.println("Ошибка. Введите целочисленные значения.");
        }
    }
    private int[] parseInputToArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать минимум 2 элемента");
        }
        return Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    }

    public int findThirdSmallest(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("Массив должен содержать минимум 3 элемента");
        }
        return Arrays.stream(array).boxed().sorted().skip(2).findFirst().get();
    }
}

