package io.muic.cs.ooc.url.downloader;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author hackinteachk.
 */

public class DownloaderV1 extends Downloader {

    private URLConnection urlConnection;
    private InputStream inputStream;
    private OutputStream outputStream;

    public DownloaderV1(String link) throws IOException {
        this(new URL(link));
    }

    public DownloaderV1(URL url) throws IOException {
        super(url);
        urlConnection = url.openConnection();
        inputStream = urlConnection.getInputStream();
    }

    public void startDownload(String path) throws IOException {
        checkPath(path);
        try (FileOutputStream fout = new FileOutputStream("")) {
            outputStream = new BufferedOutputStream(new FileOutputStream(path + fileName));

            byte[] buffer = new byte[1024];

            int numRead;
            while ((numRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, numRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("V1, File downloaded : " + path + fileName);
        }
    }


}
