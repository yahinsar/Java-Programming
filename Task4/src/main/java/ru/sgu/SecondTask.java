package main.java.ru.sgu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SecondTask {

    enum DayOfWeek {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday;
        public DayOfWeek nextDay(int days) {
            int nextOrdinal = (this.ordinal() + days) % 7;
            if (nextOrdinal < 0) nextOrdinal += 7;
            return DayOfWeek.values()[nextOrdinal];
        }
    }

    public static void main(String[] args) {
        SecondTask task = new SecondTask();
        task.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите имя дня недели и количество дней: ");
            String dayName = scanner.next().toLowerCase();
            int daysToAdd = scanner.nextInt();
            DayOfWeek currentDay = DayOfWeek.valueOf(dayName);
            DayOfWeek nextDay = currentDay.nextDay(daysToAdd);
            System.out.println("Сегодня " + currentDay + ". Через " + daysToAdd + " дней будет " + nextDay);
        } catch (IllegalArgumentException e) {
            System.out.println("Введено некорректное имя дня недели.");
        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное количество дней.");
        }
    }

}
