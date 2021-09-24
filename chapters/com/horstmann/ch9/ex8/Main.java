package com.horstmann.ch9.ex8;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * Напишите служебный метод для создания архивного ZIP-файла, содержащего все файлы из выбранного каталога и его подкаталогов.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        zipFolder(Paths.get("chapters/com/horstmann/ch9/ex8/root"));
    }

    public static void zipFolder(Path source) throws IOException {

        // get current working directory
        String currentPath = System.getProperty("user.dir") + File.separator;

        // get folder name as zip file name
        // can be other extension, .foo .bar .whatever
        String zipFileName = source.getFileName().toString() + ".zip";
        Files.deleteIfExists(Paths.get(currentPath + zipFileName));
        Path zipFile = Files.createFile(Paths.get(currentPath + zipFileName));
        URI uri = zipFile.toUri();

        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attributes) {

                // Copying of symbolic links not supported
                if (attributes.isSymbolicLink()) {
                    return FileVisitResult.CONTINUE;
                }

                Map<String, String> env = new HashMap<>();
                env.put("create", "true");

                try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {

                    Path targetFile = source.relativize(file);
                    Path pathInZipfile = zipfs.getPath(targetFile.toString());

                    // NoSuchFileException, need create parent directories in zip path
                    if (pathInZipfile.getParent() != null) {
                        Files.createDirectories(pathInZipfile.getParent());
                    }

                    // copy file attributes
                    CopyOption[] options = {
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.COPY_ATTRIBUTES,
                            LinkOption.NOFOLLOW_LINKS
                    };
                    // Copy a file into the zip file path
                    Files.copy(file, pathInZipfile, options);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                return FileVisitResult.CONTINUE;
            }

        });

    }
}
