package io.muic.cs.ooc.url.crawler;


/**
 * @author hackinteachk.
 */


public class WordCounter {

    private static long numWords = 0;

    public static void countWord(String text){
//        for(int i=0;i<sentence.length();i++){
//            char ch = sentence.charAt(i);
//            if(ch == ' ' || ch == '.'){
//                numWords+=1;
//            }
//        }
        numWords += text.split(" ").length;
    }

    public static long getNumWords() {
        return numWords;
    }
}
