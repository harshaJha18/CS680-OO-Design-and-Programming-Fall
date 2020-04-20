package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parentDir,
                String name,
                LocalDateTime creationTime,
                FSElement target) {
       
        super(parentDir, name, 0, creationTime);
        this.target = target;
    }; 

    public FSElement getTarget() {
        return this.target;
    }

    public Boolean isDirectory() {
        return false;
    }

    public Boolean isLink() {
        return true;
    }


    public Boolean isFile() {
        return false;
    }


}
