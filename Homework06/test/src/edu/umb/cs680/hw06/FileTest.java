package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.time.LocalDateTime;

class FileTest{
    private static FileSystem fs;
    private static LocalDateTime datetime;
    private static Directory root;
    private static Directory system;
    private static File a;
    private static File b;
    private static File c;
    private static Directory home;
    private static File d;
    private static Directory pictures;
    private static File e;
    private static File f;

    @BeforeAll
    public static void setUp() {
        fs = FileSystem.getFileSystem();
        datetime = LocalDateTime.of(2042, 12, 31, 12, 0);
        root = new Directory(null, "root", datetime);
        system = new Directory(root, "system", datetime);
        a = new File(system, "a", 1, datetime);
        b = new File(system, "b", 2, datetime);
        c = new File(system, "c", 3, datetime);
        home = new Directory(root, "home", datetime);
        d = new File(home, "d", 4, datetime);
        pictures = new Directory(home, "pictures", datetime);
        e = new File(pictures, "e", 5, datetime);
        f = new File(pictures, "f", 6, datetime);
    }


    private String[] fileToStringArray(File f){
        String[] fileInfo = {
            f.isFile().toString(), f.isDirectory().toString(),
            f.getName(), f.getParent().getName(),
            f.getSize().toString(), 
            f.getCreationTime().toString(),
        };
        return fileInfo;
    }

    @Test
    public void verifyFileEqualityA() {
        String[] expected = {"true", "false",
                             "a", "system",
                             "1",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = {"true", "false",
                             "b", "system",
                             "2",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEqualityC() {
        String[] expected = {"true", "false",
                             "c", "system",
                             "3",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void verifyFileEqualityD() {
        String[] expected = {"true", "false",
                             "d", "home",
                             "4",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(d);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEqualityE() {
        String[] expected = {"true", "false",
                             "e", "pictures",
                             "5",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(e);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEqualityF() {
        String[] expected = {"true", "false",
                             "f", "pictures",
                             "6",
                             datetime.toString(),
        };
        String[] actual = fileToStringArray(f);
        assertArrayEquals(expected, actual);
    }

    @AfterAll
    public static void doSomething() {
        fs.erase();
    }

}

