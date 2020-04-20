package edu.umb.cs680.hw07;
import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parentDir,
                 String name,
                 Integer size,
                 LocalDateTime creationTime) {
        super(parentDir, name, size, creationTime);
    }; 

    public Boolean isDirectory() {
        return false;
    }

    public Boolean isFile() {
        return true;
    }

    public Boolean isLink() {
        return false;
    }

   
}

