package main.java.sgu.ru.ThirdTask;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThirdTask {
    static int operationsCount = 15;
    static int sleepMillis = 100;

    public void run() throws InterruptedException {

        Queue<FoodItem> queue = new LinkedList<>();
        Producer producer = new Producer(queue);

        List<Consumer> consumers = new LinkedList<>();
        consumers.add(new Consumer(queue, "Кирилл"));
        consumers.add(new Consumer(queue, "Андрей"));
        consumers.add(new Consumer(queue, "Шамиль"));
        consumers.add(new Consumer(queue, "Света"));

        Thread producerThread = new Thread(producer);
        List<Thread> consumerThreads = new LinkedList<>();
        for (Consumer consumer : consumers) {
            consumerThreads.add(new Thread(consumer));
        }

        producerThread.start();
        for (Thread consumerThread : consumerThreads) {
            consumerThread.start();
        }

        while (producer.getProducedCount() < operationsCount) {
            Thread.sleep(sleepMillis);
        }

        producer.stop();
        for (Consumer consumer : consumers) {
            consumer.stop();
        }

        producerThread.join();
        for (Thread consumerThread : consumerThreads) {
            consumerThread.join();
        }

        System.out.println("\nИтоги:");
        for (Consumer consumer : consumers) {
            System.out.println("Покупатель " + consumer.getName() + " съел " + consumer.getOperationsCount() + " товаров на " + consumer.getTotalCalories() + " ккал.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThirdTask task = new ThirdTask();
        task.run();
    }
}