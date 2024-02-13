import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите пункт первого задания (A, B, C) или E для остановки программы: ");
            String userInput = scanner.next();
            switch (userInput.toUpperCase()) {
                case "A":
                    new A().printHelloWorld();
                    break;
                case "B":
                    new B().calculation();
                    break;
                case "C":
                    new C().readFromFile("input.txt");
                    break;
                case "E":
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}