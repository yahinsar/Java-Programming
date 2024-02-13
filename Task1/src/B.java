import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

public class B {
    public static void printResult(String result, String operation) {
        System.out.printf("%s result: %s \n", operation, result);
    }
    public static void applyTheOperation(BigDecimal num1, BigDecimal num2, String operation) {
        switch (operation) {
            case ("ADD"):
                printResult((num1.add(num2)).toString(), operation);
                break;
            case ("SUB"):
                printResult((num1.subtract(num2)).toString(), operation);
                break;
            case ("MULT"):
                printResult((num1.multiply(num2)).toString(), operation);
                break;
            case ("DIV"):
                printResult((num1.divide(num2, 10, RoundingMode.HALF_UP)).toString(), operation);
                break;
            case ("REM"):
                printResult((num1.remainder(num2)).toString(), operation);
                break;
            case ("POW"):
                printResult((num1.pow(num2.intValue())).toString(), operation);
                break;
        }
    }
    public static void applyTheOperation(BigInteger num1, BigInteger num2, String operation) {
        switch (operation) {
            case ("ADD"):
                printResult((num1.add(num2)).toString(), operation);
                break;
            case ("SUB"):
                printResult((num1.subtract(num2)).toString(), operation);
                break;
            case ("MULT"):
                printResult((num1.multiply(num2)).toString(), operation);
                break;
            case ("DIV"):
                printResult((num1.divide(num2)).toString(), operation);
                break;
            case ("REM"):
                printResult((num1.remainder(num2)).toString(), operation);
                break;
            case ("POW"):
                printResult((num1.pow(num2.intValue())).toString(), operation);
                break;
        }
    }
    public void calculation() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String num1 = in.next();
        String num2 = in.next();
        String operation = in.next();

        if (operation.equals("POW")) {
            try {
                if (num2.contains(".") || (new BigInteger(num2).compareTo(BigInteger.valueOf((Integer.MAX_VALUE))) > 0)) {
                    throw new Exception("Нельзя возвести в указанную степень");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }

        if (num1.contains(".") || num2.contains("."))
            applyTheOperation(new BigDecimal(num1), new BigDecimal(num2), operation);
        else
            applyTheOperation(new BigInteger(num1), new BigInteger(num2), operation);

        in.close();
    }
}
