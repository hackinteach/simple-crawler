package io.muic.cs.ooc.url.crawler;

import java.net.MalformedURLException;


/**
 * @author hackinteachk.
 */
public class Main {

    public static void main(String[] args) {

        String link = "https://cs.muic.mahidol.ac.th/courses/ooc/docs/";

        Crawler crawler = new Crawler();
        try {
            crawler.craw(link);
            System.out.printf("Total number of words : %d\n",crawler.getNumWords());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
