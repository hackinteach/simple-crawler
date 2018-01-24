package io.muic.cs.ooc.url.downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author hackinteachk.
 */

public class DownloaderV2 extends Downloader {

    public DownloaderV2(URL url) throws IOException {
        super(url);
    }

    public DownloaderV2(String link) throws IOException {
        this(new URL(link));
    }


    public void startDownload(String path) throws IOException {
        checkPath(path);

        try {
            File file = new File(path + "/" + fileName);
            FileUtils.copyURLToFile(url, file);
        } finally {
            System.out.println("V2, File downloaded : " + path + fileName);
        }


    }
}
