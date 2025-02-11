package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name,LocalDateTime creationTime) {
       
        super(parent, name, 0, creationTime);
        children = new LinkedList<FSElement>();
    }; 

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement elem) {
        for (FSElement child : this.children) {
            if (elem.getName() == child.getName()) {
                if (elem.isDirectory() && child.isDirectory()) {
                    throw new RuntimeException("Directory already exist");
                }
                else if (elem.isDirectory() && child.isDirectory()) {
                    throw new RuntimeException("File already exist");
                }
            }
        }
        this.children.add(elem);
    }


    public Integer countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<Directory>();
        for (FSElement elem : this.getChildren()) {
            if (elem.isDirectory()) {
                subDirs.add((Directory) elem);
            }
        }
        return subDirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement elem : this.getChildren()) {
            if (elem.isFile()) {
                files.add((File) elem);
            }
        }
        return files;
    }


    public Integer getTotalSize() {
        int fileSum = getFiles().stream().mapToInt(f->f.getSize()).sum();
        int dirSum = getSubDirectories().stream().mapToInt(d->d.getTotalSize()).sum();
        return fileSum + dirSum + this.getSize();
    }

    public Boolean isDirectory() {
        return true;
    }

    public Boolean isFile() {
        return false;
    }

   
}

