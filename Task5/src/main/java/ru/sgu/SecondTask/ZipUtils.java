package main.java.ru.sgu.SecondTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public void addDirectoryToZip(Path sourceDir, Path dir, ZipOutputStream zs) {
        try {
        Path relativePath = sourceDir.relativize(dir);
        zs.putNextEntry(new ZipEntry(relativePath.toString() + "/"));
        zs.closeEntry();
        Files.walk(dir).filter(path -> !Files.isDirectory(path)).forEach(path -> addFileToZip(sourceDir, path, zs));
        } catch (IOException e) {
            System.err.println("Ошибка при добавлении директории в архив.");
        }
    }

    public void addFileToZip(Path sourceDir, Path file, ZipOutputStream zs) {
        try {
            Path relativePath = sourceDir.relativize(file);
            zs.putNextEntry(new ZipEntry(relativePath.toString()));
            Files.copy(file, zs);
            zs.closeEntry();
        } catch (IOException e) {
            System.err.println("Ошибка при добавлении файла в архив.");
        }
    }
}