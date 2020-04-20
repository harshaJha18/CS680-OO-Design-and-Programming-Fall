package edu.umb.cs680.hw09;

import java.util.LinkedList;
import java.time.LocalDateTime;

public class APFS extends FileSystem {

    private static APFS theInstance;
    private static String defaultName = "The APFS filesystem";
    private static int defaultCapacity = 1000000000;


    private static String defaultRootName = "TheAPFSRoot";

    private ApfsDirectory rootDir;

    public static APFS getFileSystem() {
        if (theInstance == null) {
            theInstance = new APFS();
            theInstance.initFileSystem(defaultName, defaultCapacity);
        }
        return theInstance;
    }

    protected ApfsDirectory createDefaultRoot() {
        return new ApfsDirectory(null, defaultRootName, LocalDateTime.now());
    }

    protected ApfsDirectory getDefaultRoot() {
        return this.rootDir;
    }

    protected void setDefaultRoot(FSElement dir) {
        this.rootDir = (ApfsDirectory) dir;
    }

    public ApfsDirectory getRootDir() {
        return this.getDefaultRoot();
    }

    public void setRootDir(ApfsDirectory dir) {
        this.setDefaultRoot(dir);
    }

    public int getUsed() {
        if (this.rootDir == null) {
            return 0;
        }
        return this.getRootDir().getTotalSize();
    }

   
    public void erase() {
        this.setDefaultRoot(null);        
        
    }

    public String toString() {
        return "Filesystem: APFS FileSystem instance";
    }


    public static void main(String[] args) {
        APFS apfs = getFileSystem();
        System.out.println(apfs);
    }

}
