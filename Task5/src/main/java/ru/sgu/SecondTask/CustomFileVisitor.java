package main.java.ru.sgu.SecondTask;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.zip.*;

public class CustomFileVisitor extends SimpleFileVisitor<Path> {
    private final Path sourceDir;
    private final String targetString;
    private final ZipOutputStream zs;
    private final ZipUtils zipUtils;

    public CustomFileVisitor(Path sourceDir, String targetString, ZipOutputStream zs, ZipUtils zipUtils) {
        this.sourceDir = sourceDir;
        this.targetString = targetString;
        this.zs = zs;
        this.zipUtils = zipUtils;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().toLowerCase().contains(targetString.toLowerCase())) {
            zipUtils.addFileToZip(sourceDir, file, zs);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (dir.getFileName().toString().toLowerCase().contains(targetString.toLowerCase())) {
            zipUtils.addDirectoryToZip(sourceDir, dir, zs);
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }
}