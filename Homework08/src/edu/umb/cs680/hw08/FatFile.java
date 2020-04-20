package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class FatFile extends FatFSElement {

    public FatFile(FatDirectory parentDir,
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

}

