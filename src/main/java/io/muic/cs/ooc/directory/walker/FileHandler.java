package io.muic.cs.ooc.directory.walker;

import java.io.File;
import java.util.Collection;
/**
 * @author hackinteachk.
 */
public interface FileHandler {

    void buildOption(String[] args);

    void handle(File file, int depth, Collection results);

    void print();
}
