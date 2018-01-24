package io.muic.cs.ooc.url.downloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String link = "http://www.ietf.org/rfc/rfc2616.txt";
        String path = "./download/";

//        // Method 1 : URLConnection, URL
//        DownloaderV1 downloaderV1 = new DownloaderV1(link);
//        downloaderV1.startDownload(path);
//
//        // Method 2 : FileHandler
//        DownloaderV2 downloaderV2 = new DownloaderV2(link);
//        downloaderV2.startDownload("./download");
//
//        // Method 3 : StandardCopyOptions
//        DownloaderV3 downloaderV3 = new DownloaderV3(link);
//        downloaderV3.startDownload(path);

        // Deploys each version from factory
        DownloaderFactory factory = new DownloaderFactory();

        Downloader downloaderV1 = factory.create("v1", link, path);
        downloaderV1.startDownload(path);

        Downloader downloaderV2 = factory.create("v2", link, path);
        downloaderV2.startDownload(path);

        Downloader downloaderV3 = factory.create("v3", link, path);
        downloaderV3.startDownload(path);
    }
}
