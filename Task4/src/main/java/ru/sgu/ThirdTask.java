package main.java.ru.sgu;

import java.util.Random;

public class ThirdTask {
    public static void main(String[] args) {
        ThirdTask task = new ThirdTask();
        int repeatsCount = 100000;
        int symbolsCount = 10;

        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        String stringResult = "";

        task.measureStringBuilder(stringBuilder, repeatsCount, symbolsCount);
        task.measureStringBuffer(stringBuffer, repeatsCount, symbolsCount);
        task.measureString(stringResult, repeatsCount, symbolsCount);
    }

    public void measureStringBuilder(StringBuilder stringBuilder, int repeatsCount, int symbolsCount) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < repeatsCount; i++) {
            String randomString = generateRandomString(symbolsCount, random);
            stringBuilder.append(randomString);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Использование StringBuilder: " + (endTime - startTime) + " миллисекунд.");
    }

    public void measureStringBuffer(StringBuffer stringBuffer, int repeatsCount, int symbolsCount)  {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < repeatsCount; i++) {
            String randomString = generateRandomString(symbolsCount, random);
            stringBuffer.append(randomString);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Использование StringBuffer: " + (endTime - startTime) + " миллисекунд.");
    }

    public void measureString(String stringResult, int repeatsCount, int symbolsCount)  {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < repeatsCount; i++) {
            String randomString = generateRandomString(symbolsCount, random);
            stringResult += randomString;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Использование String: " + (endTime - startTime) + " миллисекунд.");
    }

    public String generateRandomString(int symbolsCount, Random random) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < symbolsCount; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }
}
