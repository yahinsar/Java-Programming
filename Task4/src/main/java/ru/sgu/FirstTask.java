package main.java.ru.sgu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        FirstTask task = new FirstTask();
        task.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<LocalDate> dates = new ArrayList<>();

        System.out.println("Введите даты в формате (год месяц день) и 'end' в конце: ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            LocalDate date = readDate(input);
            if (date == null) {
                System.out.println("Некорректный формат даты. Попробуйте еще раз.");
            } else {
                dates.add(date);
            }
        }

        if (dates.isEmpty()) {
            System.out.println("Рановато завершили, надо было ввести даты сначала.");
            return;
        }

        LocalDate minDate = dates.get(0);
        LocalDate maxDate = dates.get(0);
        for (LocalDate date : dates) {
            if (date.isBefore(minDate)) {
                minDate = date;
            }
            if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }

        long daysBetween = Math.abs(maxDate.toEpochDay() - minDate.toEpochDay());
        System.out.println("Между минимальной и максимальной датой прошло: " + daysBetween + " дней.");
    }

    public LocalDate readDate(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            return null;
        }

        try {
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            return null;
        }
    }

}
