package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Arrays;

public class ApfsCrawlingVisitor implements ApfsFSVisitor  {

    private ArrayList<ApfsFile> files = new ArrayList<ApfsFile>();

    public void visit(ApfsLink link) { }

    public void visit(ApfsDirectory dir) { }

    public void visit(ApfsFile file) {
        files.add(file);
    }

    public ArrayList<ApfsFile> getFiles() {
        return files;
    }


}

