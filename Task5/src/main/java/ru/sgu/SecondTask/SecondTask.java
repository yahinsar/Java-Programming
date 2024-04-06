package main.java.ru.sgu.SecondTask;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.zip.*;

public class SecondTask {
    private final String archiveErrorMessage = "Ошибка при создании архива.";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите относительный путь к директории:");
        String relativeDirectory = scanner.nextLine();

        System.out.println("Введите целевую строку:");
        String targetString = scanner.nextLine();

        SecondTask app = new SecondTask();
        app.run(relativeDirectory, targetString);
        scanner.close();
    }

    public void run(String relativeDirectory, String targetString) {
        try {
            String currentWorkingDirectory = System.getProperty("user.dir");
            Path sourceDir = Paths.get(currentWorkingDirectory).resolve(relativeDirectory).normalize();
            String archiveFileName = sourceDir.getFileName() + ".zip";
            createArchive(sourceDir, targetString, archiveFileName);
            Path archiveFilePath = Paths.get(currentWorkingDirectory).resolve(archiveFileName).normalize();
            System.out.println("Архивирование завершено. \nПуть полученного zip архива: " + archiveFilePath);
        } catch (IOException e) {
            System.err.println(archiveErrorMessage);
        }
    }

    private void createArchive(Path sourceDir, String targetString, String archiveFileName) throws IOException {
        try (OutputStream os = new FileOutputStream(archiveFileName); ZipOutputStream zs = new ZipOutputStream(os)) {
            Files.walkFileTree(sourceDir, new CustomFileVisitor(sourceDir, targetString, zs, new ZipUtils()));
        } catch (IOException e) {
            System.err.println(archiveErrorMessage);
        }
    }
}
