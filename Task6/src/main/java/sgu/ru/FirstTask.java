package main.java.sgu.ru;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTask {
    private int incrementValue;
    private int incrementCount = 100000;

    public FirstTask(int initialValue) {
        this.incrementValue = initialValue;
    }

    public synchronized void increment() {
        for (int i = 0; i < incrementCount; i++) {
            incrementValue++;
        }
    }

    public void runThreads() {
        Thread thread1 = new Thread(this::increment);
        Thread thread2 = new Thread(this::increment);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.print("Заинкрементированное значение переменной: " + incrementValue);
        } catch (InterruptedException e) {
            System.err.println("Ошибка при выполнении потоков.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите начальное значение переменной: ");
            int startValue = scanner.nextInt();
            FirstTask task = new FirstTask(startValue);
            task.runThreads();
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: Введенная строка - не число.");
        }
    }
}