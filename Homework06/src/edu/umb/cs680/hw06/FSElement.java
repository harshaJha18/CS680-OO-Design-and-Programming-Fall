package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected Directory parent;
    private String name;
    private Integer size;
    private LocalDateTime creationTime;

    protected FSElement(Directory parent,
                        String name,
                        Integer size,
                        LocalDateTime creationTime) {

        if (parent != null) {
            parent.appendChild(this);
            this.parent = parent;
        }
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public FSElement getParent() {
        return this.parent;
    }

     public String getName() {
        return this.name;
    }

    public Integer getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public abstract Boolean isDirectory() ;

    public abstract Boolean isFile() ;


    public String toString() {
        return this.getName();
    }

   

}
