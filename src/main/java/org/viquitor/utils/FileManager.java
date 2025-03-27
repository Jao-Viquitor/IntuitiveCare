package org.viquitor.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public void createDirectory(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }

    public String generateFileName(String url) {
        String fileName = url.substring(url.lastIndexOf(Constants.PATH_SEPARATOR) + 1);
        if (!fileName.toLowerCase().endsWith(Constants.PDF_EXTENSION)) {
            fileName += Constants.PDF_EXTENSION;
        }
        return fileName;
    }

    public String getResourcePath(String fileName) {
        return Constants.RESOURCES_DIR + "/" + fileName;
    }
}