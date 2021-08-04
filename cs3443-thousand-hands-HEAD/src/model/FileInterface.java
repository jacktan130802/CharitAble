package model;

import java.io.*;

public interface FileInterface {
    public String readFile(String file);
    public FileOutputStream writeFile(String file, boolean append) throws FileNotFoundException;

}
