package main.java.sgu.ru.ThirdTask;

import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<FoodItem> queue;
    private final String[] foodNames = {"Яблоко", "Банан", "Апельсин", "Виноград"};
    private int producedCount = 0;
    static int sleepMillis = 100;
    private volatile boolean running = true;

    public Producer(Queue<FoodItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running) {
            FoodItem food = generateFood();
            synchronized (queue) {
                queue.add(food);
                producedCount++;
                System.out.println("\nПродавец положил в очередь: " + food.getName() + " (" + food.getCalories() + " ккал)");
                queue.notifyAll();
            }
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                System.err.println("Ошибка: Поток прерван.");
                running = false;
            }
        }
    }

    public void stop() {
        running = false;
    }

    public int getProducedCount() {
        return producedCount;
    }

    private FoodItem generateFood() {
        String name = foodNames[(int) (Math.random() * foodNames.length)];
        int calories = (int) (Math.random() * 100) + 50;
        return new FoodItem(name, calories);
    }
}