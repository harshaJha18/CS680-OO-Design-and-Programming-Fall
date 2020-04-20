package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem{

    private static FileSystem theInstance;
    private LinkedList<Directory> rootDirectories;

    private FileSystem() {
        this.rootDirectories = new LinkedList<Directory>();
    };

    public static FileSystem getFileSystem() {
        if (theInstance == null) {
            theInstance = new FileSystem();
        }
        return theInstance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirectories;
    }

    public void addRootDirectory(Directory dir) {
        this.rootDirectories.add(dir);
    }

    public void erase() {
        this.rootDirectories.clear();
    }


    public void remove(File file) {
        
    }

    public String toString() {
        return "FileSystem: FileSystem instance.";
    }

    

}

