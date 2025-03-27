package org.viquitor;

import org.viquitor.utils.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager();
            fileManager.createDirectory(Constants.RESOURCES_DIR);
            fileManager.createDirectory(Constants.PUBLIC_DIR);

            WebScraper scraper = new WebScraper(Constants.TARGET_URL);
            FileDownloader downloader = new FileDownloader();
            ZipCreator zipCreator = new ZipCreator();

            String targetPdfName = Constants.ANNEX_I_NAME;
            String csvFileName = Constants.CSV_FILE_NAME;
            String pdfPath = null;
            String csvPath = fileManager.getResourcePath(csvFileName);
            String zipPath = Constants.PUBLIC_DIR + Constants.MY_NAME;

            List<String> pdfLinks = scraper.extractPdfLinks();
            for (String link : pdfLinks) {
                String fileName = fileManager.generateFileName(link);
                String savePath = fileManager.getResourcePath(fileName);
                downloader.downloadFile(link, savePath);
                System.out.println("Download concluído: " + fileName);

                if (fileName.equals(targetPdfName)) {
                    pdfPath = savePath;
                }
            }

            if (pdfPath != null) {
                zipCreator.createZip(csvPath, zipPath);
                System.out.println("Arquivo compactado em: " + zipPath);
            } else {
                System.out.println("O PDF 'anexo_i.pdf' não foi encontrado entre os downloads.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}