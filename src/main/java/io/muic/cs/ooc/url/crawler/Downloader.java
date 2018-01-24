package io.muic.cs.ooc.url.crawler;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

import static io.muic.cs.ooc.url.crawler.FileHandler.*;

/**
 * @author hackinteachk.
 */

public class Downloader {

    public static HashSet<String> downloaded = new HashSet<>();

    public static void download(String url, String folder) {
        if (downloaded.contains(url)) {
            return;
        }
        if (isDirectory(url)) {
            mkdir(folder);
        } else {
            String fileName = getFileName(url);

            if (fileName.contains("#") || fileName.contains("?")) {
                return;
            }

            File file = new File(folder + fileName);

            if (file.exists()) {
                System.out.println("DUPLICATE!");
                return;
            }
            try {
                FileUtils.copyURLToFile(new URL(url), file);
            } catch (IOException e) {
                System.out.println("Error saving file : " + folder + fileName);
            } finally {
                if (file.exists() && file.isFile()) {
                    downloaded.add(url);
                    System.out.println("File downloaded : " + folder + fileName);
                }
            }

        }
    }


}
