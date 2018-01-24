package io.muic.cs.ooc.directory.walker;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.util.Collection;
/**
 * @author hackinteachk.
 */
public class FileCountHandler implements FileHandler {

    private long count;
    private Options options;
    private DefaultParser parser;
    private CommandLine cmd;

    @Override
    public void buildOption(String[] args) {
        options = new Options();
        parser = new DefaultParser();

        options.addRequiredOption("f", "", true, "Path to the documentation folder.");

        options.addOption("a", "total-num-files", false, "The total number of files");
        options.addOption("b", "total-num-dirs", false, "Total number of directories");
        options.addOption("c", "total-unique-exts", false, "Total number of unique file extensions.");
        options.addOption("d", "list-exts", false, "List all unique file extensions.");
        options.addOption("", "num-ext", true, "List total number of file for specified extension EXT.");

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("Error passing argument args[]");
        }
    }

    @Override
    public void handle(File file, int depth, Collection results) {
        count++;
    }

    @Override
    public void print() {

    }
}
