package io.muic.cs.ooc.url.crawler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hackinteachk.
 */

public class FileHandler {

    public static boolean isDirectory(String url) {
        String path = null;
        try {
            path = new URL(url).getPath();
        } catch (MalformedURLException e) {
            System.out.println("Error checking isDirectory()");
        }
        return path.lastIndexOf('.') <= 0;
    }

    public static void mkdir(String path) {
        File p = new File(path);
        if (!p.exists()) {
            try {
                FileUtils.forceMkdir(p);
            } catch (IOException e) {
                System.out.println("Error creating directory " + path);
            }
            if (p.exists() && p.isDirectory()) {
                System.out.println("Directory created : " + path);
            }
        }
    }

    public static String getFileName(String link) {
        if (!isDirectory(link)) {
            return link.substring(link.lastIndexOf('/') + 1, link.length());
        } else {
            return "";
        }
    }

    public static String getFolderPath(String link, String parentURL) throws MalformedURLException {
        // "https://cs.muic.mahidol.ac.th/courses/ooc/docs/technotes/guides/index.html"
        // gives ./technotes/guides/
        String ret = "./crawled/" + link.replace(parentURL, "").replace(getFileName(link), "");
        return ret;
    }
}
