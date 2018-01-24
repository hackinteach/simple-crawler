package io.muic.cs.ooc.url.downloader;

import java.io.IOException;

/**
 * @author hackinteachk.
 */

public interface DownloaderTemplate {

    void startDownload(String path) throws IOException;

}
