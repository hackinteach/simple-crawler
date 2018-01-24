package io.muic.cs.ooc.url.downloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author hackinteachk.
 */

public abstract class Downloader implements DownloaderTemplate {

    protected String fileName;
    protected URL url;

    public Downloader(String link) throws IOException {
        this(new URL(link));
    }

    public Downloader(URL url) throws IOException {
        this.url = url;
        fileName = getFilename();
    }

    private String getFilename() {
        String link = url.toString();
        int lastSlashIndex = link.lastIndexOf("/");
        return link.substring(lastSlashIndex + 1);
    }

    protected void checkPath(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}
