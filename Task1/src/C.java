import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class C {
    public static void printInitials(String[] fio) {
        System.out.printf("%s %c. %c.\n", fio[1], fio[0].charAt(0), fio[2].charAt(0));
    }
    public void readFromFile(String inputFilename) {
        try {
            File file = new File(inputFilename);
            Scanner in = new Scanner(file);
            String[] fio = new String[3];
            for (int i = 0; i < fio.length; i++) {
                if (in.hasNext())
                    fio[i] = in.next();
                else
                    throw new Exception("В файле не хватает данных");
            }
            printInitials(fio);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Не удается открыть файл: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
