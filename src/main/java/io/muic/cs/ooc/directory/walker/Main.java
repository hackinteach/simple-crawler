package io.muic.cs.ooc.directory.walker;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {


        ArgumentHandler argHandler = new ArgumentHandler(args);
        CommandLine cmd = argHandler.getOptions();

        File startDirectory = new File(cmd.getOptionValue("f"));

        DirectoryDriver driver = new DirectoryDriver(startDirectory);
        driver.drive(cmd);

    }
}
