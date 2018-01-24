package io.muic.cs.ooc.url.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static io.muic.cs.ooc.url.crawler.Downloader.download;
import static io.muic.cs.ooc.url.crawler.Downloader.downloaded;
import static io.muic.cs.ooc.url.crawler.FileHandler.getFileName;
import static io.muic.cs.ooc.url.crawler.FileHandler.getFolderPath;

/**
 * @author hackinteachk.
 */

public class Crawler {

    private Set<String> processed = new HashSet<>();
    private Stack<String> foundLinks = new Stack<>();
    private String parentURL;
    private Document document;
    private WordCounter wordCounter = new WordCounter();

    public Crawler() {

    }

    public Crawler(Set<String> processed, String parentURL) {
        this.processed.addAll(processed);
        this.parentURL = parentURL;
    }

    public long getNumWords() {
        return wordCounter.getNumWords();
    }

    public void craw(String link) throws MalformedURLException {
        if (parentURL == null) {
            parentURL = link.replace(getFileName(link), "");
        }

        System.out.println("PROCESSING : " + link);

        processed.add(link);
        try {
            document = Jsoup.connect(link).get();
            if (document != null) {
                Element body = document.body();
                if (body != null) {
                    String text = body.text();
                    wordCounter.countWord(text);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't connect to url : " + link);
            return;
        }finally{

        }

        try {
            String processingURL = document.location();
            download(processingURL, getFolderPath(processingURL, parentURL));
        } catch (NullPointerException e) {
            System.out.println("NULL");
        }

        query("href");
        query("src");

        while (!foundLinks.isEmpty()) {
            String nextLink = foundLinks.pop();
            Crawler crawler = new Crawler(processed, parentURL);
            if (!processed.contains(nextLink)) {
                crawler.craw(nextLink);
            }
        }
    }

    private boolean validDomain(String url) {
//        URL main = new URL(parentURL);
//        URL sub = new URL(url);
//        String mainPath = main.getPath();
//        String subPath = sub.getPath();
//        subPath = subPath.replace(getFileName(url),"");
//        return subPath.length() >= mainPath.length() && sub.getHost().equals(main.getHost());
        return url.contains(parentURL) && !url.contains("#") && !url.contains("?");
    }

    private void query(String attr) {
        Elements elements = document.select("[" + attr + "]");
        for (Element element : elements) {
            String absLink = element.absUrl(attr);
            if (validDomain(absLink) && !downloaded.contains(absLink)) {
                try {
                    String folder = getFolderPath(absLink, parentURL);
                    download(absLink, folder);
                    if (absLink.contains(".html")) {
                        foundLinks.push(absLink);
                    }
                } catch (MalformedURLException e) {
                    System.out.println("Can't get folder path : " + absLink);
                }
            }
        }
    }
}