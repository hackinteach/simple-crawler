package io.muic.cs.ooc.url.downloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hackinteachk.
 */

public class DownloaderFactory {

    private static Map<String, Class<? extends Downloader>> knownDownloader = new HashMap<>();


    static {
        knownDownloader.put("v1", DownloaderV1.class);
        knownDownloader.put("v2", DownloaderV2.class);
        knownDownloader.put("v3", DownloaderV3.class);
    }

    public static Downloader create(String version, String link, String path) throws IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Downloader> downloader = knownDownloader.get(version);
        if (downloader != null) {
            Downloader d = downloader.getDeclaredConstructor(String.class).newInstance(link);
            return d;
        }
        System.out.println("Version not found!");
        return null;
    }
}
