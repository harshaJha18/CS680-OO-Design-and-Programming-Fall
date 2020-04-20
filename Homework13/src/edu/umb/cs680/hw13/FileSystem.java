package edu.umb.cs680.hw13;

import java.util.LinkedList;
import java.time.LocalDateTime;

public abstract class FileSystem {

    private String name;
    private Integer capacity;
    private Integer id;

    protected FileSystem() {} 

    public FSElement initFileSystem(String name,
                                    Integer capacity){
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
       
        if (root.getSize() > capacity) {
            throw new RuntimeException("Isufficient capacity to initialize filesystem");
        }
        setDefaultRoot(root);
        return root;
    }

    protected abstract FSElement createDefaultRoot() ;
 
    protected abstract void setDefaultRoot(FSElement dir) ;

    protected abstract FSElement getDefaultRoot() ;

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getUsed() ;
  
    public int getRemaining() {
        return getCapacity() - getUsed();
    }

    
    public abstract void erase() ;


    public String toString() {
        return "FileSystem: FileSystem instance.\n";
    }

    public static void main(String args[]) {
        FileSystem apfs = APFS.getFileSystem();
        System.out.println(apfs.toString());
    }
}
