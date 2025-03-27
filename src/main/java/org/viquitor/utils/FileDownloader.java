package org.viquitor.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class FileDownloader {
    public void downloadFile(String fileUrl, String savePath) throws IOException {
        if (!fileUrl.startsWith("http")) {
            fileUrl = Constants.BASE_URL + (fileUrl.startsWith("/") ? "" : "/") + fileUrl;
        }

        URI uri = URI.create(fileUrl);
        try (InputStream in = uri.toURL().openStream();
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}