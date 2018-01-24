package io.muic.cs.ooc.directory.walker;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.IOException;
import java.util.Map;
/**
 * @author hackinteachk.
 */
public class DirectoryDriver {
    private File startDirectory;
    private int numberOfFiles, numberOfExtensions, numberOfDirectories;
    private Map<String, Integer> extensions;
    private Directory directory;
    private Options options;
    private Map<String, Boolean> arguments;

    public DirectoryDriver(File startDirectory) throws IOException {
        this.startDirectory = startDirectory;

        directory = new Directory(startDirectory);
        directory.addFileHandler(new FileCountHandler());
        directory.start();

        numberOfFiles = directory.getNumberOfFiles();
        numberOfDirectories = directory.getNumberOfDirectories();
        extensions = directory.getAllExtensions();
        numberOfExtensions = extensions.size();
    }

//    public void drive() {
//        System.out.printf("Total number of Files : %d\n", numberOfFiles);
//        System.out.printf("Total number of Directories : %d\n", numberOfDirectories);
//        System.out.printf("Total number of Extensions : %d\n", numberOfExtensions);
//        System.out.println(" ");
//        System.out.printf("List of number of all extensions in folder : %s.\n", startDirectory.getName());
//        for (String ext : extensions.keySet()) {
//            System.out.printf("%s : %d\n", ext, extensions.get(ext));
//        }
//    }

    public void drive(CommandLine cmd) {

        if (cmd.hasOption("a")) {
            System.out.printf("Total number of Files : %d.\n", numberOfFiles);
        }
        if (cmd.hasOption("b")) {
            System.out.printf("Total number of Directories : %d.\n", numberOfDirectories);
        }
        if (cmd.hasOption("c")) {
            System.out.printf("Total number of unique extension : %d.\n", numberOfExtensions);
        }
        if (cmd.hasOption("d")) {
            System.out.printf("Listing all extensions exists in folder %s...\n", startDirectory);
            for (String ext : extensions.keySet()) {
                System.out.println(ext);
            }
        }
        if (cmd.hasOption("num-ext")) {
            String ext = cmd.getOptionValue("num-ext");
            System.out.printf("%s : %d\n", ext, extensions.get(ext));
        }

    }
}
