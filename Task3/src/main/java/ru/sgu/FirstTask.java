package main.java.ru.sgu;

import java.util.Scanner;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstTask {
    public static void main(String[] args) {
        new FirstTask().run();
    }
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите целочисленные значения:");
            String input = scanner.nextLine();
            Stream<Integer> stream = parseInputToStream(input);

            Predicate<Integer> condition = num -> num > 10;
            List<Integer> filteredList = filterStream(stream, condition);
            System.out.println("Отфильтрованные значения: " + filteredList);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка. Введите целочисленные значения.");
        }
    }

    private Stream<Integer> parseInputToStream(String input) {
        return Stream.of(input.split(" ")).map(Integer::parseInt);
    }

    private List<Integer> filterStream(Stream<Integer> stream, Predicate<Integer> condition) {
        return stream.filter(condition).collect(Collectors.toList());
    }
}