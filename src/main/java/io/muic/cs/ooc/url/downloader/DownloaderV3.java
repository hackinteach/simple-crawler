package io.muic.cs.ooc.url.downloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * @author hackinteachk.
 */

public class DownloaderV3 extends Downloader {

    public DownloaderV3(URL url) throws IOException {
        super(url);
    }

    public DownloaderV3(String link) throws IOException {
        this(new URL(link));
    }


    public void startDownload(String path) throws IOException {
        InputStream inputStream = url.openStream();
        checkPath(path);
        try {
            Files.copy(inputStream, new File(path + fileName).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            System.out.println("Error saving files! (V3.)");
        } finally {
            System.out.println("V3, File downloaded : " + path + fileName);
        }

    }
}
