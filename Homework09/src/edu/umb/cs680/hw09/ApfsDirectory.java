package edu.umb.cs680.hw09;

import java.util.LinkedList;
import java.time.LocalDateTime;

public class ApfsDirectory extends ApfsFSElement {

    private LinkedList<ApfsFSElement> children;

    public ApfsDirectory(ApfsDirectory parent,
                        String name,
                        LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        children = new LinkedList<ApfsFSElement>();
    }

    public LinkedList<ApfsFSElement> getChildren() {
        return this.children;
    }

    public void appendChild(ApfsFSElement elem) {
        for (ApfsFSElement child : this.children) {
            if (elem.getName() == child.getName()) {
                if (elem.isDirectory() && child.isDirectory()) {
                    throw new RuntimeException("Directory already exist");
                }
                else if (elem.isDirectory() && child.isDirectory()) {
                    throw new RuntimeException("File already exist");
                } else if (elem.isLink() && child.isLink()) {
                    throw new RuntimeException("Link already exist");
                }
            }
        }
        this.children.add(elem);
    }

    protected void accept(ApfsFSVisitor v) {
        v.visit(this);
        for(ApfsFSElement e: children) {
            e.accept(v);
        }        
    }

    protected void deleteChild(FSElement child) {
        this.children.remove(child);
    }

    public Integer countChildren() {
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDirs = new LinkedList<ApfsDirectory>();
        for (ApfsFSElement elem : this.getChildren()) {
            if (elem.isDirectory()) {
                subDirs.add((ApfsDirectory) elem);
            }
        }
        return subDirs;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for (ApfsFSElement elem : this.getChildren()) {
            if (elem.isFile()) {
                files.add((ApfsFile) elem);
            }
        }
        return files;
    }

    protected boolean isEmpty() {
        return this.children.isEmpty();
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

    public Boolean isLink() {
        return false;
    }

}
