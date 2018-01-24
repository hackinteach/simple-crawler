package io.muic.cs.ooc.directory.walker;

import org.apache.commons.cli.*;


/**
 * @author hackinteachk.
 */

public class ArgumentHandler {

    private Options options;
    private CommandLineParser parser;
    private CommandLine cmd;

    public ArgumentHandler(String[] args) throws ParseException {
        options = new Options();
        parser = new DefaultParser();

        options.addRequiredOption("f", "", true, "Path to the documentation folder.");

        options.addOption("a", "total-num-files", false, "The total number of files");
        options.addOption("b", "total-num-dirs", false, "Total number of directories");
        options.addOption("c", "total-unique-exts", false, "Total number of unique file extensions.");
        options.addOption("d", "list-exts", false, "List all unique file extensions.");
        options.addOption("", "num-ext", true, "List total number of file for specified extension EXT.");

        cmd = parser.parse(options, args);
    }

    public CommandLine getOptions() {
        return cmd;
    }

}
