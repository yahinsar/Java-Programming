package main.java.sgu.ru.ThirdTask;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<FoodItem> queue;
    private final String name;
    private int totalCalories = 0;
    private int operationsCount = 0;
    private volatile boolean running = true;

    public Consumer(Queue<FoodItem> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (running) {
            FoodItem food = null;
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    food = queue.poll();
                    totalCalories += food.getCalories();
                    operationsCount++;
                }
            }
            if (food != null) {
                System.out.println("Покупатель " + name + " съел: " + food.getName() + " (" + food.getCalories() + " ккал). " +
                        "Суммарно употреблено ккал: " + totalCalories);
            }
        }
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getOperationsCount() {
        return operationsCount;
    }

    public String getName() {
        return name;
    }

    public void stop() {
        running = false;
    }
}