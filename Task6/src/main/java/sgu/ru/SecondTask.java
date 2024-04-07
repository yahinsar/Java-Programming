package main.java.sgu.ru;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class SecondTask extends RecursiveTask<Long> {
    private final long n;

    public SecondTask(long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return n;
        }

        SecondTask fibMinus1 = new SecondTask(n - 1);
        SecondTask fibMinus2 = new SecondTask(n - 2);

        fibMinus1.fork();
        long fibMinus2Result = fibMinus2.compute();
        long fibMinus1Result = fibMinus1.join();

        return fibMinus1Result + fibMinus2Result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = 0;

        try {
            System.out.print("Введите число N (N >= 0): ");
            n = scanner.nextLong();
            if (n < 0) {
                throw new IllegalArgumentException("Ошибка: Введенное число меньше 0.");
            }
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            long result = forkJoinPool.invoke(new SecondTask(n));
            System.out.println(n + "-ое число Фибоначчи: " + result);
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: Введенная строка - не число.");
        }
    }
}