package main.java.ru.sgu.FirstTask;

import java.util.*;

public class FirstTask {
    public static void main(String[] args) {
        FirstTask task = new FirstTask();
        List<Stock> stocks = task.readStocks();
        task.sortAndPrintStocks(stocks);
    }

    public List<Stock> readStocks() {
        Scanner scanner = new Scanner(System.in);
        List<Stock> stocks = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty())
                break;
            String[] input = line.split(" ");
            String lastName = input[0];
            String firstName = input[1];
            String middleName = "";
            String companyName = input[input.length - 2];
            int rating = Integer.parseInt(input[input.length - 1]);
            if (input.length == 5) {
                middleName = input[2];
            }
            stocks.add(new Stock(lastName, firstName, middleName, companyName, rating));
        }
        return stocks;
    }

    public void sortAndPrintStocks(List<Stock> stocks) {
        Collections.sort(stocks);
        Set<String> resultStrs = new HashSet<>();
        for (Stock stock : stocks) {
            String key = stock.lastName + stock.firstName + stock.middleName + stock.companyName;
            if (!resultStrs.contains(key)) {
                resultStrs.add(key);
                System.out.println(stock.lastName + " " + stock.firstName + " " + stock.middleName + " " + stock.companyName + " " + stock.rating);
            }
        }
    }
}