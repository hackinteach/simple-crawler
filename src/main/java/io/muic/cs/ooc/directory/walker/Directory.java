package io.muic.cs.ooc.directory.walker;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/**
 * @author hackinteachk.
 */
public class Directory extends DirectoryWalker {

    private File startDirectory;
    private List<String> files;
    private List<String> directories;
    private HashMap<String, Integer> extensionNumber;
    private List<FileHandler> fileHandlers = new ArrayList<>();

    public Directory(File startDirectory) {
        super();

        this.startDirectory = startDirectory;
        extensionNumber = new HashMap<String, Integer>();
        directories = new ArrayList<String>();
        files = new ArrayList<String>();
    }

    @Override
    protected boolean handleDirectory(File directory, int depth, Collection results) throws IOException {
        directories.add(directory.toString());
        // DirectoryHandler, DirectoryCountHanler
        //
        return true;
    }

    @Override
    protected void handleFile(File file, int depth, Collection results) throws IOException {
        files.add(file.toString());
//        for (FileHandler fh : fileHandlers) {
//            fh.handle(file, depth, results);
//        }
    }

    public void start() throws IOException {
        walk(startDirectory, null);
    }

    public int getNumberOfFiles() {
        return files.size();
    }

    public int getNumberOfDirectories() {
        return directories.size();
    }

    public HashMap<String, Integer> getAllExtensions() {
        for (String file : files) {
            String ext = FilenameUtils.getExtension(file);
            if (ext.equals("")) {
                ext = "no extension";
            }
            if (!extensionNumber.containsKey(ext)) {
                extensionNumber.put(ext, 0);
            }
            extensionNumber.put(ext, extensionNumber.get(ext) + 1);
        }
        return extensionNumber;
    }

    public void addFileHandler(FileCountHandler fileHandler) {
        fileHandlers.add(fileHandler);
    }
}
