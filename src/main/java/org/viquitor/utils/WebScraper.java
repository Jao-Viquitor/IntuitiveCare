package org.viquitor.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private final String url;

    public WebScraper(String url) {
        this.url = url;
    }

    public List<String> extractPdfLinks() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(Constants.PDF_SELECTOR);
        List<String> pdfLinks = new ArrayList<>();

        for (Element link : links) {
            String linkText = link.text().toLowerCase();
            String href = link.attr("href");

            if (linkText.contains(Constants.ANNEX_I_TEXT) || linkText.contains(Constants.ANNEX_II_TEXT) ||
                    href.contains(Constants.ANNEX_I_HREF) || href.contains(Constants.ANNEX_II_HREF)) {
                pdfLinks.add(href);
            }
        }
        return pdfLinks;
    }
}